import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './components/navbar/navbar';
import { Tabella } from './components/tabelle/tabella-uscite/tabella-uscite';
import { UscitaDTO, UscitaService } from './service/uscita';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Tabella],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
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
