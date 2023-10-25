import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokedexComponent } from './component/pokedex/pokedex.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './component/ui/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    PokedexComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
