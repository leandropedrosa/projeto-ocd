import { ItemEventData } from "tns-core-modules/ui/list-view"
import { Component, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";

@Component({
    selector: "lista-pacientes",
    moduleId: module.id,
    templateUrl: "./lista-pacientes.component.html",
    styleUrls: ["./lista-pacientes.component.css"]
})
export class ListaPacientesComponent implements OnInit {

    onButtonTap(): void {
        console.log("Button was pressed");
    }

    textFieldValue: string = "";
    onItemTap(args: ItemEventData): void {
        console.log('Item with index: ' + args.index + ' tapped');
    }

    constructor(private routerExtensions: RouterExtensions) {
    }

    ngOnInit(): void {
    }

    onMenuHomeTap() {
        this.routerExtensions.navigate(["app-home"], { clearHistory: true });
    }


}
