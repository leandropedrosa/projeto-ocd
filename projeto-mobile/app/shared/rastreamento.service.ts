import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { Rastreamento } from "./rastreamento.model";
import { Paciente } from "./paciente.model";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class RastreamentoService {
    private url = 'https://ocd-backend.herokuapp.com/api';
    constructor(
        private httpClient: HttpClient
    ) {
    }

    getPaciente(regiao: String) {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.get<Paciente[]>(this.url + "/paciente/" + regiao, { headers });
    }

    public finalizar(rastreamento) {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.post<Rastreamento>(this.url + "/rastreamento", rastreamento, { headers });
    }
}