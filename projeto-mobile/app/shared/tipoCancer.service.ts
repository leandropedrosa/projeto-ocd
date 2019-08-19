import { Injectable } from "@angular/core";
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { FatoresDeVunerabilidade } from "./fatoresVunerabilidade.model";
import { TipoCancer } from "./tipoCancer.model";

@Injectable()
export class TipoCancerService {

    constructor(private kinveyUserService: KinveyUserService) { }

    getTipoCancer(): Array<TipoCancer> {
        let tiposCancer: Array<TipoCancer> = new Array<TipoCancer>();

        let boca: TipoCancer = new TipoCancer();
        boca.id = 1;
        boca.nome = "Câncer de Boca";
        boca.listaDeFatores = this.getFatores(boca.id);

        let coloDeUtero: TipoCancer = new TipoCancer();
        coloDeUtero.id = 2;
        coloDeUtero.nome = "Câncer de Colo de Útero";
        coloDeUtero.listaDeFatores = this.getFatores(coloDeUtero.id);

        tiposCancer.push(boca);
        tiposCancer.push(coloDeUtero);
        return tiposCancer;

    }
    getFatores(idTipoCancer: Number): Array<FatoresDeVunerabilidade> {
        let fatores: Array<FatoresDeVunerabilidade> = new Array<FatoresDeVunerabilidade>();
        if (idTipoCancer === 0) {
            let idade: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(1, "Idade", idTipoCancer);
            let fumante: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(2, "É fumante", idTipoCancer);
            let exposicaoSol: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(3, "Exposição ao sol", idTipoCancer);
            let hitoriaDoenca: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(4, "Possui história da doença", idTipoCancer);
            let bebida: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(5, "Faz uso de bebida álcoolica", idTipoCancer);

            fatores.push(idade);
            fatores.push(fumante);
            fatores.push(exposicaoSol);
            fatores.push(hitoriaDoenca);
            fatores.push(bebida);
        } else {
            let teste1: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(1, "teste1", idTipoCancer);
            let teste2: FatoresDeVunerabilidade = new FatoresDeVunerabilidade(2, "teste2", idTipoCancer);
            fatores.push(teste1);
            fatores.push(teste2);
        }
        return fatores;
    }
}