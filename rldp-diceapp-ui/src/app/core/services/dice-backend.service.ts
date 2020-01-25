import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { DiceResults } from "./../models/dice-results";
import { DiceRequest } from "./../models/dice-request";
import { map } from 'rxjs/operators';
@Injectable()
export class DiceBackendService {

    constructor(private http: Http) { }

    diceResult: DiceResults;

    rollDice(req: DiceRequest): Observable<DiceResults> {
        return this.http.get(`/rldp-diceapp-service/dice/roll?pieces=${req.pieces}&sides=${req.sides}&rolls=${req.rolls}`)
            .pipe(map((response: Response) => {
            return new DiceResults(response.json());
        }))
    }
}
