-- Ottenere solo le transizioni per descrizione tramite parola chiave
SELECT
    `id_spesa`,
    `data_spesa`,
    `descrizione`,
    `importo`
FROM
    `spese_effettuate`
WHERE
    descrizione LIKE '%Paypal%';

-- Numero di transizioni per descrizione tramite parola chiave
SELECT
    COUNT(`descrizione`) AS `Totale transizioni Paypal`
FROM
    `spese_effettuate`
WHERE
    descrizione LIKE '%Paypal%';

-- Modifica della descrizione per ogni record trovato con parola chiave
UPDATE `spese_effettuate`
SET
    `descrizione` = CASE id_spesa
        WHEN 23 THEN 'PayPal - Italo Treno'
        WHEN 46 THEN 'PayPal - Italo Treno'
        WHEN 77 THEN 'PayPal - DeporVillage'
        WHEN 106 THEN 'PayPal - Sony Network'
        WHEN 255 THEN 'PayPal - Yakoubi Tours'
        WHEN 297 THEN 'PayPal - Blizzard'
        WHEN 339 THEN 'PayPal - Ozone'
        WHEN 366 THEN 'PayPal - Holafly'
        WHEN 436 THEN 'PayPal - Register.it'
        WHEN 440 THEN 'PayPal - Deliveroo'
        WHEN 495 THEN 'PayPal - Oficine 08'
        WHEN 504 THEN 'PayPal - Deliveroo'
        WHEN 544 THEN 'PayPal - Ebay'
        WHEN 545 THEN 'PayPal - Sony Network'
        WHEN 678 THEN 'PayPal - Deliveroo'
        WHEN 700 THEN 'PayPal - Deliveroo'
        WHEN 740 THEN 'PayPal - Century Genius'
        WHEN 764 THEN 'PayPal - Regalo Nascita'
        WHEN 781 THEN 'PayPal - Deliveroo'
        WHEN 783 THEN 'PayPal - Deliveroo'
    END
WHERE
    id_spesa IN (
        23,
        46,
        77,
        106,
        255,
        297,
        339,
        366,
        436,
        440,
        495,
        504,
        544,
        545,
        678,
        700,
        740,
        764,
        781,
        783
    );

-- Otenere sia le transazioni in entrata che in uscita ordinate in modo decrescente per data
SELECT
    s.data_spesa AS `data`,
    s.descrizione,
    s.importo,
    c.nome_categoria AS `categoria`
FROM
    `spese_effettuate` AS s
    LEFT JOIN `categorie_spesa` AS c ON s.id_categoria = c.id_categoria
UNION ALL
SELECT
    e.data_entrata AS `data`,
    e.descrizione,
    e.importo,
    NULL AS `categoria`
FROM
    `entrate` AS e
ORDER BY
    `data` DESC;


CREATE VIEW vista_movimenti AS
SELECT
    CONCAT('U', id_spesa) AS id_univoco, data_spesa AS data, importo, descrizione, id_categoria AS categoria, 'USCITA' AS tipo FROM spese_effettuate
UNION ALL
SELECT
    CONCAT('E',id_entrate) AS id_univoco, data_entrata AS data, importo, descrizione, NULL AS categoria, 'ENTRATA' AS tipo FROM entrate

CREATE or REPLACE VIEW vista_movimenti AS
SELECT 
	CONCAT('E', e.id_entrata) AS id_univoco,
    e.data_entrata AS data,
    e.importo,
    e.descrizione,
    'ENTRATA' AS tipo,
    NULL AS categoria
FROM entrate e

UNION ALL

SELECT
	CONCAT('U', s.id_spesa) AS id_univoco,
    s.data_spesa AS data,
    s.importo,
    s.descrizione,
    'USCITA' AS tipo,
    c.nome_categoria AS nome_categoria
FROM spese_effettuate s
LEFT JOIN categorie_spesa c ON s.id_categoria = c.id_categoria;

-- Procedura SQL per passare dati dalla tabella di staging alla tabella finale composizione_MSCI_World con relativa manipolazione di dati
DECLARE _id_comp_asset INT; -- dichiaro le variabili per ogni colonna
DECLARE _asset_id INT;
DECLARE _ticker VARCHAR(30);
DECLARE _nome_asset VARCHAR(100);
DECLARE _settore VARCHAR(40);
DECLARE _tipo_asset VARCHAR(30);
DECLARE _valore_mercato DECIMAL(12,2);
DECLARE _ponderazione DECIMAL(4,2);
DECLARE _valore_nozionale DECIMAL(12,2);
DECLARE _nominale DECIMAL(14,2);
DECLARE _prezzo DECIMAL(12,2);
DECLARE _area_geografica VARCHAR(40);
DECLARE _cambio VARCHAR(50);
DECLARE _valuta CHAR(3);
DECLARE _isLatest INT DEFAULT 0; -- dichiaro la variabile per il fine ciclo
DECLARE myCursor CURSOR FOR -- dichiaro il cursore per la tabella da cui preleva i dati riga per riga
SELECT id_comp_asset, asset_id, ticker, nome_asset, settore, tipo_asset, valore_mercato, ponderazione, valore_nozionale, nominale, prezzo, area_geografica, cambio, valuta -- dichiaro le colonne che il cursore deve prelevare
FROM staging_comp_MSCI_World; -- tabella da cui prelevare i dati
DECLARE CONTINUE HANDLER FOR NOT FOUND SET _isLatest = 1; -- gestione eccezione
DELETE FROM composizione_MSCI_World; -- svuoto la tabella di destinazione
OPEN myCursor; -- apro il cursore
FETCH myCursor INTO _id_comp_asset, _asset_id, _ticker, _nome_asset, _settore, _tipo_asset, _valore_mercato, _ponderazione, _valore_nozionale, _nominale, _prezzo, _area_geografica, _cambio, _valuta; -- estrae i dati e le salva nelle variabili temporanee precedentemente dichiarate
WHILE _isLatest = 0 DO  -- inizio del ciclo
    IF _tipo_asset = 'Azionario' THEN
    SET _tipo_asset = 'Azione';
    END IF;
    IF _tipo_asset = 'Contanti' OR _tipo_asset LIKE 'Cash%'THEN
    SET _tipo_asset = 'Cash';
    END IF; 
    IF _tipo_asset = 'FX' THEN
    SET _tipo_asset = 'Forex';
    END IF;
    IF _cambio IS NULL THEN
    SET _cambio = ' ';
    END IF;
    IF _area_geografica IS NULL THEN
    SET _area_geografica = ' ';
    END IF;
    IF _ticker IS NULL THEN
    SET _ticker = ' ';
    END IF;
    INSERT INTO composizione_MSCI_World(id_comp_asset, asset_id, ticker, nome_asset, settore, tipo_asset, valore_mercato, ponderazione, valore_nozionale, nominale, prezzo, area_geografica, cambio, valuta)
    VALUES (_id_comp_asset, _asset_id, _ticker, _nome_asset, _settore, _tipo_asset, _valore_mercato, _ponderazione, _valore_nozionale, _nominale, _prezzo, _area_geografica, _cambio, _valuta);
    FETCH myCursor INTO _id_comp_asset, _asset_id, _ticker, _nome_asset, _settore, _tipo_asset, _valore_mercato, _ponderazione, _valore_nozionale, _nominale, _prezzo, _area_geografica, _cambio, _valuta;
END WHILE;
CLOSE myCursor;
END
    
