import { DiceSum } from './dice-sum';

export class DiceSumDistribution {
    percentage: number;
    diceSum: DiceSum;

    constructor (param?: any) {
        this.percentage = param.percentage;
        this.diceSum = new DiceSum(param.diceSum);
    }
}
