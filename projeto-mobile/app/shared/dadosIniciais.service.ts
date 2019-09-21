import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { FatoresDeRisco } from "./fatoresDeRisco.model";
import { Lesao } from "./lesao.model";
import { User } from "./user.model";
import { LocalAtendimento } from "./localAtendimento.model";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class DadosIniciaisService {
    private url = 'https://ocd-backend.herokuapp.com/api';

    constructor(
        private httpClient: HttpClient
    ) {
    }

    getLesoes() {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.get<Lesao[]>(this.url + '/lesao', { headers });
    }

    getLocalAtendimento(regiao: String) {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.get<LocalAtendimento[]>(this.url + '/localDeAtendimento/' + regiao, { headers });
    }

    getFatoresDeRisco() {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.get<FatoresDeRisco[]>(this.url + '/fatorDeRisco', { headers });
    }
}