import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DiceResultsComponent } from './dice-simulation/dice-results/dice-results.component';
import { DiceBackendService } from './core/services/dice-backend.service';
import { Http, HttpModule } from '@angular/http';
import { ExtendedHttp } from './extended-http';
import { DiceSimulationComponent } from './dice-simulation/dice-simulation.component';
import { DiceInputComponent } from './dice-simulation/dice-input/dice-input.component';
import { DiceReportComponent } from './dice-simulation/dice-report/dice-report.component';

@NgModule({
   declarations: [
      AppComponent,
      DiceInputComponent,
      DiceReportComponent,
      DiceResultsComponent,
      DiceSimulationComponent
   ],
   imports: [
      HttpModule,
      FormsModule,
      ReactiveFormsModule,
      NgbModule,
      BrowserModule,
      AppRoutingModule
   ],
   providers: [
      {
         provide: Http,
         useClass: ExtendedHttp
      },
      DiceBackendService
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
