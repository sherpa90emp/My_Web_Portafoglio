import { Component, OnInit, signal } from '@angular/core';
import { UscitaDTO, UscitaService } from '../../../service/uscita';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-tabella',
  imports: [CurrencyPipe],
  templateUrl: './tabella-uscite.html',
  styleUrl: './tabella-uscite.css',
})
export class Tabella implements OnInit {
  protected readonly title = signal('frontend-my-web-portafoglio');

  uscite: UscitaDTO[] = [];

  constructor(private uscitaService: UscitaService) {}

  ngOnInit(): void {
    this.uscitaService.getUscite().subscribe({
      next: (data) => this.uscite = data,
      error: (error) => console.error('Errore nel caricamento dei dati', error)
    });
  }
}
