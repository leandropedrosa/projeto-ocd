import {NgModule} from "@angular/core";
import {Routes} from "@angular/router";
import {NativeScriptRouterModule} from "nativescript-angular/router";
import {HomeComponent} from "./home/home.component";
import {RastreamentoComponent} from "./atendimento/rastreamento/rastreamento.component";
import {PerfilComponent} from "../../components/navigation/perfil/perfil.component";
import {MonitoramentoComponent} from "./atendimento/monitoramento/monitoramento.component";
import {PacientesComponent} from "../../components/navigation/pacientes/pacientes.component";
import {NavigationComponent} from "../../components/navigation/navigation.component";

export const routes: Routes = [
    {path: "", redirectTo: "/Navigation", pathMatch: "full"},
    {
        path: "Navigation", component: NavigationComponent, children: [
            {path: "", component: HomeComponent, outlet: "center"},
            {path: "Perfil", component: PerfilComponent},
            {path: "Pacientes", component: PacientesComponent},
            {path: "Rastreamento", component: RastreamentoComponent},
            {path: "Monitoramento", component: MonitoramentoComponent},
        ]
    }
];
@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)]
})
export class NavigationRoutingModule {
}
