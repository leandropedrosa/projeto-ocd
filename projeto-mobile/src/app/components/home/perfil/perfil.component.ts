import {Component, OnInit} from "@angular/core";
import {RouterExtensions} from "nativescript-angular";
import {ItemEventData} from "@nativescript/core";


@Component({
    selector: "perfil",
    moduleId: module.id,
    templateUrl: "./perfil.component.html",
    styleUrls: ["./perfil.component.css"]
})
export class PerfilComponent implements OnInit {
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
        this.routerExtensions.navigate(["app-home"], {clearHistory: true});
    }
}
