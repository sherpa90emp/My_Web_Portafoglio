import { Component, OnInit } from '@angular/core';
import { EntrataDTO, EntrataService } from '../../../service/entrata-service/entrata';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { Arrow } from '../../arrow/arrow';
import { Subject, switchMap } from 'rxjs';
import { Page } from '../../../service/page-model/page';

@Component({
  selector: 'app-tabella-entrate',
  imports: [CurrencyPipe, DatePipe, Arrow],
  templateUrl: './tabella-entrate.html',
  styleUrl: './tabella-entrate.css',
})
export class TabellaEntrate implements OnInit {
  entrate: EntrataDTO[] = [];
  
  paginaEntrate: Page<EntrataDTO> | null = null;
  numeroPagina = 0;
  quantitaPagina = 20;
  campo: 'dataEntrata' | 'importo' = 'dataEntrata';
  ordine: 'asc' | 'desc' = 'desc';



  constructor(private entrataService: EntrataService) {}

  private sort$ = new Subject<{ campo: 'dataEntrata' | 'importo'; direzione: 'asc' | 'desc' }>();

  ngOnInit(): void {
    this.caricaEntratePaginate();
  }

  ordina(campo: 'dataEntrata' | 'importo', direzione: 'asc' | 'desc') {
    this.campo = campo;
    this.ordine = direzione;
    this.numeroPagina = 0;
    this.caricaEntratePaginate();
  }

  caricaEntrate(): void {
    this.entrataService.getEntrate().subscribe({
      next: (data) => (this.entrate = data),
      error: (error) => console.error('Errore nel caricamento dei dati', error),
    });
  }

  caricaEntrateOrdinate() : void {
    this.sort$
      .pipe(
        switchMap(({ campo, direzione }) =>
          this.entrataService.getEntrateOrdinate(campo, direzione),
        ),
      )
      .subscribe((data) => (this.entrate = data));
  }

  caricaEntratePaginate(): void {
    this.entrataService
      .getPaginaEntrate(this.numeroPagina, this.quantitaPagina, this.campo, this.ordine)
      .subscribe({
        next: (data) => (this.paginaEntrate = data),
        error: (error) => console.error('Errore nel caricamento dei dati', error),
      })
  }

  paginaSuccessiva(): void {
    if (!this.paginaEntrate?.last) {
      this.numeroPagina++;
      this.caricaEntratePaginate();
    }
  }

  paginaPrecendente(): void {
    if (!this.paginaEntrate?.first) {
      this.numeroPagina--;
      this.caricaEntratePaginate();
    }
  }
}
