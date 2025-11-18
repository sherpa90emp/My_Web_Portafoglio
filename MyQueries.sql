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