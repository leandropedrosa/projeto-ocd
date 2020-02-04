import {Component, OnInit} from "@angular/core";
import {Page} from "tns-core-modules/ui/page";
import {RouterExtensions} from "nativescript-angular/router";

@Component({
    selector: "atendimento",
    moduleId: module.id,
    templateUrl: "./atendimento.component.html",
    styleUrls: ["./atendimento.component.css"]
})
export class AtendimentoComponent implements OnInit {
    loggedUser: string;

    constructor(
        private routerExtensions: RouterExtensions,
        private page: Page) {
        this.page.actionBarHidden = false;
    }

    ngOnInit(): void {
        this.loggedUser = "teste";
        this.page.actionBarHidden = true;
    }

    logout() {
        this.routerExtensions.navigate([""], {clearHistory: true});
    }

    direciona(url:string){
        this.routerExtensions.navigate([url], { clearHistory: true });
    }
}
