import { DiceSum } from "./dice-sum";
import { DiceRoll } from "./dice-roll";

export class DiceResults {
    diceRollList: Array<DiceRoll> = [];
    diceSumSet: Array<DiceSum> = [];
    constructor (param?: any) {
        if (param.diceRollList) {
            param.diceRollList.forEach(element => {
                this.diceRollList.push(new DiceRoll(element));
            });
        }
        if (param.diceSumSet) {
            param.diceSumSet.forEach(element => {
                this.diceSumSet.push(new DiceSum(element));
            });
        }
    }
}
