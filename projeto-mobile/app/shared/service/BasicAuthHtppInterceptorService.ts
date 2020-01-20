import {Injectable} from '@angular/core';
import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class BasicAuthHtppInterceptorService implements HttpInterceptor {

    constructor() {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        /*
                if (sessionStorage.getItem('cpf') && sessionStorage.getItem('token')) {
                    req = req.clone({
                        setHeaders: {
                            Authorization: sessionStorage.getItem('token')
                        }
                    })
                }
                */
        if (sessionStorage.getItem('cpfUser') && sessionStorage.getItem('basicauth')) {
            req = req.clone({
                setHeaders: {
                    Authorization: sessionStorage.getItem('basicauth')
                }
            })
        }


        return next.handle(req);

    }
}