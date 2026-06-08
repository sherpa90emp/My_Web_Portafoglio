import { Component } from '@angular/core';
import { EntrataDTO, EntrataService } from '../../../service/entrata-service/entrata';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { Arrow } from '../../arrow/arrow';
import { Observable } from 'rxjs';
import { Page } from '../../../service/page-model/page';
import { Paginazione } from "../../paginazione/paginazione";
import { TabellaGenerica } from '../tabella-generica';

@Component({
  selector: 'app-tabella-entrate',
  imports: [CurrencyPipe, DatePipe, Arrow, Paginazione],
  templateUrl: './tabella-entrate.html',
  styleUrl: './tabella-entrate.css',
})
export class TabellaEntrate extends TabellaGenerica<EntrataDTO> {

  campo: 'dataEntrata' | 'importo' = 'dataEntrata'

  constructor(private entrataService: EntrataService) {
    super()
  }

  override fetchDati(page: number, size: number, campo: string, ordine: 'asc' | 'desc'): Observable<Page<EntrataDTO>> {
    return this.entrataService.getPaginaEntrate(page, size, campo, ordine)
  }
}
