export class DiceRoll {
    results = [];
    sum: number;

    constructor (param?: any) {
        this.results = param.results;
        this.sum = param.sum;
    }

}
