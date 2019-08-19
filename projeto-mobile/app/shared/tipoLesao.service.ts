import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { Lesao } from "./lesao.model";
import { TipoLesao } from "./tipoLesao.model";

@Injectable()
export class TipoLesaoService {

    constructor(private kinveyUserService: KinveyUserService) { }

    getTipoLesao(): Array<TipoLesao> {
        let tiposLesao: Array<TipoLesao> = new Array<TipoLesao>();

        let maligna: TipoLesao = new TipoLesao();
        maligna.id = 1;
        maligna.nome = "Malígna";
        maligna.lesoes = this.getLesoes(maligna);

        let pm: TipoLesao = new TipoLesao();
        pm.id = 2;
        pm.nome = "PM";
        pm.lesoes = this.getLesoes(pm);

        let outra: TipoLesao = new TipoLesao();
        outra.id = 2;
        outra.nome = "Outra";
        outra.lesoes = this.getLesoes(outra);

        tiposLesao.push(maligna);
        tiposLesao.push(pm);
        tiposLesao.push(outra);
        return tiposLesao;

    }
    getLesoes(tipoLesao: TipoLesao): Array<Lesao> {
        let lesoes: Array<Lesao> = new Array<Lesao>();
        switch (tipoLesao.id) {
            case 1:
                let teste1: Lesao = new Lesao(1, "teste1", tipoLesao);
                let teste2: Lesao = new Lesao(2, "teste2", tipoLesao);
                lesoes.push(teste1);
                lesoes.push(teste2);
                break;
            case 2:
                let teste3: Lesao = new Lesao(1, "teste3", tipoLesao);
                let teste4: Lesao = new Lesao(2, "teste4", tipoLesao);
                lesoes.push(teste3);
                lesoes.push(teste4);
                break;
            case 3:
                let teste5: Lesao = new Lesao(1, "teste5", tipoLesao);
                let teste6: Lesao = new Lesao(2, "teste6", tipoLesao);
                lesoes.push(teste5);
                lesoes.push(teste6);
                break;
        }
        return lesoes;
    }
}