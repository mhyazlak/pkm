import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../service/pokemon.service'; // Update the path accordingly
import { Pokemon } from '../../model/pokemon'; // Update the path accordingly

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.scss']
})
export class PokedexComponent implements OnInit {

  pokemons: Pokemon[] = [];

  constructor(private pokemonService: PokemonService) { }

  ngOnInit(): void {
    this.pokemonService.getPokemons().subscribe(data => {
      this.pokemons = data.map(pokemon => new Pokemon(pokemon.id, pokemon.name));
    });
  }
}
