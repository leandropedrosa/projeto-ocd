import { ItemEventData } from "tns-core-modules/ui/list-view"
import { Component, OnInit } from "@angular/core";
import { Paciente } from "../shared/paciente.model";
import { PacienteService } from "../shared/paciente.service";
import { RouterExtensions } from "nativescript-angular/router";

@Component({
    selector: "Home",
    moduleId: module.id,
    templateUrl: "./home.component.html",
    styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
    ngOnInit(): void {
    }
    onButtonTap(): void {
        console.log("Button was pressed");
    }

    textFieldValue: string = "";

    pacientes: Array<Paciente>;
    onItemTap(args: ItemEventData): void {
        console.log('Item with index: ' + args.index + ' tapped');
    }

    constructor(private routerExtensions: RouterExtensions, private pacienteService: PacienteService) {
        this.pacientes = pacienteService.getDataItems();
    }

    goAcompanhamento(): void {
        this.routerExtensions.navigate(["/acompanhamento"], { clearHistory: true });
    }


}
