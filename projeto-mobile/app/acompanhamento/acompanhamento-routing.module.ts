import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { NativeScriptRouterModule } from "nativescript-angular/router";
import { Passo1Component } from "./passo1/passo1.component";
import { Passo2Component } from "./passo2/passo2.component";
import { Passo3Component } from "./passo3/passo3.component";
import { Passo4Component } from "./passo4/passo4.component";


const routes: Routes = [
    { path: "", component: Passo1Component },
    { path: "passo2", component: Passo2Component },
    { path: "passo3", component: Passo3Component },
    { path: "passo4", component: Passo4Component }
]
@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)],
    exports: [NativeScriptRouterModule]
})
export class AcompanhamentoRoutingModule {
}  
