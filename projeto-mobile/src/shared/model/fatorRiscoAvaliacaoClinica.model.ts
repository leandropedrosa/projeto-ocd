import {FatorRiscoModel} from "~/shared/model/fatorRisco.model";
import {AvaliacaoClinicaModel} from "~/shared/model/avaliacaoClinica.model";

export class FatorRiscoAvaliacaoClinicaModel {
    id: string;
    fatorRisco: FatorRiscoModel;
    avaliacaoClinica: AvaliacaoClinicaModel;
}