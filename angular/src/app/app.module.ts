import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokedexComponent } from './component/pokedex/pokedex.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './component/ui/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BattleComponent } from './component/battle/battle.component';
import { MovedexComponent } from './component/movedex/movedex.component';
import { ProfileComponent } from './component/profile/profile.component';
import { EntryComponent } from './component/pokedex/entry/entry.component';
import { EntryListComponent } from './component/pokedex/entry-list/entry-list.component';
import { EntryDisplayComponent } from './component/pokedex/entry-display/entry-display.component';

@NgModule({
    declarations: [
        AppComponent,
        PokedexComponent,
        HeaderComponent,
        BattleComponent,
        MovedexComponent,
        ProfileComponent,
        EntryComponent,
        EntryListComponent,
        EntryDisplayComponent,
    ],
    imports: [BrowserModule, AppRoutingModule, HttpClientModule, NgbModule],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
