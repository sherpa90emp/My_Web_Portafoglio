import { Component, ElementRef, ViewChild } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';
import { LayoutSize } from '../../service/layout-size-service/layout-size';

@Component({
  selector: 'app-navbar',
  imports: [Sidebar],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar {
  @ViewChild('navbar') navbarElement!: ElementRef;

  constructor(private layoutSizeService: LayoutSize) {}

  ngAfterViewInit(): void {
    const altezzaNavbar = this.navbarElement.nativeElement.offsetHeight;
    this.layoutSizeService.setNavbarHeight(altezzaNavbar);
  }
}
