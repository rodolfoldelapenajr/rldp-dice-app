import { DiceResponseGroup } from './dice-response-group';

export class DiceResponseReport {
    groupList: Array<DiceResponseGroup> = [];

    constructor (param?: any) {

        if (param.groupList) {
            param.groupList.forEach(element => {
                this.groupList.push(new DiceResponseGroup(element));
            });
        }
    }
}
