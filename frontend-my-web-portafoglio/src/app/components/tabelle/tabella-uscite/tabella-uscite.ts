import { Component, Input, OnInit } from '@angular/core';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { UscitaDTO, UscitaService } from '../../../service/uscita-service/uscita';
import { Arrow } from '../../arrow/arrow';
import { Subject, switchMap } from 'rxjs';

@Component({
  selector: 'app-tabella',
  imports: [CurrencyPipe, DatePipe, Arrow],
  templateUrl: './tabella-uscite.html',
  styleUrl: './tabella-uscite.css',
})
export class Tabella implements OnInit {
  @Input() uscite: UscitaDTO[] = [];

  constructor(private uscitaService: UscitaService) {}

  private sort$ = new Subject<{ campo: 'dataSpesa' | 'importo'; direzione: 'asc' | 'desc' }>();

  ngOnInit(): void {
    this.uscitaService.getUscite().subscribe({
      next: (data) => (this.uscite = data),
      error: (error) => console.error('Errore nel caricamento dei dati', error),
    });

    this.sort$
      .pipe(
        switchMap(({ campo, direzione }) => this.uscitaService.getUsciteOrdinate(campo, direzione)),
      )
      .subscribe((data) => (this.uscite = data));
  }

  ordina(campo: 'dataSpesa' | 'importo', direzione: 'asc' | 'desc') {
    this.sort$.next({ campo, direzione });
  }
}
