// The following is a sample implementation of a backend service using Progress Kinvey (https://www.progress.com/kinvey).
// Feel free to swap in your own service / APIs / etc here for your own apps.

import { Injectable } from "@angular/core";
import { Http } from '@angular/http';
import { User } from "./user.model";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of, from } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    private url = 'http://localhost:8000';


    constructor(
        private httpClient: HttpClient
    ) {
    }

    login(cpf: String, password: String) {
        return this.httpClient.post<User>(this.url + '/authenticate', { cpf, password }).pipe(
            map(
                userData => {
                    sessionStorage.setItem('nameUser', userData.nome);
                    sessionStorage.setItem('regionUser', userData.regiao);
                    sessionStorage.setItem('cpfUser', userData.cpf);
                    sessionStorage.setItem('nivelAtencaoUser', userData.nivelAtencao);
                    let tokenStr = 'OCD ' + userData.token;
                    sessionStorage.setItem('token', tokenStr);
                    return userData;
                }
            )

        );
    }

    authenticateBasic(cpf: String, password: String) {
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(cpf + ':' + password) });
        return this.httpClient.get<User>(this.url + '/authenticateBasic', { headers }).pipe(
            map(
                userData => {
                    sessionStorage.setItem('nameUser', userData.nome);
                    sessionStorage.setItem('regionUser', userData.regiao);
                    sessionStorage.setItem('cpfUser', userData.cpf);
                    sessionStorage.setItem('nivelAtencaoUser', userData.nivelAtencao);
                    return userData;
                }
            )
        );
    }

    authenticateBasicAuth(cpf: String, password: String) {
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(cpf + ':' + password) });
        return this.httpClient.get<User>(this.url + '/authenticateBasic', { headers }).pipe(
            map(
                userData => {
                    sessionStorage.setItem('nameUser', userData.nome);
                    sessionStorage.setItem('regionUser', userData.regiao);
                    sessionStorage.setItem('cpfUser', userData.cpf);
                    sessionStorage.setItem('nivelAtencaoUser', userData.nivelAtencao);
                    let authString = 'Basic ' + btoa(cpf + ':' + password);
                    sessionStorage.setItem('basicauth', authString);
                    return userData;
                }
            )
        );
    }

    logout() {
        sessionStorage.removeItem('nameUser');
        sessionStorage.removeItem('regionUser');
        sessionStorage.removeItem('cpfUser');
        sessionStorage.removeItem('nivelAtencaoUser');
        sessionStorage.removeItem('token');
    }

    isUserLoggedIn() {
        let cpfSession = sessionStorage.getItem('cpfUser')
        //console.log(!(user === null))
        return !(cpfSession === null)
    }

    resetPassword(cpf) {
        return this.httpClient.get<any>(this.url + '/resetPassword/' + cpf);
    }

}
