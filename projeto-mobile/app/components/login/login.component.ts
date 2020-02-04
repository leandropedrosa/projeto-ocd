import { Component, ElementRef, ViewChild, OnInit } from "@angular/core";
import { alert, prompt } from "tns-core-modules/ui/dialogs";
import { Page } from "tns-core-modules/ui/page";
import { RouterExtensions } from "nativescript-angular/router";
import {UsuarioModel} from "~/shared/model/usuario.model";

@Component({
    selector: "login",
    moduleId: module.id,
    templateUrl: "./login.component.html",
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    isLoggingIn = true;
    user: UsuarioModel;
    processing = false;
    nivelDeAtencao: Array<string> = [];
    @ViewChild("password", { static: false }) password: ElementRef;

    constructor(private page: Page, private routerExtensions: RouterExtensions) {
    }
    ngOnInit(): void {
        this.page.actionBarHidden = true;
        this.user = new UsuarioModel();
    }

    submit() {

        if (!this.user.cpf || !this.user.senha) {
            alert("Por favor, forneça um endereço de e-mail e senha.");
            return;
        }

        this.processing = true;
        if (this.isLoggingIn) {
            this.login();
        }

    }

    login() {
        this.routerExtensions.navigate(["/home"], { clearHistory: true });
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

    alert(message: string) {
        return alert({
            title: "SobreVida-Mobile",
            okButtonText: "OK",
            message: message
        });
    }
}

