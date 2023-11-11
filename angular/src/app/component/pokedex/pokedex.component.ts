import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../service/pokemon.service';
import { Pokemon } from '@model/pokemon';

@Component({
    selector: 'app-pokedex',
    templateUrl: './pokedex.component.html',
    styleUrls: ['./pokedex.component.scss'],
})
export class PokedexComponent {
    color: string = '$custom-primary';

    public matchedPokemonCount: number = 0;
    pokemonList: Pokemon[] = [];
    loading = true; // set initial state to loading
    loadingFailed = false; // indicate whether loading has failed
    initialFilter = {
        search: '', // The '?' denotes that the property is optional
        sortBy: 'name',
        selectedTypes: undefined,
    };
    selectedPokemon: Pokemon | null = null;
    constructor(private pokemonService: PokemonService) {}

    setSelectedPokemon(pokemon: Pokemon): void {
        this.selectedPokemon = pokemon;
        this.updateSelectedPokemonReference();
    }

    onFilterChanged(filterCriteria: any) {
        this.loading = true;
        this.pokemonService.getPokemons(filterCriteria).subscribe({
            next: (data) => {
                this.pokemonList = data;
                this.matchedPokemonCount = data.length;
                this.loading = false;

                this.updateSelectedPokemonReference();
            },
            error: (error) => {
                this.loading = false;
                this.loadingFailed = true;
            },
        });
    }

    ngOnInit(): void {
        this.pokemonService.getPokemons(this.initialFilter).subscribe({
            next: (data) => {
                this.pokemonList = data;
                this.matchedPokemonCount = data.length;
                this.loading = false;

                this.updateSelectedPokemonReference();
            },
            error: (error) => {
                this.loading = false;
                this.loadingFailed = true;
            },
        });
    }

    updateSelectedPokemonReference() {
        if (this.selectedPokemon) {
            const foundPokemon = this.pokemonList.find(
                (p) => p.id === this.selectedPokemon!.id
            );
            if (foundPokemon) {
                this.selectedPokemon = foundPokemon;
            }
        }
    }
}
