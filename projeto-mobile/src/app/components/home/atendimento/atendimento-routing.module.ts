import {NgModule} from '@angular/core';
import {Routes} from '@angular/router';
import {NativeScriptRouterModule} from 'nativescript-angular/router';
import {IntervencaoComponent} from './intervencao/intervencao.component';
import {ResultadosComponent} from './resultados/resultados.component';
import {AtendimentoComponent} from "./atendimento.component";

export const routes: Routes = [
    {path: '', redirectTo: 'atendimento', pathMatch: 'full'},
    {path: 'atendimento', component: AtendimentoComponent},
    {path: "rastreamento", loadChildren: () => import("./rastreamento/rastreamento.module").then(m => m.RastreamentoModule)},
    {path: "intervencao", component: IntervencaoComponent},
    {path: 'resultados', component: ResultadosComponent},

];

@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)],
    exports: [NativeScriptRouterModule]
})
export class AtendimentoRoutingModule {
}
