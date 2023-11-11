import { Type } from '../enum/type';

export class Pokemon {
    id: number;
    name: string;
    sprite: string;
    type_one: Type;
    type_two: Type | null;
    base_hp: number;
    base_atk: number;
    base_def: number;
    base_spa: number;
    base_spd: number;
    base_spe: number;
    base_total: number;
    icon_b64: string;
    stage: number;

    constructor(
        id: number,
        name: string,
        sprite: string,
        type_one: Type,
        type_two: Type | null,
        base_hp: number,
        base_atk: number,
        base_def: number,
        base_spa: number,
        base_spd: number,
        base_spe: number,
        base_total: number,
        icon_b64: string,
        stage: number
    ) {
        this.id = id;
        this.name = name;
        this.sprite = sprite;
        this.type_one = type_one;
        this.type_two = type_two;
        this.base_hp = base_hp;
        this.base_atk = base_atk;
        this.base_def = base_def;
        this.base_spa = base_spa;
        this.base_spd = base_spd;
        this.base_spe = base_spe;
        this.base_total = base_total;
        this.icon_b64 = icon_b64;
        this.stage = stage;
    }
}
