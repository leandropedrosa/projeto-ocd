import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptModule} from "nativescript-angular/nativescript.module";
import {NativeScriptHttpClientModule} from "nativescript-angular/http-client";
import {NativeScriptFormsModule} from "nativescript-angular/forms";
import {registerElement} from "nativescript-angular";
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {AcompanhamentoModule} from "./acompanhamento/acompanhamento.module";
import {AppRoutingModule} from "./app-routing.module";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./login/login.component";
import {NativeScriptUIListViewModule} from "nativescript-ui-listview/angular/listview-directives";
import {DatePipe} from '@angular/common';
import {UserService} from "./shared/user.service";
import {HttpInterceptorService} from "~/shared/httpInterceptor.service";
import {HomeComponent} from "~/home/home.component";

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
        AcompanhamentoModule
    ],
    declarations: [
        AppComponent,
        LoginComponent,
         HomeComponent,
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
