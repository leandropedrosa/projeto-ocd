import { Component, ElementRef, ViewChild, OnInit } from "@angular/core";
import { alert, prompt } from "tns-core-modules/ui/dialogs";
import { Page } from "tns-core-modules/ui/page";
import { RouterExtensions } from "nativescript-angular/router";

import { User } from "../../shared/user.model";
import { AuthenticationService } from "../../shared/service/authentication.service";
import { ListPicker } from "tns-core-modules/ui/list-picker";

@Component({
    selector: "app-login",
    moduleId: module.id,
    templateUrl: "./login.component.html",
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    isLoggingIn = true;
    user: User;
    processing = false;
    nivelDeAtencao: Array<string> = [];
    @ViewChild("password", { static: false }) password: ElementRef;

    constructor(private page: Page, private authenticationService: AuthenticationService, private routerExtensions: RouterExtensions) {
    }
    ngOnInit(): void {
        this.page.actionBarHidden = true;
        this.user = new User();
        this.carregaTipoUsuario();
    }

    submit() {

        if (!this.user.cpf || !this.user.password) {
            alert("Por favor, forneça um endereço de e-mail e senha.");
            return;
        }

        this.processing = true;
        if (this.isLoggingIn) {
            this.login();
        }

    }

    login() {
        this.routerExtensions.navigate(["/navigation"], { clearHistory: true });
       /* (this.authenticationService.loginBasic(this.user).subscribe(
            data => {
                this.processing = false;
                this.routerExtensions.navigate(["/home"], { clearHistory: true });
            },
            error => {
                this.processing = false;
                alert("Infelizmente não conseguimos encontrar seu CPF.");
            }
        )
        );*/

    }

    forgotPassword() {

        prompt({
            title: "Esqueceu a senha",
            message: "Digite o  seu CPF que você usou para se inscrever no SobreVida-Mobile para redefinir sua senha",
            inputType: "cpf",
            defaultText: "",
            okButtonText: "Ok",
            cancelButtonText: "Cancel"
        }).then((data) => {
            if (data.result) {
                /*this.userService.resetPassword(data.text.trim())
                    .subscribe(
                        response => {
                            this.alert("Sua senha foi redefinida com sucesso. Por favor, verifique seu e-mail para obter instruções sobre como escolher uma nova senha.");
                        }, err => { alert("Infelizmente, ocorreu um erro ao redefinir sua senha."); }
                    );

                 */
            }
        })
    }
    focusPassword() {
        this.password.nativeElement.focus();
    }

    public selectedIndexChanged(args) {
        let picker = <ListPicker>args.object;
        this.user.cargo = this.nivelDeAtencao[picker.selectedIndex];
    }

    alert(message: string) {
        return alert({
            title: "SobreVida-Mobile",
            okButtonText: "OK",
            message: message
        });
    }

    carregaTipoUsuario(): void {
        this.nivelDeAtencao.push("Atenção Primária");
        this.nivelDeAtencao.push("Atenção Secundária");
    }
}

