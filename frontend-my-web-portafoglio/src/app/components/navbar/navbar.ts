import { Component } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';

@Component({
  selector: 'app-navbar',
  imports: [Sidebar],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar {

}
