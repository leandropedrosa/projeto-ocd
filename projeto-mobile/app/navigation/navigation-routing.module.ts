import {NgModule} from "@angular/core";
import {Routes} from "@angular/router";
import {NativeScriptRouterModule} from "nativescript-angular/router";
import {HomeComponent} from "./home/home.component";
import {RastreamentoComponent} from "~/navigation/rastreamento/rastreamento.component";
import {PerfilComponent} from "~/navigation/perfil/perfil.component";
import {MonitoramentoComponent} from "~/navigation/monitoramento/monitoramento.component";
import {PacientesComponent} from "~/navigation/pacientes/pacientes.component";
import {NavigationComponent} from "~/navigation/navigation.component";

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
