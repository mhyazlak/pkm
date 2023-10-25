import { Component, Input } from '@angular/core';
import { Pokemon } from '@model/pokemon';
@Component({
    selector: 'pokedex-entry',
    templateUrl: './entry.component.html',
    styleUrls: ['./entry.component.scss'],
})
export class EntryComponent {
    @Input() pokemon!: Pokemon;
    @Input() isActive: boolean = false;
}
