import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokedexComponent } from './component/pokedex/pokedex.component';
import { BattleComponent } from './component/battle/battle.component';
import { ProfileComponent } from './component/profile/profile.component';

const routes: Routes = [
    { path: 'pokedex', component: PokedexComponent },
    { path: 'battle', component: BattleComponent },
    { path: 'profile', component: ProfileComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
