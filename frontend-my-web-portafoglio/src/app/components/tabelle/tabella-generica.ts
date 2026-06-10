import { AfterViewInit, Directive, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Page } from '../../service/page-model/page';
import { Observable } from 'rxjs';

@Directive()
export abstract class TabellaGenerica<T> implements OnInit, AfterViewInit, OnDestroy {
  paginaData: Page<T> | null = null;
  numeroPagina = 0;
  quantitaPagina = 18;
  ordine: 'asc' | 'desc' = 'desc';

  abstract campo: string;

  @ViewChild('containerTabella') containerTabella!: ElementRef;

  private resizeObserver: ResizeObserver | null = null;

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    this.initResizeObserver();
    this.caricaDati();
  }

  ngOnDestroy(): void {
    this.destroyResizeObserver();
  }

  abstract fetchDati(
    page: number,
    size: number,
    campo: string,
    ordine: 'asc' | 'desc',
  ): Observable<Page<T>>;

  caricaDati(): void {
    this.fetchDati(this.numeroPagina, this.quantitaPagina, this.campo, this.ordine).subscribe({
      next: (data) => (this.paginaData = data),
      error: (error) => console.error('Errore nel caricamento dei dati', error),
    });
  }

  ordina(campo: string, direzione: 'asc' | 'desc') {
    this.campo = campo;
    this.ordine = direzione;
    this.numeroPagina = 0;
    this.caricaDati();
  }

  paginaSuccessiva(): void {
    if (!this.paginaData?.last) {
      this.numeroPagina++;
      this.caricaDati();
    }
  }

  paginaPrecendente(): void {
    if (!this.paginaData?.first) {
      this.numeroPagina--;
      this.caricaDati();
    }
  }

  calcolaQuantitaPagina(): number {
    const altezzaViewport = window.innerHeight;
    const altezzaNavBar = 60;
    const altezzaPaginazione = 50;
    const altezzaDisponibile = altezzaViewport - altezzaNavBar - altezzaPaginazione;
    console.log(altezzaDisponibile);
    const altezzaRiga = 41;
    return Math.max(10, Math.floor(altezzaDisponibile / altezzaRiga));
  }

  initResizeObserver(): void {
    this.resizeObserver = new ResizeObserver(() => {
      const nuovaQuantita = this.calcolaQuantitaPagina();
      if (nuovaQuantita !== this.quantitaPagina) {
        this.quantitaPagina = nuovaQuantita;
        this.numeroPagina = 0;
        this.caricaDati();
      }
    });

    if (this.containerTabella?.nativeElement) {
      this.resizeObserver.observe(this.containerTabella.nativeElement);
    }
  }

  destroyResizeObserver(): void {
    if (this.resizeObserver) {
      this.resizeObserver.disconnect();
      this.resizeObserver = null;
    }
  }
}
