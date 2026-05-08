import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

export interface AllTransactionDTO {
  id: number;
  importo: number;
  descrizione: string;
  data: string;
  categoria: string;
  tipo: string;
}
@Injectable({
  providedIn: 'root',
})
export class AllTransactionService {
  private apiUrl = `${environment.apiUrl}/api/alltransaction`;

  constructor(private http: HttpClient) {}

  getAllTransaction(): Observable<AllTransactionDTO[]> {
    return this.http.get<AllTransactionDTO[]>(this.apiUrl)
  }
}
