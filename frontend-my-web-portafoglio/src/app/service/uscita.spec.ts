import { TestBed } from '@angular/core/testing';

import { Uscita } from './uscita';

describe('Uscita', () => {
  let service: Uscita;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Uscita);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
