/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { DiceBackendService } from './dice-backend.service';

describe('Service: DiceBackend', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DiceBackendService]
    });
  });

  it('should ...', inject([DiceBackendService], (service: DiceBackendService) => {
    expect(service).toBeTruthy();
  }));
});
