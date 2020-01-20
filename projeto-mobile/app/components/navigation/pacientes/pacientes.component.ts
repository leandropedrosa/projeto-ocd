import { ItemEventData } from "tns-core-modules/ui/list-view"
import { Component, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { RastreamentoService } from "../../../shared/rastreamento.service";
import { Paciente } from "../../../shared/paciente.model";
import {AuthenticationService} from "~/shared/service/authentication.service";
@Component({
    selector: "Pacientes",
    moduleId: module.id,
    templateUrl: "./pacientes.component.html",
    styleUrls: ["./pacientes.component.css"]
})
export class PacientesComponent implements OnInit {

    pacientes: Array<Paciente>;
    onButtonTap(): void {
        console.log("Button was pressed");
    }

    textFieldValue: string = "";
    onItemTap(args: ItemEventData): void {
        console.log('Item with index: ' + args.index + ' tapped');
    }

    constructor(private routerExtensions: RouterExtensions, private rastreamentoService: RastreamentoService, private authenticationService: AuthenticationService) {
    }

    ngOnInit(): void {
        let currentUser = this.authenticationService.getLoggedInUser();
        /*this.rastreamentoService.getPaciente(currentUser.regiao).subscribe(
            response => {
                this.pacientes = response;
            });*/
    }

    onMenuHomeTap() {
        this.routerExtensions.navigate(["Home"], { clearHistory: true });
    }


}
