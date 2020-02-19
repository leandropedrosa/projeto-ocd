import {TipoAtencaoModel} from "~/shared/model/tipoAtencao.model";
import {LocalAtendimentoModel} from "~/shared/model/localAtendimento.model";

export class UsuarioModel {
    id: string;
    cpf: string;
    nome: string;
    senha: string;
    status: string;
    email: string;
    telefone: string;
    tipoAtencao: TipoAtencaoModel;
    localAtendimento: LocalAtendimentoModel;
}