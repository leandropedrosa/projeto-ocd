import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { Rastreamento } from "./rastreamento.model";
import { Paciente } from "./paciente.model";
import { HttpClient } from '@angular/common/http';

@Injectable()
export class RastreamentoService {
    private url = 'http://localhost:8000';
    constructor(
        private httpClient: HttpClient
    ) {
    }

    getPaciente(regiao: String) {
        return this.httpClient.get<Paciente[]>(this.url + "/paciente/" + regiao);
    }

    public finalizar(rastreamento) {
        return this.httpClient.post<Rastreamento>(this.url + "rastreamento", rastreamento);
    }
}