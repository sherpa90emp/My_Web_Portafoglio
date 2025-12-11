import { Component, Input, OnInit } from '@angular/core';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { UscitaDTO, UscitaService } from '../../../service/uscita';

@Component({
  selector: 'app-tabella',
  imports: [CurrencyPipe, DatePipe],
  templateUrl: './tabella-uscite.html',
  styleUrl: './tabella-uscite.css',
})
export class Tabella implements OnInit{
  @Input() uscite: UscitaDTO[] = [];

  constructor(private uscitaService: UscitaService) {}

  ngOnInit(): void {
    this.uscitaService.getUscite().subscribe({
      next: (data) => this.uscite = data,
      error: (error) => console.error('Errore nel caricamento dei dati', error)
    });
  }
}
