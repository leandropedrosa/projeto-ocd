export class FatoresDeVunerabilidade {
    constructor(id: number, nome: string, idTipoCancer: Number) {
        this.id = id;
        this.nome = nome;
        this.idTipoCancer = idTipoCancer;
    }
    id: number;
    nome: string;
    idTipoCancer: Number;
}