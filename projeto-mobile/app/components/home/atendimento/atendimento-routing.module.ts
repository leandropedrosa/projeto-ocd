import {NgModule} from '@angular/core';
import {Routes} from '@angular/router';
import {NativeScriptRouterModule} from 'nativescript-angular/router';
import {RastreamentoComponent} from '../atendimento/rastreamento/rastreamento.component';
import {MonitoramentoComponent} from '../atendimento/monitoramento/monitoramento.component';
import {ResultadosComponent} from '../atendimento/resultados/resultados.component';
import {BuscaPacientesComponent} from "../atendimento/busca-pacientes/busca-pacientes.component";

export const routes: Routes = [
    {path: '', redirectTo: 'busca-pacientes', pathMatch: 'full'},
    {path: 'busca-pacientes', component: BuscaPacientesComponent},
    {path: 'rastreamento', component: RastreamentoComponent},
    {path: 'monitoramento', component: MonitoramentoComponent},
    {path: 'resultados', component: ResultadosComponent},

];

@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)],
    exports: [NativeScriptRouterModule]
})
export class AtendimentoRoutingModule {
}
