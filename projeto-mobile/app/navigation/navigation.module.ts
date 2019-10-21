import { NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { NativeScriptCommonModule } from "nativescript-angular/common";
import { HomeComponent } from "./home/home.component";
import {Pacientescomponent} from "./listagem/pacientescomponent";
import {AcompanhamentoModule} from "./acompanhamento/acompanhamento.module";
import {NavigationRoutingModule} from "~/navigation/navigation-routing.module";
import {NativeScriptUISideDrawerModule} from "nativescript-ui-sidedrawer/angular";
import {NativeScriptUIListViewModule} from "nativescript-ui-listview/angular";
import {NativeScriptUICalendarModule} from "nativescript-ui-calendar/angular";
import {NativeScriptUIChartModule} from "nativescript-ui-chart/angular";
import {NativeScriptUIDataFormModule} from "nativescript-ui-dataform/angular";
import {NativeScriptUIAutoCompleteTextViewModule} from "nativescript-ui-autocomplete/angular";
import {NativeScriptUIGaugeModule} from "nativescript-ui-gauge/angular";
import {NativeScriptFormsModule} from "nativescript-angular";
import {MatriciamentoComponent} from "~/navigation/matriciamento/matriciamento.component";
import {NavigationComponent} from "~/navigation/navigation.component";
import {AcompanhamentoRoutingModule} from "~/navigation/acompanhamento/acompanhamento-routing.module";
import {RadioButtonModule} from "@webileapps/nativescript-radiobutton/angular/module";

@NgModule({
    imports: [
        NativeScriptCommonModule,
        NavigationRoutingModule,
        AcompanhamentoModule,
        NativeScriptUICalendarModule,
        NativeScriptUIChartModule,
        NativeScriptUIDataFormModule,
        NativeScriptUIAutoCompleteTextViewModule,
        NativeScriptUIGaugeModule,
    ],
    declarations: [
        HomeComponent,
        Pacientescomponent,
        MatriciamentoComponent,
        NavigationComponent,
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class NavigationModule { }
