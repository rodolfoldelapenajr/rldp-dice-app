import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiceResultsComponent } from './dice-results/dice-results.component';


const routes: Routes = [
  {
    path: '',
    component: DiceResultsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
