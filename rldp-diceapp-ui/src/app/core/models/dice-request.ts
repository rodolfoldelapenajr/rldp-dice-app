export class DiceRequest {
    pieces: number;
    sides: number;
    rolls: number;
    constructor (params?: any) {
        this.pieces = params.pieces
        this.sides = params.sides
        this.rolls = params.rolls
    }
}
