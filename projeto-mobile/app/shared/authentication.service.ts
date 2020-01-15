import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {User} from "~/shared/user.model";
import {environment} from "../../environments/environment";
import 'nativescript-localstorage';

@Injectable({providedIn: 'root'})
export class AuthenticationService {
    public user: User

    constructor(private http: HttpClient) {
    }

    loginBasic(user: User) {
        return this.http.get(environment.apiUrl + '/usuario/basicauth',
            {headers: {authorization: this.createBasicAuthToken(user)}}).pipe(map((res) => {
            this.user = user;
            console.log('Autenticado!');
            this.adicionaUsuarioNaSessao(user);
        }));
    }

    /*
        login(user: User): Observable<any> {
            var applicationSettings = require("application-settings");
            return this.http.post<any>(environment.apiUrl + '/usuario/login/'+user.cpf+"/"+user.password, { cpf: user.cpf, password: user.password })
                .pipe(
                    map(user => {
                        console.log("Autenticado!");
                        if (user) {
                            console.log(JSON.stringify(user));
                            localStorage.setItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME, JSON.stringify(user));
                            let environment.USER_NAME_SESSION_ATTRIBUTE_NAME = JSON.parse(localStorage.getItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME));
                            console.log(environment.USER_NAME_SESSION_ATTRIBUTE_NAME);
                        }

                        return user;
                    })
                );
        }

        authenticationService(user: User) {
            console.log(environment.apiUrl + '/usuario/validateLogin');
            console.log(this.createBasicAuthToken(user));

            const headers = new HttpHeaders({Authorization: this.createBasicAuthToken(user)});
            //headers.append("Content-Type", "application/json");

            return this.http.post<any>(environment.apiUrl + '/usuario/validateLogin'
                , {headers: headers})
                .pipe(map(user => {
                    console.log("Autenticado!");
                    // login successful if there's a user in the response
                    if (user) {
                        // store user details and basic auth credentials in local storage
                        // to keep user logged in between page refreshes
                        user.authdata = this.createBasicAuthToken(user);
                        localStorage.setItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME, JSON.stringify(user));
                    }
                    return user;
                }));
        }

        loginJWT(user: User) {
            return this.http.post<User>(environment.apiUrl + '/usuario/validateLogin', {cpf: user.cpf, password: user.password}).pipe(
                map(
                    userData => {
                        sessionStorage.setItem('cpfUser', userData.cpf);
                        let tokenStr = 'OCD ' + userData.token;
                        sessionStorage.setItem('token', tokenStr);
                        return userData;
                    }
                )
            );
        }

        loginBasicAuth(user: User) {
            console.log(this.createBasicAuthToken(user));
            const headers = new HttpHeaders({Authorization: this.createBasicAuthToken(user)});
            return this.http.post<User>(environment.apiUrl + '/usuario/authenticateBasic', {headers}).pipe(
                map(
                    resposta => {
                        console.log(resposta);
                        sessionStorage.setItem('cpfUser', user.cpf);
                        sessionStorage.setItem('basicauth', this.createBasicAuthToken(user));
                        return user;
                    }
                )
            );
        }
    */

    logout() {
        localStorage.removeItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME);
    }

    isUserLoggedIn() {
        let user = localStorage.getItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME)
        if (user === null) return false
        return true
    }

    getLoggedInUser() {
        let user: User = JSON.parse(localStorage.getItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME));
        if (user === null) return null;
        return user
    }

    createBasicAuthToken(user: User) {
        return 'Basic ' + Buffer.from(user.cpf + ":" + user.password).toString('base64');
    }

    createBasicAuthTokenInterceptor() {
        return 'Basic ' + Buffer.from(this.user.cpf + ":" + this.user.password).toString('base64');
    }

    adicionaUsuarioNaSessao(user: User) {
        console.log('Adicionando na sessão');
        this.http.get<any>(environment.apiUrl + '/usuario/getByCPF/{cpf}?cpf=' + user.cpf).subscribe(
            userData => {
                this.registerSuccessfulLogin(userData);
            }
        );
    }

    registerSuccessfulLogin(user: User) {
        user.authdata = this.createBasicAuthToken(user);
        localStorage.setItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME, JSON.stringify(user));
        console.log('Adicionado na sessão!');
        console.log(JSON.parse(localStorage.getItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME)));
        //sessionStorage.setItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME, JSON.stringify(user));
    }
}