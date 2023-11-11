import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './component/ui/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { PokedexComponent } from './component/pokedex/pokedex.component';
import { MatDividerModule } from '@angular/material/divider';
import { BattleComponent } from './component/battle/battle.component';
import { ProfileComponent } from './component/profile/profile.component';
import { MatRippleModule } from '@angular/material/core';

import { FlexLayoutModule } from '@angular/flex-layout';
import { FilterComponent } from './component/pokedex/filter/filter.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatExpansionModule } from '@angular/material/expansion';
import { ShowcaseComponent } from './component/pokedex/showcase/showcase.component';
import { MatCardModule } from '@angular/material/card';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { MatRadioModule } from '@angular/material/radio';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { FamilyTreeComponent } from './component/pokedex/showcase/family-tree/family-tree.component';
import { MatTreeModule } from '@angular/material/tree';
import { MatIconModule } from '@angular/material/icon';
@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        PokedexComponent,
        BattleComponent,
        ProfileComponent,
        FilterComponent,
        ShowcaseComponent,
        FamilyTreeComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        NgbModule,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatButtonModule,
        MatListModule,
        MatDividerModule,
        FlexLayoutModule,
        MatRippleModule,
        MatFormFieldModule,
        MatSelectModule,
        FormsModule,
        MatInputModule,
        MatCheckboxModule,
        MatExpansionModule,
        MatCardModule,
        NgxChartsModule,
        MatRadioModule,
        MatProgressSpinnerModule,
        MatTreeModule,
        MatIconModule,
    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
