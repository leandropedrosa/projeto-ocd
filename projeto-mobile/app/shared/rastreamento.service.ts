import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {Rastreamento} from "./rastreamento.model";
import {Paciente} from "./paciente.model";
import {HttpClient} from '@angular/common/http';

@Injectable()
export class RastreamentoService {
    constructor(
        private httpClient: HttpClient
    ) {
    }

    getPaciente(regiao: String) {
        return this.httpClient.get<Paciente[]>(environment.apiUrl + '/paciente/' + regiao);
    }

    public finalizar(rastreamento) {
        return this.httpClient.post<Rastreamento>(environment.apiUrl + '/rastreamento', rastreamento);
    }
}