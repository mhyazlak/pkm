import { Component, Output, EventEmitter, Input } from '@angular/core';
import { Type } from 'src/app/enum/type';

@Component({
    selector: 'pokedex-filter',
    templateUrl: './filter.component.html',
    styleUrls: ['./filter.component.scss'],
})
export class FilterComponent {
    pokemonTypes = Object.values(Type);
    selectedSortOption: string = 'id';
    nameFilter: string = '';
    filterPanelOpenState: boolean = false;
    selectedTypes: Type[] = [];

    @Input() matchedPokemonCount: number = 0;

    @Output() filterChanged = new EventEmitter<any>();

    onFilterFormSubmit() {
        console.log(this.selectedTypes);
        const filterCriteria = {
            nameFilter: this.nameFilter,
            selectedSortOption: this.selectedSortOption,
            selectedTypes: this.selectedTypes,
        };
        this.filterChanged.emit(filterCriteria);
    }
    onTypeCheckboxChange(event: any, targetType: Type) {
        if (event.checked) {
            this.selectedTypes.push(targetType);
        } else {
            const index = this.selectedTypes.indexOf(targetType);
            if (index > -1) {
                this.selectedTypes.splice(index, 1);
            }
            console.log(this.selectedTypes);
        }
    }
}
