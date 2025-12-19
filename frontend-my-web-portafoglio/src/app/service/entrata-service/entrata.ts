import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
  private apiUrl = 'http://localhost:8081/api/entrate';
  
  constructor(private http: HttpClient) {}
    getEntrate(): Observable<EntrataDTO[]> {
      return this.http.get<EntrataDTO[]>(this.apiUrl);
    }

    getEntrateOrdinate(
      campo: string,
      ordine: 'asc' | 'desc'
    ): Observable<EntrataDTO[]> {
      return this.http.get<EntrataDTO[]>(`this.apiUrl/${campo}/${ordine}`)
    }
}
