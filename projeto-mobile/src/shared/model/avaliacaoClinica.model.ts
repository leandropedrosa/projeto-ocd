import {AtendimentoModel} from "~/shared/model/atendimento.model";

export class AvaliacaoClinicaModel {
    id: string;
    usuarioEncaminhado: boolean;
    atendimento: AtendimentoModel;
}