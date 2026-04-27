import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Paginazione } from './paginazione';

describe('Paginazione', () => {
  let component: Paginazione;
  let fixture: ComponentFixture<Paginazione>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Paginazione]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Paginazione);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
