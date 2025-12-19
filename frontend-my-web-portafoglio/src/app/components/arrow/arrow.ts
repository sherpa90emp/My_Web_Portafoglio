import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-arrow',
  imports: [],
  templateUrl: './arrow.html',
  styleUrl: './arrow.css',
})
export class Arrow {
  private desc = false;

  @Output() sort = new EventEmitter<'asc' | 'desc'>();

  statoOrdinamento() {
    this.desc = !this.desc;
    this.sort.emit(this.desc ? 'desc' : 'asc');
  }
}
