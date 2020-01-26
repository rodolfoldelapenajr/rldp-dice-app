import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { DiceResults } from "./../models/dice-results";
import { DiceRequest } from "./../models/dice-request";
import { map } from 'rxjs/operators';

@Injectable()
export class DiceBackendService {

    diceResult: Observable<DiceResults>;
    private _diceResult: BehaviorSubject<DiceResults>;
    constructor(private http: Http) {
        this._diceResult = new BehaviorSubject(null);
        this.diceResult = this._diceResult.asObservable();
    }

    rollDice(req: DiceRequest): Observable<boolean> {
        return this.http.get(`/rldp-diceapp-service/dice/roll?pieces=${req.pieces}&sides=${req.sides}&rolls=${req.rolls}`)
            .pipe(map((response: Response) => {
                this._diceResult.next(new DiceResults(response.json()));
                return true;
            }))
    }
}
