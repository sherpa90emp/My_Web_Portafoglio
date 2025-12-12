import { TestBed } from '@angular/core/testing';

import { UscitaService } from './uscita';

describe('UscitaService', () => {
  let service: UscitaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UscitaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
