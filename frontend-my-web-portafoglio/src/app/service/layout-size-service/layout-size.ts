import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LayoutSize {
  private navbarHeight = new BehaviorSubject<number>(0);
  private paginazioneHeight = new BehaviorSubject<number>(0);

  public navbarHeight$ = this.navbarHeight.asObservable();
  public paginazioneHeight$ = this.paginazioneHeight.asObservable();

  public setNavbarHeight(height: number) {
    this.navbarHeight.next(height);
  }

  public getNavbarHeight() {
    return this.navbarHeight.getValue();
  }

  public setPaginazioneHeight(height: number) {
    this.paginazioneHeight.next(height);
  }

  public getPaginazioneHeight() {
    return this.paginazioneHeight.getValue();
  }
}