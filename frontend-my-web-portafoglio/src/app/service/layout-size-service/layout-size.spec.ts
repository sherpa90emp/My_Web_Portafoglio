import { TestBed } from '@angular/core/testing';

import { LayoutSize } from './layout-size';

describe('LayoutSize', () => {
  let service: LayoutSize;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LayoutSize);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
