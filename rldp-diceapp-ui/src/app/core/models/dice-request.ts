import { DistinctRequest } from './distinct-request';

export class DiceRequest extends DistinctRequest{
    rolls: number;
    constructor (param?: any) {
        super(param);
        this.rolls = param.rolls
    }
}
