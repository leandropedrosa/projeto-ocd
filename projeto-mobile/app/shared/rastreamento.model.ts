import { User } from "./user.model";
import { LocalAtendimento } from "./localAtendimento.model";
import { FatoresDeRisco } from "./fatoresDeRisco.model";
import { Lesao } from "./lesao.model";

export class Rastreamento {
    // passo1
    id: number;
    nomePaciente: string;
    nomeMae: string;
    bairro: string;
    cidade: string;
    dtNascimento: string;
    sexo: number = 0;
    cpf: string;
    email: string;

    // passo2
    localAtendimento: string;
    dataAtendimento: string;
    profissionalAtendimento: string;

    // passo3
    listFatoresRisco: Array<FatoresDeRisco> = new Array<FatoresDeRisco>();
    listPresencaLesao: Array<Lesao> = new Array<Lesao>();
    localReferencia: string;
    dataSugeridaRetorno: string;

    dtReferencia: string;
    dtcontraReferencia: string;
    histopatologico: File;
    dtConsulta: string;
    listPickerLocalAtendimento: Array<string> = new Array<string>();
    regiao: string;
}