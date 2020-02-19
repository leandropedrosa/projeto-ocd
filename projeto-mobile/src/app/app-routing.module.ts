import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { NativeScriptRouterModule } from "nativescript-angular/router";
import {PreloginComponent} from "./components/prelogin/prelogin.component";
import {LoginComponent} from "./components/login/login.component";
const routes: Routes = [
    {path: "", redirectTo: 'prelogin', pathMatch: 'full' },
    {path: "prelogin", component: PreloginComponent},
    {path: "login", component: LoginComponent},
    {path: "home", loadChildren: () => import("./components/home/home.module").then(m => m.HomeModule) }
];
@NgModule({
    imports: [NativeScriptRouterModule.forRoot(routes)],
    exports: [NativeScriptRouterModule]
})
export class AppRoutingModule { }
