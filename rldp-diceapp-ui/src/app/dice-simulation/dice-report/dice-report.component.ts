import { Component, OnInit } from '@angular/core';
import { DiceBackendService } from 'src/app/core/services/dice-backend.service';

@Component({
    selector: 'app-dice-report',
    templateUrl: './dice-report.component.html',
    styleUrls: ['./dice-report.component.css']
})
export class DiceReportComponent implements OnInit {

    constructor(private diceBackendService: DiceBackendService) { }

    ngOnInit() {
    }

}
