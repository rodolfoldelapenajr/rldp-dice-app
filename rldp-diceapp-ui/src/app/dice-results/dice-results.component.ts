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
    resultsList = [];
    constructor(private diceBackendService: DiceBackendService) { }

    ngOnInit() {
        const commonValidators = [
            Validators.pattern("^[1-9]{1}[0-9]*"),
            Validators.min(1),
            Validators.max(100),
            Validators.required
        ]
        this.form = new FormGroup({
            pieces: new FormControl(1, commonValidators),
            sides: new FormControl(4),
            rolls: new FormControl(1, commonValidators),
        });
    }

    rollDice(params) {
        const request = new DiceRequest(params);
        this.diceBackendService.rollDice(request).subscribe(results => {
            console.log(JSON.stringify(results))
            this.resultsList.push(results)
        });
    }
    toInt(num: any) {
        return parseInt(num);
    }
}
