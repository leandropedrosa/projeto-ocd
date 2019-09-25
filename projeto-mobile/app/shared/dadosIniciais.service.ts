import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {FatoresDeRisco} from "./fatoresDeRisco.model";
import {Lesao} from "./lesao.model";
import {LocalAtendimento} from "./localAtendimento.model";
import {HttpClient} from '@angular/common/http';

@Injectable()
export class DadosIniciaisService {
    constructor(
        private http: HttpClient
    ) {
    }

    getLesoes() {
        return this.http.get<Lesao[]>(environment.apiUrl + '/lesao');
    }

    getLocalAtendimento(regiao: String) {
        return this.http.get<LocalAtendimento[]>(environment.apiUrl + '/localDeAtendimento/regiao/{regiao}?regiao=' + regiao);
    }

    getFatoresDeRisco() {
        return this.http.get<FatoresDeRisco[]>(environment.apiUrl + '/fatorDeRisco');
    }
}