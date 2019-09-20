import { NgModule, NgModuleFactoryLoader, NO_ERRORS_SCHEMA } from "@angular/core";
import { NativeScriptModule } from "nativescript-angular/nativescript.module";
import { NativeScriptHttpClientModule } from "nativescript-angular/http-client";
import { NativeScriptFormsModule } from "nativescript-angular/forms";
import { registerElement } from "nativescript-angular";
registerElement("PreviousNextView", () => require("nativescript-iqkeyboardmanager").PreviousNextView);
import { AcompanhamentoModule } from "./acompanhamento/acompanhamento.module";
import { HomeModule } from "./home/home.module";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./login/login.component";
import { NativeScriptUIListViewModule } from "nativescript-ui-listview/angular/listview-directives";

// TODO: should be imported from kinvey-nativescript-sdk/angular but declaration file is currently missing
import { KinveyModule, UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { DatePipe } from '@angular/common';
import { UserService } from "./shared/user.service";
import { BasicAuthHtppInterceptorService } from "./shared/BasicAuthHtppInterceptorService";


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
        AcompanhamentoModule,
        HomeModule,
        KinveyModule.init({
            appKey: "kid_SyY8LYO8M",
            appSecret: "09282985d7c540f7b076a9c7fd884c77"
        })
    ],
    declarations: [
        AppComponent,
        LoginComponent,
    ],
    providers: [
        UserService,
        DatePipe,
        BasicAuthHtppInterceptorService,
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AppModule {
    ngDoBootstrap(app) { }
}
