import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {User} from "../../shared/user.model";
import {environment} from "../../../environments/environment";
import {map} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    public user: User;

    constructor(private httpClient: HttpClient) {
    }

    loginBasic(user: User) {
        return this.httpClient.get(environment.API_URL + '/usuario/basicauth',
            {headers: {authorization: this.createBasicAuthToken(user)}}).pipe(map((res) => {
            this.user = user;
            console.log('Autenticado!');
            this.adicionaUsuarioNaSessao(user);
        }));
    }

    adicionaUsuarioNaSessao(user: User) {
        console.log('Adicionando na sessão');
        this.httpClient.get<any>(environment.API_URL + '/usuario/getByCPF/{cpf}?cpf=' + user.cpf).subscribe(
            userData => {
                this.registerSuccessfulLogin(userData);
            }
        );
    }

    createBasicAuthToken(user: User) {
        return 'Basic ' + Buffer.from(user.cpf + ":" + user.password).toString('base64');
    }

    registerSuccessfulLogin(user: User) {
        user.authdata = this.createBasicAuthToken(user);
        localStorage.setItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME, JSON.stringify(user));
        console.log('Adicionado na sessão!');
        console.log(JSON.parse(localStorage.getItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME)));
        //sessionStorage.setItem(environment.USER_NAME_SESSION_ATTRIBUTE_NAME, JSON.stringify(user));
    }
}