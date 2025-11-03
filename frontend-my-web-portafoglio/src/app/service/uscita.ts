import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
}


