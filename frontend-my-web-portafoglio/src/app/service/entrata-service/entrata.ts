import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../page-model/page';
import { environment } from '../../../environments/environment';

export interface EntrataDTO {
  id: number;
  importo: number;
  descrizione: string;
  dataEntrata: string;
}
@Injectable({
  providedIn: 'root',
})
export class EntrataService {
  private apiUrl = `${environment.apiUrl}/api/entrate`;
  
  constructor(private http: HttpClient) {}

  getEntrate(): Observable<EntrataDTO[]> {
    return this.http.get<EntrataDTO[]>(this.apiUrl);
  }

  getEntrateOrdinate(
    campo: string,
    ordine: 'asc' | 'desc'
  ): Observable<EntrataDTO[]> {
    return this.http.get<EntrataDTO[]>(`${this.apiUrl}/${campo}/${ordine}`)
  }

  getPaginaEntrate(
    page: number, 
    size: number,
    campo: string,
    ordine: 'asc' | 'desc'
  ): Observable<Page<EntrataDTO>> {
    const params = new HttpParams()
      .set('numeroPagina', page)
      .set('quantitaPagina', size)
      .set('campo', campo)
      .set('ordine', ordine);
    return this.http.get<Page<EntrataDTO>>(`${this.apiUrl}/page`, { params });
  }
}
