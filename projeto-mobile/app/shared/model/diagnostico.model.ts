import {AtendimentoModel} from "~/shared/model/atendimento.model";

export class DiagnosticoModel {
    id: string;
    hipoteseDiagnostico: string;
    confirmaRastreamento: boolean;
    observacao: string;
    atendimento: AtendimentoModel;
}