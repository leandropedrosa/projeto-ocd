import { FatoresDeVunerabilidade } from "./fatoresVunerabilidade.model";
export class TipoCancer {
    id: number;
    nome: string;
    listaDeFatores: Array<FatoresDeVunerabilidade>;
}