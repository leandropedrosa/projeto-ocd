import {LesaoModel} from "~/shared/model/lesao.model";
import {RegiaoBocaModel} from "~/shared/model/regiaoBoca.model";
import {AvaliacaoClinicaModel} from "~/shared/model/avaliacaoClinica.model";

export class LocalLesaoModel {
    id: string;
    lesao: LesaoModel;
    regiaoBoca: RegiaoBocaModel;
    avaliacaoClinica: AvaliacaoClinicaModel;

}