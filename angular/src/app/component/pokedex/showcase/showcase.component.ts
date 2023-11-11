import {
    Component,
    EventEmitter,
    Input,
    Output,
    SimpleChanges,
} from '@angular/core';
import { Pokemon } from '@model/pokemon';
import { PokemonService } from '@service/pokemon.service';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { TypeStats } from '@model/type-stats';
import { Type } from 'src/app/enum/type';
import { FamilyTreeNode } from '@model/family-tree-node';

const MIN_POKEMON_ID = 1;
const MAX_POKEMON_ID = 251;

@Component({
    selector: 'pokedex-showcase',
    templateUrl: './showcase.component.html',
    styleUrls: ['./showcase.component.scss'],
})
export class ShowcaseComponent {
    @Input() selectedPokemon: Pokemon | null | undefined;
    @Output() pokemonSelected = new EventEmitter<Pokemon>();
    previousEntry: Pokemon | null | undefined;
    nextEntry: Pokemon | null | undefined;
    selectedChartType: 'polar' | 'bar' = 'bar';
    //@Output() filterChanged = new EventEmitter<any>();

    flatTree: FamilyTreeNode[] | undefined;

    polarChartData: any[] = [];
    barChartData: any[] = [];
    polarColorScheme!: Color;
    barColorScheme!: Color;

    constructor(private pokemonService: PokemonService) {} // Inject the PokemonService

    ngOnChanges(changes: SimpleChanges) {
        if (
            changes['selectedPokemon'] &&
            changes['selectedPokemon'].currentValue
        ) {
            this.polarColorScheme = this.generateColorScheme(
                this.selectedPokemon!.type_one
            );

            this.barColorScheme = this.generateColorScheme(
                this.selectedPokemon!.type_one,
                true
            );

            // Call the service to get the type stats
            this.pokemonService
                .getTypeStats(this.selectedPokemon!.type_one)
                .subscribe((typeStats: TypeStats) => {
                    this.polarChartData = this.transformPolarChartData(
                        typeStats,
                        this.selectedPokemon
                    );
                    this.barChartData = this.transformBarChartData(
                        typeStats,
                        this.selectedPokemon
                    );
                });

            // Call the service to get the type stats
            this.pokemonService
                .getFamilyTree(this.selectedPokemon!.id)
                .subscribe((flatTree: FamilyTreeNode[]) => {
                    this.flatTree = flatTree;
                });

            // check if there is a previous Entry to the pokemon
            if (this.selectedPokemon!.id != MIN_POKEMON_ID) {
                this.pokemonService
                    .getPokemon(this.selectedPokemon!.id - 1)
                    .subscribe((pokemon) => {
                        this.previousEntry = pokemon;
                    });
            } else {
                this.previousEntry = null;
            }

            // check if there is a next Entry to the pokemon
            if (this.selectedPokemon!.id != MAX_POKEMON_ID) {
                this.pokemonService
                    .getPokemon(this.selectedPokemon!.id + 1)
                    .subscribe((pokemon) => {
                        this.nextEntry = pokemon;
                    });
            } else {
                this.nextEntry = null;
            }
        }
    }

    ngOnInit() {}

    setSelectedPokemon(pokemon: Pokemon) {
        this.selectedPokemon = pokemon;
        this.pokemonSelected.emit(pokemon); // Emit the selected Pokemon
    }

