import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './components/navbar/navbar';
import { Paginazione } from "./components/paginazione/paginazione";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Paginazione],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend-my-web-portafoglio');
}
