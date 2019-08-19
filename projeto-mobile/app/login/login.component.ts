import { Component, ElementRef, ViewChild } from "@angular/core";
import { alert, prompt } from "tns-core-modules/ui/dialogs";
import { Page } from "tns-core-modules/ui/page";
import { RouterExtensions } from "nativescript-angular/router";

import { User } from "../shared/user.model";
import { UserService } from "../shared/user.service";
import { ListPicker } from "tns-core-modules/ui/list-picker";

@Component({
    selector: "app-login",
    moduleId: module.id,
    templateUrl: "./login.component.html",
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    isLoggingIn = true;
    user: User;
    processing = false;
    tiposUsuarios: Array<string> = [];
    picked: string;
    @ViewChild("password", { static: false }) password: ElementRef;
    @ViewChild("confirmPassword", { static: false }) confirmPassword: ElementRef;

    constructor(private page: Page, private userService: UserService, private routerExtensions: RouterExtensions) {
        this.page.actionBarHidden = true;
        this.user = new User();
        this.carregaTipoUsuario();
    }

    toggleForm() {
        this.isLoggingIn = !this.isLoggingIn;
    }

    submit() {
        this.routerExtensions.navigate(["/home"], { clearHistory: true });
        /*
        if (!this.user.email || !this.user.password) {
            this.alert("Por favor, forneça um endereço de e-mail e senha.");
            return;
        }

        this.processing = true;
        if (this.isLoggingIn) {
            this.login();
        } else {
            this.register();
        }
        */
    }

    login() {
        this.userService.login(this.user)
            .then(() => {
                this.processing = false;
                this.routerExtensions.navigate(["/home"], { clearHistory: true });
            })
            .catch(() => {
                this.processing = false;
                this.alert("Infelizmente não conseguimos encontrar sua conta.");
            });
    }

    register() {
        if (this.user.password != this.user.confirmPassword) {
            this.alert("Suas senhas não conferem.");
            return;
        }
        this.userService.register(this.user)
            .then(() => {
                this.processing = false;
                this.alert("Sua conta foi criada com sucesso.");
                this.isLoggingIn = true;
            })
            .catch(() => {
                this.processing = false;
                this.alert("Infelizmente não conseguimos criar sua conta.");
            });
    }

    forgotPassword() {
        prompt({
            title: "Esqueceu a senha",
            message: "Digite o endereço de e-mail que você usou para se inscrever no OCD-Mobile para redefinir sua senha",
            inputType: "email",
            defaultText: "",
            okButtonText: "Ok",
            cancelButtonText: "Cancel"
        }).then((data) => {
            if (data.result) {
                this.userService.resetPassword(data.text.trim())
                    .then(() => {
                        this.alert("\n" +
                            "Sua senha foi redefinida com sucesso. Por favor, verifique seu e-mail para obter instruções sobre como escolher uma nova senha.");
                    }).catch(() => {
                        this.alert("Infelizmente, ocorreu um erro ao redefinir sua senha.");
                    });
            }
        });
    }

    focusPassword() {
        this.password.nativeElement.focus();
    }
    focusConfirmPassword() {
        if (!this.isLoggingIn) {
            this.confirmPassword.nativeElement.focus();
        }
    }

    public selectedIndexChanged(args) {
        let picker = <ListPicker>args.object;
        this.picked = this.tiposUsuarios[picker.selectedIndex];
    }

    alert(message: string) {
        return alert({
            title: "OCD-Mobile",
            okButtonText: "OK",
            message: message
        });
    }

    carregaTipoUsuario(): void {
        this.tiposUsuarios.push("Dentista");
        this.tiposUsuarios.push("Auxiliar SB");
        this.tiposUsuarios.push("Técnico em Enfermagem");
        this.tiposUsuarios.push("Enfermeiro");
        this.tiposUsuarios.push("Agente de Saúde");
    }
}

