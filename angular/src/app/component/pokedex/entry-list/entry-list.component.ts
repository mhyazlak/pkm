import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Pokemon } from '@model/pokemon';

@Component({
    selector: 'pokedex-entry-list',
    templateUrl: './entry-list.component.html',
    styleUrls: ['./entry-list.component.scss'],
})
export class EntryListComponent {
    @Input() pokemonList!: Pokemon[];
    @Output() pokemonSelected = new EventEmitter<Pokemon>();

    selectedPokemon?: Pokemon;

    onSelect(pokemon: Pokemon): void {
        this.selectedPokemon = pokemon;
        this.pokemonSelected.emit(pokemon);
        console.log(pokemon);
    }
}
