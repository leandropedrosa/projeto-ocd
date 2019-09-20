import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { FatoresDeRisco } from "./fatoresDeRisco.model";
import { Lesao } from "./lesao.model";
import { User } from "./user.model";
import { LocalAtendimento } from "./localAtendimento.model";
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DadosIniciaisService {
    private url = 'http://localhost:8000'

    constructor(
        private httpClient: HttpClient
    ) {
    }

    getLesoes() {
        console.log("test call");
        return this.httpClient.get<Lesao[]>(this.url + '/lesoes');
    }

    getLocalAtendimento(regiao: String) {
        console.log("test call");
        return this.httpClient.get<LocalAtendimento[]>(this.url + '/localAtendimento/' + regiao);
    }

    getFatoresDeRisco() {
        console.log("test call");
        return this.httpClient.get<FatoresDeRisco[]>(this.url + '/fatoresDeRisco');
    }
}