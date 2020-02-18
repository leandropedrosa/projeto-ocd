import {Component, OnInit} from "@angular/core";
import {Page} from "tns-core-modules/ui/page";
import {RouterExtensions} from "nativescript-angular/router";

@Component({
    selector: "home",
    moduleId: module.id,
    templateUrl: "./home.component.html",
    styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
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
