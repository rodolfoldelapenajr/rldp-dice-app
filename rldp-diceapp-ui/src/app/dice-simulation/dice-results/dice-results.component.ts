import { Component, OnInit } from '@angular/core';
import { DiceBackendService } from '../../core/services/dice-backend.service';

@Component({
    selector: 'app-dice-results',
    templateUrl: './dice-results.component.html',
    styleUrls: ['./dice-results.component.css']
})
export class DiceResultsComponent implements OnInit {

    resultsList = [];
    constructor(private diceBackendService: DiceBackendService) { }

    ngOnInit() {
        this.diceBackendService.diceResult.subscribe(results => {
            if (results) {
                this.resultsList.unshift(results);
            }
        });
    }

    toInt(num: any) {
        return parseInt(num);
    }
}
