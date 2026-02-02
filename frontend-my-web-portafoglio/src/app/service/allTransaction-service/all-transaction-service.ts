import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface AllTransactionDTO {
  id: number;
  importo: number;
  descrizione: string;
  data: string;
  categoria: string;
  tipoTransazione: string;
}
@Injectable({
  providedIn: 'root',
})
export class AllTransactionService {
  private apiUrl = "https://localhost:8081/api/alltransaction";

  constructor(private http: HttpClient) {}

  getAllTransaction(): Observable<AllTransactionDTO[]> {
    return this.http.get<AllTransactionDTO[]>(this.apiUrl)
  }
}
