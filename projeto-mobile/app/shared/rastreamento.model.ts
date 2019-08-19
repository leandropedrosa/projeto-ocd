import { User } from "./user.model";
import { LocalAtendimento } from "./localAtendimento.model";
import { TipoCancer } from "./tipoCancer.model";
import { FatoresDeVunerabilidade } from "./fatoresVunerabilidade.model";
import { TipoLesao } from "./tipoLesao.model";

export class Rastreamento {
    id: number;
    nomePaciente: string;
    dtNascimento: string;
    sexo: number = 0;
    nomeMae: string;
    cpf: string;
    numCartaoSus: string;
    numTelefone: string;
    email: string;
    localAtendimento: LocalAtendimento;
    dtReferencia: string;
    dtcontraReferencia: string;
    tipoCancer: TipoCancer;
    fatoresDeVunerabilidade: Array<FatoresDeVunerabilidade>;
    tipoLesao: Array<TipoLesao>;
    histopatologico: File;
    usuario: User;
    dtRetornoSugerido: string;
    dtRetorno: string;
    dtConsulta: string;
    user: User;
}