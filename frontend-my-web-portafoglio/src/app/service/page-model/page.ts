export interface Page<T> {
    content: T[];
    numeroPagina: number;
    quantitaPagina: number;
    campo: string;
    ordine: string;
}