import {NgModule, NO_ERRORS_SCHEMA} from "@angular/core";
import {NativeScriptCommonModule} from "nativescript-angular/common";
import {HomeComponent} from "./home/home.component";
import {PacientesComponent} from "./pacientes/pacientes.component";
import {AcompanhamentoModule} from "./acompanhamento/acompanhamento.module";
import {NavigationRoutingModule} from "~/navigation/navigation-routing.module";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";
import {NativeScriptRouterModule} from "nativescript-angular";
import {RastreamentoComponent} from "~/navigation/rastreamento/rastreamento.component";
import {NavigationComponent} from "~/navigation/navigation.component";
import {PerfilComponent} from "~/navigation/perfil/perfil.component";
import {MonitoramentoComponent} from "~/navigation/monitoramento/monitoramento.component";
import {RouterModule} from "@angular/router";

@NgModule({
    imports: [
        NativeScriptCommonModule,
        NavigationRoutingModule,
        AcompanhamentoModule,
        RouterModule,
        NativeScriptUICalendarModule,
        NativeScriptUIChartModule,
        NativeScriptUIDataFormModule,
        NativeScriptUIAutoCompleteTextViewModule,
        NativeScriptUIGaugeModule,
        NativeScriptRouterModule,
    ],
    declarations: [
        NavigationComponent,
        HomeComponent,
        PerfilComponent,
        PacientesComponent,
        RastreamentoComponent,
        MonitoramentoComponent
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class NavigationModule { }
