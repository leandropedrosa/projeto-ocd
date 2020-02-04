import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptCommonModule} from "nativescript-angular/common";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";
import {NativeScriptRouterModule} from "nativescript-angular";
import {RastreamentoComponent} from "../atendimento/rastreamento/rastreamento.component";
import {MonitoramentoComponent} from "../atendimento/monitoramento/monitoramento.component";
import {RouterModule} from "@angular/router";
import {ResultadosComponent} from "../atendimento/resultados/resultados.component";
import {PacienteService} from "~/shared/service/paciente.service";
import {AtendimentoRoutingModule} from "../atendimento/atendimento-routing.module";
import {AtendimentoComponent} from "../atendimento/atendimento.component";
import {BuscaPacientesComponent} from "../atendimento/busca-pacientes/busca-pacientes.component";

@NgModule({
    imports: [
        NativeScriptCommonModule,
        RouterModule,
        AtendimentoRoutingModule,
        NativeScriptUICalendarModule,
        NativeScriptUIChartModule,
        NativeScriptUIDataFormModule,
        NativeScriptUIAutoCompleteTextViewModule,
        NativeScriptUIGaugeModule,
        NativeScriptRouterModule,
    ],
    declarations: [
        AtendimentoComponent,
        RastreamentoComponent,
        MonitoramentoComponent,
        ResultadosComponent,
        BuscaPacientesComponent,
    ],
    providers: [
        PacienteService
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AtendimentoModule { }
