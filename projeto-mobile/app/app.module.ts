import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptModule} from "nativescript-angular/nativescript.module";
import {NativeScriptHttpClientModule} from "nativescript-angular/http-client";
import {NativeScriptFormsModule} from "nativescript-angular/forms";
import {registerElement} from "nativescript-angular";
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {AppComponent} from "./app.component";
import {LoginComponent} from "./login/login.component";
import {NativeScriptUIListViewModule} from "nativescript-ui-listview/angular/listview-directives";
import {DatePipe} from '@angular/common';
import {UserService} from "./shared/user.service";
import {HttpInterceptorService} from "~/shared/httpInterceptor.service";
import {NativeScriptBottomNavigationBarModule} from "nativescript-bottom-navigation/angular";
import {NativeScriptUISideDrawerModule} from "nativescript-ui-sidedrawer/angular";
import {AppRoutingModule} from "./app-routing.module";
import {NavigationModule} from "./navigation/navigation.module";
import {PreloginComponent} from "~/prelogin/prelogin.component";
import {NativeScriptCommonModule} from "nativescript-angular/common";
import {NavigationRoutingModule} from "~/navigation/navigation-routing.module";
import {AcompanhamentoModule} from "~/navigation/acompanhamento/acompanhamento.module";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";

registerElement("PreviousNextView", () => require("nativescript-iqkeyboardmanager").PreviousNextView);

@NgModule({
    bootstrap: [
        AppComponent
    ],
    imports: [
        NativeScriptModule,
        NativeScriptFormsModule,
        NativeScriptUIListViewModule,
        NativeScriptHttpClientModule,
        AppRoutingModule,
        NavigationModule,
        NativeScriptBottomNavigationBarModule,
        NativeScriptUISideDrawerModule,
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        PreloginComponent,
    ],
    providers: [
        UserService,
        DatePipe,
        { provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true}
       // { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
       // { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AppModule {
    ngDoBootstrap(app) { }
}
