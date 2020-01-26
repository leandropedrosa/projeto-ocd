import { NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { NativeScriptModule } from "nativescript-angular/nativescript.module";
import { AppRoutingModule } from "./app.routing";
import { AppComponent } from "./app.component";

import { NativeScriptFormsModule } from "nativescript-angular/forms";

import { ActionBarComponent } from './action-bar/action-bar.component';

import { HomeComponent } from './home/home.component';
import { DogTabComponent } from './dog-tab/dog-tab.component';
import { DogsComponent } from './dogs/dogs.component';
import { DogDetailsComponent } from './dog-details/dog-details.component';
import { CatTabComponent } from './cat-tab/cat-tab.component';
import { CatsComponent } from './cats/cats.component';
import { CatDetailsComponent } from './cat-details/cat-details.component';

import { DogService } from './dog.service';
import {TesteComponent} from "./teste/teste.component";

@NgModule({
    bootstrap: [
        AppComponent
    ],
    imports: [
        NativeScriptModule,
        AppRoutingModule,
        NativeScriptFormsModule
    ],
    declarations: [
        AppComponent,
        ActionBarComponent,
        HomeComponent,
        DogTabComponent,
        CatTabComponent,
        DogsComponent,
        DogDetailsComponent,
        CatsComponent,
        CatDetailsComponent,
        TesteComponent
    ],
    providers: [
        DogService
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AppModule { }
