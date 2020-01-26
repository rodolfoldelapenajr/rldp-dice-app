import { DiceSumDistribution } from './dice-sum-distribution';
import { DiceResponse } from './dice-response';
import { DistinctRequest } from './distinct-request';

export class DiceResponseGroup {

    totalRolls: number;
    totalSimulations: number;
    diceSumDistributionList: Array<DiceSumDistribution> = [];
    diceResponseList: Array<DiceResponse> = [];
    request: DistinctRequest;

    constructor (param?: any) {
        this.totalRolls = param.totalRolls;
        this.totalSimulations = param.totalSimulations;
        this.request = new DistinctRequest(param.request);
        param.diceSumDistributionList.forEach(element => {
            this.diceSumDistributionList.push(new DiceSumDistribution(element));
        });
        param.diceResponseList.forEach(element => {
            this.diceResponseList.push(new DiceResponse(element));
        });
    }
}
