import {UsuarioModel} from "~/shared/model/usuario.model";
import {PacienteModel} from "~/shared/model/paciente.model";
import {TipoAtendimentoModel} from "~/shared/model/tipoAtendimento.model";
import {TipoLocalAtendimentoModel} from "~/shared/model/tipoLocalAtendimento.model";

export class AtendimentoModel {
    id: string;
    dataAtendimento: Date;
    descricao: string;
    usuario: UsuarioModel;
    paciente: PacienteModel;
    tipoAtendimento: TipoAtendimentoModel;
    tipoLocalAtendimento: TipoLocalAtendimentoModel;
}