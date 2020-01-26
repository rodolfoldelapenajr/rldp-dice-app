/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { DiceReportComponent } from './dice-report.component';

describe('DiceReportComponent', () => {
  let component: DiceReportComponent;
  let fixture: ComponentFixture<DiceReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiceReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiceReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
