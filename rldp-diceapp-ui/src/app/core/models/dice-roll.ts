export class DiceRoll {
    results = [];
    sum: number;

    constructor (params?: any) {
        this.results = params.results;
        this.sum = params.sum;
    }

}
