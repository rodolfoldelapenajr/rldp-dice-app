import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiceSimulationComponent } from './dice-simulation/dice-simulation.component';


const routes: Routes = [
  {
    path: '',
    component: DiceSimulationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
