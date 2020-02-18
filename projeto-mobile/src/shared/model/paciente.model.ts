import {BairroModel} from "~/shared/model/bairro.model";

export class PacienteModel {
    id: string;
    nome: string;
    dataNascimento: Date;
    sexo: string;
    email: string;
    telefoneCelular: string;
    nomeMae: string;
    bairro: BairroModel;
    telefoneResponsavel: string;

}