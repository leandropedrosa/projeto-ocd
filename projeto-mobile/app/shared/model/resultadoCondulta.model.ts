import {TipoProcedimentoModel} from "~/shared/model/tipoProcedimento.model";
import {EncaminhamentoModel} from "~/shared/model/encaminhamento.model";

export class ResultadoCondultaModel {
    id: string;
    anexo: Blob;
    observacao: string;
    tipoProcedimento: TipoProcedimentoModel;
    encaminhamento: EncaminhamentoModel;
}