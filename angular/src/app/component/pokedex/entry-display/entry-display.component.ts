import { Component, Input } from '@angular/core';
import { Pokemon } from '@model/pokemon';

@Component({
    selector: 'pokedex-entry-display',
    templateUrl: './entry-display.component.html',
    styleUrls: ['./entry-display.component.scss'],
})
export class EntryDisplayComponent {
    @Input() pokemon: Pokemon | null = null;
}
