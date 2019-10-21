import {NgModule} from "@angular/core";
import {Routes} from "@angular/router";
import {NativeScriptRouterModule} from "nativescript-angular/router";

import {HomeComponent} from "./home/home.component";
import {Pacientescomponent} from "./listagem/pacientescomponent";
import {AuthGuard} from ".././shared/authGaurd.service";
import {MatriciamentoComponent} from "~/navigation/matriciamento/matriciamento.component";
import {NavigationComponent} from "~/navigation/navigation.component";

const routes: Routes = [
    {
        path: "",
        component: HomeComponent,
       // canActivate: [AuthGuard],
        children: [
            { path: "Pacientes", component: Pacientescomponent },
            { path: "Matriciamento", component: MatriciamentoComponent },
            { path: "Acompanhamento", loadChildren: "./acompanhamento/acompanhamento.module#AcompanhamentoModule"},
        ]
    }
];

@NgModule({
    imports: [NativeScriptRouterModule.forChild(routes)]
})
export class NavigationRoutingModule {
}
