import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { Rastreamento } from "./rastreamento.model";

@Injectable()
export class RastreamentoService {

    constructor(private kinveyUserService: KinveyUserService) { }

    salvar(rastreamento: Rastreamento): void {
    }
}