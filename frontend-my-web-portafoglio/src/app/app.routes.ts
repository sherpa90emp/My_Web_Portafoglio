import { Routes } from '@angular/router';
import { HomePage } from './components/home-page/home-page';
import { Tabella } from './components/tabelle/tabella-uscite/tabella-uscite';

export const routes: Routes = [
    { path: '', component: HomePage, title: 'Home'},
    { path: 'uscite', component: Tabella, title: 'Tabella Uscite'},
];
