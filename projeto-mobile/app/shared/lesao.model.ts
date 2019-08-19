import { TipoLesao } from "./tipoLesao.model";
export class Lesao {
    constructor(id: number, nome: string, tipo: TipoLesao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
    id: number;
    nome: string;
    tipo: TipoLesao;
}