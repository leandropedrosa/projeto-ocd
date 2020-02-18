import {NgModule} from '@angular/core';
import {Routes} from '@angular/router';
import {NativeScriptRouterModule} from 'nativescript-angular/router';
import {RastreamentoComponent} from "./rastreamento.component";

const routes: Routes = [
    {path: '', redirectTo: 'rastreamento', pathMatch: 'full'},
    { path: "rastreamento", component: RastreamentoComponent }
];
@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)],
    exports: [NativeScriptRouterModule]
})
export class RastreamentoRoutingModule {
}
