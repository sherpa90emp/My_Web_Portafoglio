import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './components/navbar/navbar';
import { Tabella } from './components/tabelle/tabella-uscite/tabella-uscite';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Tabella],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
}
