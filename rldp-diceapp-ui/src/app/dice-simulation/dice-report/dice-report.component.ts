import { Component, OnInit } from '@angular/core';
import { DiceBackendService } from 'src/app/core/services/dice-backend.service';
import { DiceResponseReport } from 'src/app/core/models/dice-response-report';

@Component({
    selector: 'app-dice-report',
    templateUrl: './dice-report.component.html',
    styleUrls: ['./dice-report.component.css']
})
export class DiceReportComponent implements OnInit {

    constructor(private diceBackendService: DiceBackendService) { }

    diceResponseReport: DiceResponseReport;
    
    ngOnInit() {
        this.getDiceResultsReport();
        this.diceBackendService.diceResponse.subscribe(results => {
            if (results) {
                this.getDiceResultsReport();
            }
        });
    }

    getDiceResultsReport() {
        this.diceBackendService.getDiceResultsReport().subscribe(diceResponseReport => {
            this.diceResponseReport = diceResponseReport;
        });
    }

}
