import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaEntrate } from './tabella-entrate';

describe('TabellaEntrate', () => {
  let component: TabellaEntrate;
  let fixture: ComponentFixture<TabellaEntrate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabellaEntrate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabellaEntrate);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
