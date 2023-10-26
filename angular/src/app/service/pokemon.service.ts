import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'; // <-- Import HttpParams
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Pokemon } from '../model/pokemon';
import { AjaxResponse } from '../model/ajax-response';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root',
})
export class PokemonService {
    private apiUrl = `${environment.baseUrl}/api/pokemon`;

    constructor(private http: HttpClient) {}

    getPokemons(): Observable<Pokemon[]> {
        return this.http
            .get<AjaxResponse<Pokemon[]>>(`${this.apiUrl}/readAll`)
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
}
