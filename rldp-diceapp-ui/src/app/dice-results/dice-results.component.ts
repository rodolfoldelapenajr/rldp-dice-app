import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { DiceBackendService } from '../core/services/dice-backend.service';
import { DiceRequest } from '../core/models/dice-request';

const SIDES = [
    4,
    6,
    8,
    10,
    12,
    20,
    100
]

@Component({
    selector: 'app-dice-results',
    templateUrl: './dice-results.component.html',
    styleUrls: ['./dice-results.component.css']
})
export class DiceResultsComponent implements OnInit {
    sides = SIDES;
    form: FormGroup;
    constructor(private diceBackendService: DiceBackendService) { }

    ngOnInit() {
        this.form = new FormGroup({
            pieces: new FormControl(1),
            sides: new FormControl(4),
            rolls: new FormControl(1),
        });
    }

    rollDice(params) {
        const request = new DiceRequest(params);
        this.diceBackendService.rollDice(request).subscribe(result => {
            console.log(result);
        });
    }
}
