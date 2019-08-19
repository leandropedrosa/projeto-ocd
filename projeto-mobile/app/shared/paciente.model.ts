import { User } from "./user.model";

export class Paciente {
    id: number;
    nome: string;
    dtNascimento: Date;
    sexo: string;
    nomeMae: string;
    cpf: string;
    numCartaoSus: string;
    numTelefone: string;
    email: string;
    localAtendimento: string;
    lesoes: Array<string> = [];
    dtRetornoSugerido: Date;
    dtRetorno: Date;
    dtConsuta: Date;
    usuario: User;

    procedimento: string;
    status: String;
    dtUltima: String;
}
