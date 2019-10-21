import {Component, NgZone} from "@angular/core";
import {RouterExtensions} from "nativescript-angular/router";
import {Page} from "tns-core-modules/ui/page";

@Component({
	selector: "Login",
	moduleId: module.id,
	templateUrl: "./prelogin.component.html",
	styleUrls: ['./prelogin.component.css']
})
export class PreloginComponent {

	constructor(
		private routerExtensions: RouterExtensions,
		private zone: NgZone,
		private page: Page) {
		this.page.actionBarHidden = true;
		this.page.backgroundSpanUnderStatusBar = true;
		this.page.className = "page-login-container";
		this.page.statusBarStyle = "dark";
	}

	login() {
		this.navigateHome();
	}
	private navigateHome() {
		this.zone.run(() => {
			this.routerExtensions.navigate(["/login"], {
				clearHistory: true,
				animated: true,
				transition: {
					name: "slideTop",
					duration: 350,
					curve: "ease"
				}
			});
		});
	}
}
