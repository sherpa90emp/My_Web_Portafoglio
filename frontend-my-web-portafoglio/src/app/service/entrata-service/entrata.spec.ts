import { TestBed } from '@angular/core/testing';

import { Entrata } from './entrata';

describe('Entrata', () => {
  let service: Entrata;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Entrata);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
