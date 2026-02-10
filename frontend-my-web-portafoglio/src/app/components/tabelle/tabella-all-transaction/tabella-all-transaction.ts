import { Component, Input } from '@angular/core';
import { AllTransactionDTO, AllTransactionService } from '../../../service/allTransaction-service/all-transaction-service';
import { Arrow } from "../../arrow/arrow";
import { CurrencyPipe, DatePipe } from '@angular/common';

@Component({
  selector: 'app-tabella-all-transaction',
  imports: [CurrencyPipe, DatePipe, Arrow],
  templateUrl: './tabella-all-transaction.html',
  styleUrl: './tabella-all-transaction.css',
})
export class TabellaAllTransaction {
  @Input() allTransaction: AllTransactionDTO[] = [];

  constructor(private allTransactionService: AllTransactionService) {}

  ngOnInit(): void {
    this.allTransactionService.getAllTransaction().subscribe({
      next: (data) => (this.allTransaction= data),
      error: (error) => console.error('Errore nel caricamento dei dati.', error)
    });
  }
}
