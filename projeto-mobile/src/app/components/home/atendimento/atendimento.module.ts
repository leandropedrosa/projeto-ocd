import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptCommonModule} from "nativescript-angular/common";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";
import {NativeScriptRouterModule} from "nativescript-angular";
import {IntervencaoComponent} from "./intervencao/intervencao.component";
import {RouterModule} from "@angular/router";
import {ResultadosComponent} from "../atendimento/resultados/resultados.component";
import {PacienteService} from "~/shared/service/paciente.service";
import {AtendimentoRoutingModule} from "./atendimento-routing.module";
import {AtendimentoComponent} from "./atendimento.component";
import {RastreamentoModule} from "./rastreamento/rastreamento.module";
import {VerticalTimelineModule} from "angular-vertical-timeline";
import {NativeScriptUIListViewModule} from "nativescript-ui-listview/angular";

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
        VerticalTimelineModule,
        RastreamentoModule,
        NativeScriptUIListViewModule,
    ],
    declarations: [
        AtendimentoComponent,
        IntervencaoComponent,
        ResultadosComponent,
    ],
    providers: [
        PacienteService
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AtendimentoModule { }
