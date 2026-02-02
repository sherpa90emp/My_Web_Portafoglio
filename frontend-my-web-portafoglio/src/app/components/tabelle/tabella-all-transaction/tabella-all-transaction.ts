import { Component, Input } from '@angular/core';
import { AllTransactionDTO, AllTransactionService } from '../../../service/allTransaction-service/all-transaction-service';

@Component({
  selector: 'app-tabella-all-transaction',
  imports: [],
  templateUrl: './tabella-all-transaction.html',
  styleUrl: './tabella-all-transaction.css',
})
export class TabellaAllTransaction {
  @Input() allTransaction: AllTransactionDTO[] = [];

  constructor(private allTransactionService: AllTransactionService) {}

  ngOninit(): void {
    this.allTransactionService.getAllTransaction().subscribe({
      next: (data) => (this.allTransaction= data),
      error: (error) => console.error('Errore nel caricamento dei dati.', error)
    });
  }
}
