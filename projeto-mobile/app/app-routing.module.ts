import {NgModule} from "@angular/core";
import {Routes} from "@angular/router";
import {NativeScriptRouterModule} from "nativescript-angular/router";
import {LoginComponent} from './login/login.component';
import {PreloginComponent} from "~/prelogin/prelogin.component";
import {Passo4Component} from "~/navigation/acompanhamento/passo4/passo4.component";

const routes: Routes = [
    {
        path: '',
        redirectTo: '/prelogin',
        pathMatch: 'full'
    },
    {path: "prelogin", component: PreloginComponent},
    {path: "login", component: LoginComponent},
    {path: "Navigation", loadChildren: "./navigation/navigation.module#NavigationModule"},

];

@NgModule({
    imports: [NativeScriptRouterModule.forRoot(routes)],
    exports: [NativeScriptRouterModule]
})
export class AppRoutingModule {
}
