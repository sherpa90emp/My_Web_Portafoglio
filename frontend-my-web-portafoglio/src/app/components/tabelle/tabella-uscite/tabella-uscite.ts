import { Component, Input } from '@angular/core';
import { CurrencyPipe } from '@angular/common';
import { UscitaDTO } from '../../../service/uscita';

@Component({
  selector: 'app-tabella',
  imports: [CurrencyPipe],
  templateUrl: './tabella-uscite.html',
  styleUrl: './tabella-uscite.css',
})
export class Tabella {
  @Input() uscite: UscitaDTO[] = [];
}
