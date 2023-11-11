import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'; // <-- Import HttpParams
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Pokemon } from '../model/pokemon';
import { AjaxResponse } from '../model/ajax-response';
import { environment } from '../../environments/environment';
import { Type } from '../enum/type';
import { TypeStats } from '@model/type-stats';
import { FamilyTreeNode } from '@model/family-tree-node';

@Injectable({
    providedIn: 'root',
})
export class PokemonService {
    private apiUrl = `${environment.baseUrl}/api/pokemon`;

    constructor(private http: HttpClient) {}

    getPokemons(filter: any): Observable<Pokemon[]> {
        // Create a URL with the query parameters
        const params = new HttpParams()
            .set('search', filter.nameFilter || '')
            .set('sortBy', filter.selectedSortOption || '')
            .set(
                'selectedTypes',
                filter.selectedTypes && filter.selectedTypes.length > 0
                    ? filter.selectedTypes
                    : ''
            );

        return this.http
            .get<AjaxResponse<Pokemon[]>>(`${this.apiUrl}/readAll`, { params })
            .pipe(map((response) => response.data));
    }

    getPokemon(id: number): Observable<Pokemon> {
        let params = new HttpParams().set('id', id.toString()); // <-- Set the parameter

        return this.http
            .get<AjaxResponse<Pokemon>>(`${this.apiUrl}/read`, {
                params: params,
            }) // <-- Pass it to the get method
            .pipe(map((response) => response.data));
    }

    getTypeStats(type: Type): Observable<TypeStats> {
        let params = new HttpParams().set('type', type.toString()); // <-- Set the parameter

        return this.http
            .get<AjaxResponse<TypeStats>>(`${this.apiUrl}/readTypeStats`, {
                params: params,
            }) // <-- Pass it to the get method
            .pipe(map((response) => response.data));
    }

    getFamilyTree(id: number): Observable<FamilyTreeNode[]> {
        let params = new HttpParams().set('id', id.toString()); // <-- Set the parameter
        return this.http
            .get<AjaxResponse<FamilyTreeNode[]>>(
                `${this.apiUrl}/readFamilyTreeFlat`,
                {
                    params: params,
                }
            ) // <-- Pass it to the get method
            .pipe(map((response) => response.data));
    }
}
