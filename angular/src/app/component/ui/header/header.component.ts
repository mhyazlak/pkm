import { Component } from '@angular/core';
import { environment } from 'src/environments/environment';
@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
    appName = environment.appName;

    navbarItems = [
        { value: 'battle', display: 'Battle' },
        { value: 'pokedex', display: 'Pokedex' },
        { value: 'profile', display: 'Profile' },
    ];
}