    generateColorScheme(type: Type, reverse: boolean = false): Color {
        const typeColors: { [key in Type]: string } = {
            NORMAL: '#A8A878',
            FIRE: '#F08030',
            WATER: '#6890F0',
            ELECTRIC: '#F8D030',
            GRASS: '#78C850',
            ICE: '#98D8D8',
            FIGHTING: '#C03028',
            POISON: '#A040A0',
            GROUND: '#E0C068',
            FLYING: '#A890F0',
            PSYCHIC: '#F85888',
            BUG: '#A8B820',
            ROCK: '#B8A038',
            GHOST: '#705898',
            DARK: '#705848',
            DRAGON: '#7038F8',
            STEEL: '#B8B8D0',
            FAIRY: '#EE99AC',
        };

        const baseColor = typeColors[type];

        const mutedColor = this.muteColor(baseColor);
        if (reverse) {
            return {
                selectable: false,
                group: ScaleType.Quantile,
                domain: [baseColor, mutedColor],
                name: type,
            };
        } else {
            return {
                selectable: false,
                group: ScaleType.Quantile,
                domain: [mutedColor, baseColor],
                name: type,
            };
        }
    }
    // This function takes a color and returns a more muted version of it
    muteColor(color: string): string {
        const R = parseInt(color.substring(1, 3), 16);
        const G = parseInt(color.substring(3, 5), 16);
        const B = parseInt(color.substring(5, 7), 16);

        // Muting the color by blending it with grey (averaging the RGB values with 128, which is 50% grey)
        const mutedR = Math.round((R + 128) / 2)
            .toString(16)
            .padStart(2, '0');
        const mutedG = Math.round((G + 128) / 2)
            .toString(16)
            .padStart(2, '0');
        const mutedB = Math.round((B + 128) / 2)
            .toString(16)
            .padStart(2, '0');

        return `#ccc`;
    }
    transformPolarChartData(
        typeStats: TypeStats,
        selectedPokemon: Pokemon | null | undefined
    ): any[] {
        if (!selectedPokemon) {
            return [];
        }
        return [
            {
                name: 'TOTAL',
                series: [
                    { name: 'HP', value: typeStats.avg_base_hp },
                    { name: 'ATK', value: typeStats.avg_base_atk },
                    { name: 'DEF', value: typeStats.avg_base_def },
                    { name: 'SPA', value: typeStats.avg_base_spa },
                    { name: 'SPD', value: typeStats.avg_base_spd },
                    { name: 'SPE', value: typeStats.avg_base_spe },
                ],
            },
            {
                name: selectedPokemon.name,
                series: [
                    {
                        name: 'HP',
                        value: selectedPokemon.base_hp,
                    },
                    {
                        name: 'ATK',
                        value: selectedPokemon.base_atk,
                    },
                    {
                        name: 'DEF',
                        value: selectedPokemon.base_def,
                    },
                    {
                        name: 'SPA',
                        value: selectedPokemon.base_spa,
                    },
                    {
                        name: 'SPD',
                        value: selectedPokemon.base_spd,
                    },
                    {
                        name: 'SPE',
                        value: selectedPokemon!.base_spe,
                    },
                ],
            },
        ];
    }
    transformBarChartData(
        typeStats: TypeStats,
        selectedPokemon: Pokemon | null | undefined
    ) {
        return [
            {
                name: 'HP',
                series: [
                    {
                        name: selectedPokemon?.name,
                        value: selectedPokemon?.base_hp,
                    },
                    {
                        name: `AVG-${typeStats.type_one}-Type`,
                        value: typeStats?.avg_base_hp,
                    },
                ],
            },
            {
                name: 'ATK',
                series: [
                    {
                        name: selectedPokemon?.name,
                        value: selectedPokemon?.base_atk,
                    },
                    {
                        name: `AVG-${typeStats.type_one}-Type`,
                        value: typeStats?.avg_base_atk,
                    },
                ],
            },
            {
                name: 'DEF',
                series: [
                    {
                        name: selectedPokemon?.name,
                        value: selectedPokemon?.base_def,
                    },
                    {
                        name: `AVG-${typeStats.type_one}-Type`,
                        value: typeStats?.avg_base_def,
                    },
                ],
            },
            {
                name: 'SPA',
                series: [
                    {
                        name: selectedPokemon?.name,
                        value: selectedPokemon?.base_spa,
                    },
                    {
                        name: `AVG-${typeStats.type_one}-Type`,
                        value: typeStats?.avg_base_spa,
                    },
                ],
            },
            {
                name: 'SPD',
                series: [
                    {
                        name: selectedPokemon?.name,
                        value: selectedPokemon?.base_spd,
                    },
                    {
                        name: `AVG-${typeStats.type_one}-Type`,
                        value: typeStats?.avg_base_spd,
                    },
                ],
            },
            {
                name: 'SPE',
                series: [
                    {
                        name: selectedPokemon?.name,
                        value: selectedPokemon?.base_spe,
                    },
                    {
                        name: `AVG-${typeStats.type_one}-Type`,
                        value: typeStats?.avg_base_spe,
                    },
                ],
            },
        ];
    }
}
