import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../page-model/page';

export interface UscitaDTO {
  id: number;
  dataSpesa: string;
  importo: number;
  descrizione: string;
  categoriaSpesa: string;
}
@Injectable({
  providedIn: 'root',
})
export class UscitaService {
  private apiUrl = 'http://localhost:8081/api/uscite';

  constructor(private http: HttpClient) {}

  getUscite(): Observable<UscitaDTO[]> {
    return this.http.get<UscitaDTO[]>(this.apiUrl);
  }

  getUsciteOrdinate(
    campo: string,
    ordine: 'asc' | 'desc'
  ): Observable<UscitaDTO[]> {
    return this.http.get<UscitaDTO[]>(`${this.apiUrl}/${campo}/${ordine}`);
  }

  getUscitePaginate(
    page: number,
    size: number,
    campo: string,
    ordine: 'asc' | 'desc'
  ): Observable<Page<UscitaDTO>> {
    const params = new HttpParams()
      .set('numeroPagina', page)
      .set('quantitaPagina', size)
      .set('campo', campo)
      .set('ordine', ordine);
    return this.http.get<Page<UscitaDTO>>(`${this.apiUrl}/page`, { params });
  }
}
