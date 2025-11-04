import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UscitaDTO, UscitaService } from './service/uscita';
import { Sidebar } from "./modules/sidebar/sidebar";
import { Navbar } from "./modules/navbar/navbar";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Sidebar, Navbar],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{
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
