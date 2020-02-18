import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptCommonModule} from "nativescript-angular/common";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";
import {NativeScriptFormsModule, NativeScriptRouterModule} from "nativescript-angular";
import {RouterModule} from "@angular/router";
import {PacienteService} from "~/shared/service/paciente.service";
import {CadastroPacienteComponent} from "./cadastro-paciente/cadastro-paciente.component";
import {AvaliacaoClinicaComponent} from "./avaliacao-clinica/avaliacao-clinica.component";
import {CondutaComponent} from "./conduta/conduta.component";
import {SearchAirportComponent} from "./search-airport/search-airport.component";
import {RastreamentoComponent} from "./rastreamento.component";
import {NativeScriptUIListViewModule} from "nativescript-ui-listview/angular";
import {RastreamentoRoutingModule} from "./rastreamento-routing.module";


@NgModule({
    imports: [
        NativeScriptCommonModule,
        RouterModule,
        NativeScriptUICalendarModule,
        NativeScriptUIChartModule,
        NativeScriptUIDataFormModule,
        NativeScriptUIAutoCompleteTextViewModule,
        NativeScriptUIGaugeModule,
        NativeScriptRouterModule,
        NativeScriptUIListViewModule,
        NativeScriptUIAutoCompleteTextViewModule,
        NativeScriptCommonModule,
        RastreamentoRoutingModule,
        NativeScriptFormsModule
    ],
    declarations: [
        RastreamentoComponent,
        CadastroPacienteComponent,
        AvaliacaoClinicaComponent,
        CondutaComponent,
        SearchAirportComponent
    ],
    entryComponents: [
        SearchAirportComponent
    ],
    providers: [
        PacienteService
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class RastreamentoModule { }
