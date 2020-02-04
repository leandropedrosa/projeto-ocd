import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptCommonModule} from "nativescript-angular/common";
import {ListaPacientesComponent} from "./lista-pacientes/lista-pacientes.component";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";
import {NativeScriptRouterModule} from "nativescript-angular";
import {PerfilComponent} from "./perfil/perfil.component";
import {RouterModule} from "@angular/router";
import {AtendimentoModule} from "./atendimento/atendimento.module";
import {HomeRoutingModule} from "../home/home-routing.module";
import {HomeComponent} from "../home/home.component";

@NgModule({
    imports: [
        NativeScriptCommonModule,
        HomeRoutingModule,
        RouterModule,
        AtendimentoModule,
        NativeScriptUICalendarModule,
        NativeScriptUIChartModule,
        NativeScriptUIDataFormModule,
        NativeScriptUIAutoCompleteTextViewModule,
        NativeScriptUIGaugeModule,
        NativeScriptRouterModule,
    ],
    declarations: [
        HomeComponent,
        PerfilComponent,
        ListaPacientesComponent,
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class HomeModule {
}
