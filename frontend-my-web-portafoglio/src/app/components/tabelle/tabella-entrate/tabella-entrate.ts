import { Component, Input, OnInit } from '@angular/core';
import { EntrataDTO, EntrataService } from '../../../service/entrata-service/entrata';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { Arrow } from '../../arrow/arrow';
import { Subject, switchMap } from 'rxjs';

@Component({
  selector: 'app-tabella-entrate',
  imports: [CurrencyPipe, DatePipe, Arrow],
  templateUrl: './tabella-entrate.html',
  styleUrl: './tabella-entrate.css',
})
export class TabellaEntrate implements OnInit {
  @Input() entrate: EntrataDTO[] = [];

  constructor(private entrataService: EntrataService) {}

  private sort$ = new Subject<{ campo: 'dataEntrata' | 'importo'; direzione: 'asc' | 'desc' }>();

  ngOnInit(): void {
    this.entrataService.getEntrate().subscribe({
      next: (data) => (this.entrate = data),
      error: (error) => console.error('Errore nel caricamento dei dati', error),
    });
    
    this.sort$
      .pipe(
        switchMap(({ campo, direzione }) =>
          this.entrataService.getEntrateOrdinate(campo, direzione)
        )
      )
      .subscribe((data) => (this.entrate = data));
  }

  ordina(campo: 'dataEntrata' | 'importo', direzione: 'asc' | 'desc') {
    this.sort$.next({campo, direzione});
  }
}
