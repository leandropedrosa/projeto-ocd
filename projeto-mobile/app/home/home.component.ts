import { ItemEventData } from "tns-core-modules/ui/list-view"
import { Component, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { RastreamentoService } from "../shared/rastreamento.service";
import { Paciente } from "../shared/paciente.model";
@Component({
    selector: "Home",
    moduleId: module.id,
    templateUrl: "./home.component.html",
    styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {

    pacientes: Array<Paciente>;
    onButtonTap(): void {
        console.log("Button was pressed");
    }

    textFieldValue: string = "";
    onItemTap(args: ItemEventData): void {
        console.log('Item with index: ' + args.index + ' tapped');
    }

    constructor(private routerExtensions: RouterExtensions, private rastreamentoService: RastreamentoService) {
    }

    ngOnInit(): void {
        this.rastreamentoService.getPaciente(localStorage.getItem('regionUser')).subscribe(
            response => {
                this.pacientes = response;
            });
    }

    goAcompanhamento(): void {
        this.routerExtensions.navigate(["/acompanhamento"], { clearHistory: true });
    }


}
