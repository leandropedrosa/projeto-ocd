import {LocalAtendimentoModel} from "~/shared/model/localAtendimento.model";
import {AtendimentoModel} from "~/shared/model/atendimento.model";

export class EncaminhamentoModel {
    id: string;
    dataEncaminhamento: Date;
    orientacao: string;
    localAtendimento: LocalAtendimentoModel;
    atendimento: AtendimentoModel;
}