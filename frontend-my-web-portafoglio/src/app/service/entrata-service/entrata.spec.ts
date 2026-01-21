import { TestBed } from '@angular/core/testing';

import { EntrataService } from './entrata';

describe('EntrataService', () => {
  let service: EntrataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EntrataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
