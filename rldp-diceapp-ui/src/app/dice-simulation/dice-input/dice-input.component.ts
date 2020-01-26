import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { DiceBackendService } from 'src/app/core/services/dice-backend.service';
import { DiceRequest } from 'src/app/core/models/dice-request';

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
    selector: 'app-dice-input',
    templateUrl: './dice-input.component.html',
    styleUrls: ['./dice-input.component.css']
})
export class DiceInputComponent implements OnInit {

    sides = SIDES;
    form: FormGroup;
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

    rollDice(param) {
        const request = new DiceRequest(param);
        this.diceBackendService.rollDice(request).subscribe(results => {
        });
    }
}
