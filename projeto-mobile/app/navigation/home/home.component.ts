import {Component, OnInit} from "@angular/core";
import {RouterExtensions} from "nativescript-angular/router";
import {Page} from "tns-core-modules/ui/page";
import * as app from "tns-core-modules/application";
import { RadSideDrawer } from "nativescript-ui-sidedrawer";

@Component({
    selector: "Home",
    moduleId: module.id,
    templateUrl: "./home.component.html",
    styleUrls: ['./home.component.css']
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
        this.routerExtensions.navigate(["login"], { clearHistory: true });
    }

    onMenuButtonTap(menu: String) {
        this.routerExtensions.navigate([menu], { clearHistory: true });
    }

    onProfileButtonTap(){

    }

    onDrawerButtonTap(): void {
        const sideDrawer = <RadSideDrawer>app.getRootView();
        sideDrawer.showDrawer();
    }
}