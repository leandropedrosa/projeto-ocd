import {CidadeModel} from "~/shared/model/cidade.model";

export class BairroModel {
    id: string;
    nome: string;
    cidade: CidadeModel;
}