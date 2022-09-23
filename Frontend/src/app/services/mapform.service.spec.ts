import { TestBed } from '@angular/core/testing';

import { MapformService } from './mapform.service';

describe('MapformService', () => {
  let service: MapformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MapformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
