export class ScriptsMobileModel {
    constructor(tabela: string, script: string, versaoBanco: string) {
        this.tabela = tabela;
        this.script = script;
        this.versaoBanco = versaoBanco;
    }

    id: string
    tipo: string;
    tabela: string;
    script: string;
    versaoBanco: string;
}