import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { DiceRequest } from "./../models/dice-request";
import { DiceResponse } from './../models/dice-response';
import { map } from 'rxjs/operators';
import { DiceResponseReport } from '../models/dice-response-report';

@Injectable()
export class DiceBackendService {

    diceResponse: Observable<DiceResponse>;
    private _diceResponse: BehaviorSubject<DiceResponse>;
    constructor(private http: Http) {
        this._diceResponse = new BehaviorSubject(null);
        this.diceResponse = this._diceResponse.asObservable();
    }

    rollDice(req: DiceRequest): Observable<boolean> {
        return this.http.get(`/rldp-diceapp-service/dice/roll?pieces=${req.pieces}&sides=${req.sides}&rolls=${req.rolls}`)
            .pipe(map((response: Response) => {
                this._diceResponse.next(new DiceResponse(response.json()));
                return true;
            }))
    }

    getDiceResultsReport(): Observable<DiceResponseReport> {
        return this.http.get(`/rldp-diceapp-service/dice/report`)
            .pipe(map((response: Response) => {
                return new DiceResponseReport(response.json());
            }))
    }
}
