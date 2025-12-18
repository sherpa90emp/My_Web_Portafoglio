import { Component, Input, OnInit } from '@angular/core';
import { EntrataDTO, EntrataService } from '../../../service/entrata-service/entrata';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { Arrow } from "../../arrow/arrow";

@Component({
  selector: 'app-tabella-entrate',
  imports: [CurrencyPipe, DatePipe, Arrow],
  templateUrl: './tabella-entrate.html',
  styleUrl: './tabella-entrate.css',
})
export class TabellaEntrate implements OnInit {
  @Input() entrate: EntrataDTO[] = [];

  constructor(private entrataService: EntrataService) {}

  ngOnInit(): void {
    this.entrataService.getEntrate().subscribe({
      next: (data) => this.entrate = data,
      error: (error) => console.error('Errore nel caricamento dei dati', error)
    })
  }
}
