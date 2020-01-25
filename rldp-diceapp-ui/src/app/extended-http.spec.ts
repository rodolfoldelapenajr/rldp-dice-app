/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ExtendedHttp } from './extended-http';

describe('Service: ExtendedHttp', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExtendedHttp]
    });
  });

  it('should ...', inject([ExtendedHttp], (service: ExtendedHttp) => {
    expect(service).toBeTruthy();
  }));
});
