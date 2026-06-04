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

  @ViewChild('containerTabella') containerTabella!: ElementRef;

  private resizeObserver: ResizeObserver | null = null;

  ngOnInit(): void {
    
  }

  ngAfterViewInit(): void {
    this.initResizeObserver();
    this.caricaUscitePaginate();
  }

  ngOnDestroy(): void {
    this.destroyResizeObserver();
  }

  ordina(campo: 'dataSpesa' | 'importo', direzione: 'asc' | 'desc') {
    this.campo = campo;
    this.ordine = direzione;
    this.numeroPagina = 0;
    this.caricaUscitePaginate();
  }

  private caricaUscite(): void {
    this.uscitaService.getUscite().subscribe({
      next: (data) => (this.uscite = data),
      error: (error) => console.error('Errore nel caricamento dei dati', error),
    });
  }

  private caricaUsciteOrdinate(): void {
    this.sort$
      .pipe(
        switchMap(({ campo, direzione }) => this.uscitaService.getUsciteOrdinate(campo, direzione)),
      )
      .subscribe((data) => (this.uscite = data));
  }

  private caricaUscitePaginate(): void {
    this.uscitaService
      .getUscitePaginate(this.numeroPagina, this.quantitaPagina, this.campo, this.ordine)
      .subscribe({
        next: (data) => (this.paginaUscite = data),
        error: (error) => console.error('Errore nel caricamento dei dati', error),
      });
  }

  private calcolaQuantitaPagina(): number {
    const altezzaTabella = this.containerTabella.nativeElement.clientHeight;
    console.log('altezza tabella con resize: ', altezzaTabella);
    const altezzaRiga = 41;
    return Math.max(10, Math.floor(altezzaTabella / altezzaRiga));
  }

  private initResizeObserver(): void {
    this.resizeObserver = new ResizeObserver(() => {
      const nuovaQuantita = this.calcolaQuantitaPagina();
      if (nuovaQuantita !== this.quantitaPagina) {
        this.quantitaPagina = nuovaQuantita;
        this.numeroPagina = 0;
        this.caricaUscitePaginate();
      }
    });

    if (this.containerTabella?.nativeElement) {
      this.resizeObserver.observe(this.containerTabella.nativeElement);
    }
  }

  private destroyResizeObserver(): void {
    if (this.resizeObserver) {
      this.resizeObserver.disconnect();
      this.resizeObserver = null;
    }
  }
}