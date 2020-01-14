import {Component, OnInit} from "@angular/core";
import {Page} from "tns-core-modules/ui/page";
import {Router} from "@angular/router";

@Component({
    selector: "Navigation",
    moduleId: module.id,
    templateUrl: "./navigation.component.html",
    styleUrls: ["./navigation.component.css"]
})
export class NavigationComponent implements OnInit {
    loggedUser: string;

    constructor(
        private router: Router,
        private page: Page) {
        this.page.actionBarHidden = false;
    }

    ngOnInit(): void {
        this.loggedUser = "teste";
        this.page.actionBarHidden = true;
    }
}
