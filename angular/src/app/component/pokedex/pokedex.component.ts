import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../service/pokemon.service';
import { Pokemon } from '../../model/pokemon';

@Component({
    selector: 'app-pokedex',
    templateUrl: './pokedex.component.html',
    styleUrls: ['./pokedex.component.scss'],
})
export class PokedexComponent {
    pokemonList: Pokemon[] = [];
    loading = true; // set initial state to loading
    loadingFailed = false; // indicate whether loading has failed

    selectedPokemon: Pokemon | null = null;

    constructor(private pokemonService: PokemonService) {}

    setSelectedPokemon(pokemon: Pokemon): void {
        this.selectedPokemon = pokemon;
    }

    ngOnInit(): void {
        this.pokemonService.getPokemons().subscribe(
            (data) => {
                this.pokemonList = data.map(
                    (pokemon) =>
                        new Pokemon(pokemon.id, pokemon.name, pokemon.sprite)
                );
                this.loading = false;
            },
            (error) => {
                console.error('Failed to load pokemons: ', error);
                this.loading = false;
                this.loadingFailed = true;
            }
        );
    }
}
