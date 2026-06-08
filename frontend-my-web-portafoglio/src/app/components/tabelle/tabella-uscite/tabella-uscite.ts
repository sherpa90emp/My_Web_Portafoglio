import { Component } from '@angular/core';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { UscitaDTO, UscitaService } from '../../../service/uscita-service/uscita';
import { Arrow } from '../../arrow/arrow';
import { Observable } from 'rxjs';
import { Paginazione } from "../../paginazione/paginazione";
import { Page } from '../../../service/page-model/page';
import { TabellaGenerica } from '../tabella-generica';

@Component({
  selector: 'app-tabella',
  imports: [CurrencyPipe, DatePipe, Arrow, Paginazione],
  templateUrl: './tabella-uscite.html',
  styleUrl: './tabella-uscite.css',
})
export class Tabella extends TabellaGenerica<UscitaDTO> {
  
  campo: 'dataSpesa' | 'importo' = 'dataSpesa'

  constructor(private uscitaService: UscitaService) {
    super()
  }

  override fetchDati(page: number, size: number, campo: string, ordine: 'asc' | 'desc'): Observable<Page<UscitaDTO>> {
    return this.uscitaService.getUscitePaginate(page, size, campo, ordine)
  }
}