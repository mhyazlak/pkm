import { Type } from '../enum/type';

export interface FamilyTreeNode {
    id: number;
    name: string;
    type_one: Type;
    type_two?: Type; // This is optional since it's nullable
    icon_b64: string;
    stage: number;
    triggered_by: string;
}
