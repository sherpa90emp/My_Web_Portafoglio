import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { UscitaDTO, UscitaService } from '../../../service/uscita-service/uscita';
import { Arrow } from '../../arrow/arrow';
import { Subject, switchMap } from 'rxjs';
import { Paginazione } from "../../paginazione/paginazione";
import { Page } from '../../../service/page-model/page';

@Component({
  selector: 'app-tabella',
  imports: [CurrencyPipe, DatePipe, Arrow, Paginazione],
  templateUrl: './tabella-uscite.html',
  styleUrl: './tabella-uscite.css',
})
export class Tabella implements OnInit, AfterViewInit {
  uscite: UscitaDTO[] = [];

  paginaUscite: Page<UscitaDTO> | null = null;
  numeroPagina = 0;
  quantitaPagina = 18;
  campo: 'dataSpesa' | 'importo' = 'dataSpesa';
  ordine: 'asc' | 'desc' = 'desc';

  constructor(private uscitaService: UscitaService) {}

  private sort$ = new Subject<{ campo: 'dataSpesa' | 'importo'; direzione: 'asc' | 'desc' }>();

  @ViewChild('tabellaUscite') tabellaUscite!: ElementRef;

  ngOnInit(): void {
       
  }

  ngAfterViewInit(): void {
    this.calcolaQuantitaPagina();
    this.caricaUscitePaginate();
  }

  ordina(campo: 'dataSpesa' | 'importo', direzione: 'asc' | 'desc') {
    this.campo = campo;
    this.ordine = direzione;
    this.numeroPagina = 0;
    this.caricaUscitePaginate();
  }

  caricaUscite(): void {
    this.uscitaService.getUscite().subscribe({
      next: (data) => (this.uscite = data),
      error: (error) => console.error('Errore nel caricamento dei dati', error),
    });
  }

  caricaUsciteOrdinate(): void {
    this.sort$
      .pipe(
        switchMap(({ campo, direzione }) => this.uscitaService.getUsciteOrdinate(campo, direzione)),
      )
      .subscribe((data) => (this.uscite = data));
  }

  caricaUscitePaginate(): void {
    this.uscitaService
      .getUscitePaginate(this.numeroPagina, this.quantitaPagina, this.campo, this.ordine)
      .subscribe({
        next: (data) => (this.paginaUscite = data),
        error: (error) => console.error('Errore nel caricamento dei dati', error),
      });
  }

  calcolaQuantitaPagina(): void {
    const altezzaTabella = this.tabellaUscite.nativeElement.clientHeight;
    const altezzaRiga = 41;
    this.quantitaPagina = Math.max(10, Math.floor(altezzaTabella / altezzaRiga));
  }
}