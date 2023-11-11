import { Component, Input, SimpleChanges } from '@angular/core';
import { FamilyTreeNode } from '@model/family-tree-node';

@Component({
    selector: 'pokedex-family-tree',
    templateUrl: './family-tree.component.html',
    styleUrls: ['./family-tree.component.scss'],
})
export class FamilyTreeComponent {
    @Input() flatTree: FamilyTreeNode[] | undefined;

    stageOneNodes: FamilyTreeNode[] | undefined;
    stageTwoNodes: FamilyTreeNode[] | undefined;
    stageThreeNodes: FamilyTreeNode[] | undefined;

    ngOnChanges(changes: SimpleChanges) {
        console.log(this.flatTree);
        this.stageOneNodes = this.flatTree!.filter((node) => node.stage === 1);
        this.stageTwoNodes = this.flatTree!.filter((node) => node.stage === 2);
        this.stageThreeNodes = this.flatTree!.filter(
            (node) => node.stage === 3
        );
    }
}
