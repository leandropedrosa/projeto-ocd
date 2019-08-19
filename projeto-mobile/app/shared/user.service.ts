// The following is a sample implementation of a backend service using Progress Kinvey (https://www.progress.com/kinvey).
// Feel free to swap in your own service / APIs / etc here for your own apps.

import { Injectable } from "@angular/core";
import * as Kinvey from "kinvey-nativescript-sdk";
// TODO: should be imported from kinvey-nativescript-sdk/angular but declaration file is currently missing
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { User } from "./user.model";

@Injectable()
export class UserService {
    constructor(private kinveyUserService: KinveyUserService) { }

    register(user: User) {
        return this.kinveyUserService.signup({ username: user.email, password: user.password })
            .catch(this.handleErrors);
    }

    login(user: User) {
        return this.kinveyUserService.login(user.email, user.password)
            .catch(this.handleErrors);
    }

    logout() {
        return this.kinveyUserService.logout()
            .catch(this.handleErrors);
    }

    resetPassword(email) {
        return this.kinveyUserService.resetPassword(email)
            .catch(this.handleErrors);
    }

    handleErrors(error: Kinvey.Errors.BaseError) {
        console.error(error.message);
        return Promise.reject(error.message);
    }
}
