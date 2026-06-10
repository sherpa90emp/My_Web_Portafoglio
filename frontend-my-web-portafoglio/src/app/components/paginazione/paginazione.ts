import { Component, ElementRef, ViewChild } from '@angular/core';
import { LayoutSize } from '../../service/layout-size-service/layout-size';

@Component({
  selector: 'app-paginazione',
  imports: [],
  templateUrl: './paginazione.html',
  styleUrl: './paginazione.css',
})
export class Paginazione {
  @ViewChild('paginazione') paginazioneElement!: ElementRef;

  constructor(private layoutSizeService: LayoutSize) {}

  ngAfterViewInit(): void {
    const altezzaPaginazione = this.paginazioneElement.nativeElement.offsetHeight;
    this.layoutSizeService.setPaginazioneHeight(altezzaPaginazione);
  }
}
