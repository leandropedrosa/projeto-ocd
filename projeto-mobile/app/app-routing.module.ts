import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { NativeScriptRouterModule } from "nativescript-angular/router";
import { LoginComponent } from './login/login.component';

const routes: Routes = [
    { path: "", redirectTo: "/login", pathMatch: "full" },
    { path: "login", component: LoginComponent },
    { path: "home", loadChildren: "./home/home.module#HomeModule" },
    { path: "acompanhamento", loadChildren: "./acompanhamento/acompanhamento.module#AcompanhamentoModule", },
];

@NgModule({
    imports: [NativeScriptRouterModule.forRoot(routes)],
    exports: [NativeScriptRouterModule]
})
export class AppRoutingModule { }
