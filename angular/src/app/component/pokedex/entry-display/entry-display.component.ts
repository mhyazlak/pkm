import {
    Component,
    EventEmitter,
    Input,
    OnChanges,
    OnInit,
    Output,
} from '@angular/core';
import { Pokemon } from '@model/pokemon';
import { PokemonService } from '@service/pokemon.service';
import { environment } from 'src/environments/environment';
import { PokedexComponent } from '../pokedex.component';

@Component({
    selector: 'pokedex-entry-display',
    templateUrl: './entry-display.component.html',
    styleUrls: ['./entry-display.component.scss'],
})
export class EntryDisplayComponent implements OnChanges {
    @Input() pokemon: Pokemon | null = null;
    @Output() changeSelectedPokemon = new EventEmitter<Pokemon>();
    prevPokemon: Pokemon | null = null;
    nextPokemon: Pokemon | null = null;

    constructor(
        private pokemonService: PokemonService,
        private parent: PokedexComponent
    ) {} // Inject the service

    ngOnChanges() {
        this.loadAdjacentPokemons();
    }

    selectPokemon(pokemon: Pokemon) {
        this.changeSelectedPokemon.emit(pokemon);
    }

    loadAdjacentPokemons() {
        if (this.pokemon && this.pokemon.id) {
            const currentId = this.pokemon.id;

            // Fetch the previous Pokemon
            if (currentId != 1) {
                this.pokemonService.getPokemon(currentId - 1).subscribe({
                    next: (prevPokemon) => {
                        this.prevPokemon = prevPokemon;
                    },
                    error: (error) => {
                        console.error(
                            'Failed to fetch previous Pokemon:',
                            error
                        );
                    },
                });
            } else {
                this.prevPokemon = null;
            }

            if (currentId != environment.maxDexNumber) {
                this.pokemonService.getPokemon(currentId + 1).subscribe({
                    next: (nextPokemon) => {
                        this.nextPokemon = nextPokemon;
                    },
                    error: (error) => {
                        console.error('Failed to fetch next Pokemon:', error);
                    },
                });
            } else {
                this.nextPokemon = null;
            }
        }
    }
}
