import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaAllTransaction } from './tabella-all-transaction';

describe('TabellaAllTransaction', () => {
  let component: TabellaAllTransaction;
  let fixture: ComponentFixture<TabellaAllTransaction>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabellaAllTransaction]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabellaAllTransaction);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
