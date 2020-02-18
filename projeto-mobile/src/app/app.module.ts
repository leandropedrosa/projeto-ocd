import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptModule} from "nativescript-angular/nativescript.module";
import {AppRoutingModule} from "./app-routing.module";
import {AppComponent} from "./app.component";
import {NativeScriptFormsModule, NativeScriptHttpClientModule} from "@nativescript/angular";
import {NativeScriptUIListViewModule} from "nativescript-ui-listview/angular";
import {NativeScriptUISideDrawerModule} from "nativescript-ui-sidedrawer/angular";
import {DatePipe} from "@angular/common";
import {HomeModule} from "./components/home/home.module";
import {PreloginComponent} from "./components/prelogin/prelogin.component";
import {LoginComponent} from "./components/login/login.component";

@NgModule({
    bootstrap: [
        AppComponent
    ],
    imports: [
        NativeScriptModule,
        AppRoutingModule,
        NativeScriptFormsModule,
        NativeScriptUIListViewModule,
        NativeScriptHttpClientModule,
        NativeScriptUISideDrawerModule,
        HomeModule
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        PreloginComponent,
    ],
    providers: [
        DatePipe
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AppModule {
}
