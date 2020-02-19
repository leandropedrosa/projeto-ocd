import {DistritoModel} from "~/shared/model/distrito.model";
import {TipoLocalAtendimentoModel} from "~/shared/model/tipoLocalAtendimento.model";

export class LocalAtendimentoModel {
    id: string;
    nome: string;
    distrito: DistritoModel;
    tipolocalAtendimento: TipoLocalAtendimentoModel;
}