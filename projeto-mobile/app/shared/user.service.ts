import {Injectable} from "@angular/core";
import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";
import 'nativescript-localstorage';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(
        private httpClient: HttpClient
    ) {
    }

    resetPassword(cpf) {
        return this.httpClient.get<any>(environment.apiUrl + '/usuario/resetPassword/' + cpf);
    }
}
