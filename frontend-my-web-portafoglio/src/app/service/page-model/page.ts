export interface Page<T> {
    content: T[];
    numeroPagina: number;
    quantitaPagina: number;
    campo: string;
    ordine: string;
    empty: boolean;
    first: boolean;
    last: boolean;
    totalePagine: number;
    totaleElementi: number;
}