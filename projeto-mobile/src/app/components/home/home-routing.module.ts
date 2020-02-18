import {NgModule} from "@angular/core";
import {Routes} from "@angular/router";
import {NativeScriptRouterModule} from "nativescript-angular/router";
import {PerfilComponent} from "./perfil/perfil.component";
import {ListaPacientesComponent} from "./lista-pacientes/lista-pacientes.component";
import {HomeComponent} from "./home.component";

export const routes: Routes = [
    {path: "", redirectTo: "app-home", pathMatch: "full"},
    {path: "app-home", component: HomeComponent},
    {path: "perfil", component: PerfilComponent},
    {path: "lista-pacientes", component: ListaPacientesComponent},
    {path: "atendimento",loadChildren: () => import("./atendimento/atendimento.module").then(m => m.AtendimentoModule)},

];

@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)],
    exports: [NativeScriptRouterModule]
})
export class HomeRoutingModule {
}
