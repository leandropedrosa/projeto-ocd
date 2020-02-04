import {AfterViewInit, Component, OnInit} from "@angular/core";
import {PacienteModel} from "~/shared/model/paciente.model";
import {BairroModel} from "~/shared/model/bairro.model";
import {RouterExtensions} from "nativescript-angular/router";

@Component({
    selector: "Rastreamento",
    moduleId: module.id,
    templateUrl: "./rastreamento.component.html",
    styleUrls: ["./rastreamento.component.css"]
})
export class RastreamentoComponent implements OnInit, AfterViewInit {
    private _paciente: PacienteModel;

    constructor(private routerExtensions: RouterExtensions) {
    }

    ngOnInit() {
        this._paciente = new PacienteModel();
        this._paciente = {
            id: "2",
            nome: "",
            sexo: "",
            dataNascimento: new Date(),
            email: "",
            telefoneCelular: "",
            nomeMae: "",
            bairro: new BairroModel(),
            telefoneResponsavel: ""
        };
    }

    ngAfterViewInit() {

    }

    get pacienteOrder() {
        return this._paciente;
    }

    novoMonitoramento(){
        this.routerExtensions.navigate(["monitoramento"], { clearHistory: true });
    }
}