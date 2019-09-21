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

    private url = 'https://ocd-backend.herokuapp.com/api/usuario';

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
                    sessionStorage.setItem('cargoUser', userData.cargo);
                    let tokenStr = 'OCD ' + userData.token;
                    sessionStorage.setItem('token', tokenStr);
                    return userData;
                }
            )

        );
    }

    authenticateBasic(user: User) { 
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.post<User>(this.url + '/authenticate/' + user, { headers }).pipe(
            map(
                userData => {
                    sessionStorage.setItem('nameUser', userData.nome);
                    sessionStorage.setItem('regionUser', userData.regiao);
                    sessionStorage.setItem('cpfUser', userData.cpf);
                    sessionStorage.setItem('cargoUser', userData.cargo);
                    return userData;
                }
            )
        );
    }

    authenticateBasicAuth(user: User) {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.post<User>(this.url + '/authenticateBasic' + user, { headers }).pipe(
            map(
                userData => {
                    sessionStorage.setItem('nameUser', userData.nome);
                    sessionStorage.setItem('regionUser', userData.regiao);
                    sessionStorage.setItem('cpfUser', userData.cpf);
                    sessionStorage.setItem('cargoUser', userData.cargo);
                    let authString = btoa(userData.cpf + ':' + userData.password);
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
        sessionStorage.removeItem('cargoUser');
        sessionStorage.removeItem('token');
    }

    isUserLoggedIn() {
        let cpfSession = sessionStorage.getItem('cpfUser')
        //console.log(!(user === null))
        return !(cpfSession === null)
    }

    resetPassword(cpf) {
        const headers = new HttpHeaders({ Authorization: btoa("admin" + ':' + "cf43d9b315407fd561c9ec352129d6ca") });
        return this.httpClient.get<any>(this.url + '/resetPassword/' + cpf, { headers });
    }

}
