import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Pokemon } from '../model/pokemon';
import { AjaxResponse } from '../model/ajax-response';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private apiUrl = 'http://localhost:8080/api/pokemon/readAll';

  constructor(private http: HttpClient) { }

  getPokemons(): Observable<Pokemon[]> {
    return this.http.get<AjaxResponse<Pokemon[]>>(this.apiUrl).pipe(
      map(response => response.data)
    );
  }
  
}
