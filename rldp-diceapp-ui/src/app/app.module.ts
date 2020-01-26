import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DiceResultsComponent } from './dice-results/dice-results.component';
import { DiceBackendService } from './core/services/dice-backend.service';
import { Http, HttpModule } from '@angular/http';
import { ExtendedHttp } from './extended-http';

@NgModule({
   declarations: [
      AppComponent,
      DiceResultsComponent
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
