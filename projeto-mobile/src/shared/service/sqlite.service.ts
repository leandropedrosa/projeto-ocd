import {Injectable} from "@angular/core";
import {ScriptsMobileModel} from "~/shared/model/scriptsMobile.model";
import {environment} from "../../environments/environment";

var Sqlite = require("nativescript-sqlite");

@Injectable()
export class DatabaseService {

    private static getdbConnection() {

        if (Sqlite === null) {
            Sqlite = new Sqlite(environment.DB_NAME);
        }
        return Sqlite
    }

    private static closedbConnection() {
        new Sqlite(environment.DB_NAME)
            .then((db) => {
                db.close();
            });
    }

    public static executeScript(scripts: Array<ScriptsMobileModel>) {
        this.getdbConnection()
            .then(db => {
                for (let i = 0; i < scripts.length; i++) {
                    db.execSQL(scripts[i].script).then(() => {
                    }, error => {
                        console.log("ERROR SCRIPT TABLE " + scripts[i].tabela + " ERROR", error);
                    });
                }
                db.closedbConnection();
            }, error => {
                console.log("OPEN DB ERROR", error);
                this.closedbConnection();
            });
    }

    public static getVersaoDoBanco() {
        this.getdbConnection()
            .then(db => {
                    db.execSQL("SELECT * FROM versao_banco");
                }, error => {
                    console.log("ERROR SCRIPT TABLE VERSAO_BANCO ERROR", error);
                }
            ), error => {
            console.log("OPEN DB ERROR", error);
            this.closedbConnection();
        }
    }

    public static criarTabelasIniciais(){
        let scripts: Array<ScriptsMobileModel> = new Array<ScriptsMobileModel>();
        scripts.push(new ScriptsMobileModel("CIDADE", "CREATE TABLE IF NOT EXISTS cidade (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);", "1.0"));
        scripts.push(new ScriptsMobileModel("BAIRRO", "CREATE TABLE IF NOT EXISTS bairro (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_cidade INTEGER, FOREIGN KEY (id_cidade) REFERENCES cidade (id));", "1.0"));
        scripts.push(new ScriptsMobileModel("DISTRITO", "CREATE TABLE IF NOT EXISTS distrito (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_cidade INTEGER, id_bairro INTEGER, FOREIGN KEY (id_cidade) REFERENCES cidade (id),  FOREIGN KEY (id_bairro) REFERENCES bairro (id));", "1.0"));
        scripts.push(new ScriptsMobileModel("TIPO_LOCAL_ATENDIMENTO", "CREATE TABLE IF NOT EXISTS tipo_local_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);", "1.0"));
        scripts.push(new ScriptsMobileModel("LOCAL ATENDIMENTO", "CREATE TABLE IF NOT EXISTS local_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, id_distrito INTEGER, id_tipo_local_atendimento INTEGER, FOREIGN KEY (id_distrito) REFERENCES distrito (id), FOREIGN KEY (id_tipo_local_atendimento) REFERENCES tipo_local_atendimento (id));", "1.0"));
        scripts.push(new ScriptsMobileModel("TIPO_ATENCAO", "CREATE TABLE IF NOT EXISTS tipo_atencao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);", "1.0"));
        scripts.push(new ScriptsMobileModel("USUARIO", "CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, cpf INTEGER, nome TEXT, senha TEXT, status TEXT, email TEXT, telefone TEXT, id_tipo_atencao INTEGER, id_local_atendimento INTEGER, FOREIGN KEY (id) REFERENCES tipo_atencao, FOREIGN KEY (id) REFERENCES local_atendimento);", "1.0"));
        scripts.push(new ScriptsMobileModel("TIPO_ATENDIMENTO", "CREATE TABLE NOT IF EXISTS tipo_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);", "1.0"));
        scripts.push(new ScriptsMobileModel("PACIENTE", "CREATE TABLE IF NOT EXISTS paciente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, data_nascimento DATE, sexo TEXT UNIQUE, email TEXT, telefone_celular TEXT, nome_da_mae TEXT, telefone_responsavel TEXT, id_bairro INTEGER, FOREIGN KEY (id) REFERENCES bairro);", "1.0"));
        scripts.push(new ScriptsMobileModel("ATENDIMENTO", "CREATE TABLE IF NOT EXISTS atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, data_atendimento DATE, descrição TEXT, id_usuario INTEGER,  id_paciente INTEGER,  id_tipo_atendimento INTEGER, id_local_atendimento INTEGER, FOREIGN KEY (id) REFERENCES usuario, FOREIGN KEY (id) REFERENCES paciente, FOREIGN KEY (id) REFERENCES  tipo_atendimento, FOREIGN KEY (id) REFERENCES local_atendimento);", "1.0"));
        scripts.push(new ScriptsMobileModel("FATOR_RISCO", "CREATE TABLE IF NOT EXISTS fator_risco (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);", "1.0"));
        scripts.push(new ScriptsMobileModel("AVALIACAO_CLINICA", "CREATE TABLE IF NOT EXISTS avaliacao_clinica (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario_sera_encaminhado BOOLEAN,  id_atendimento INTEGER, FOREIGN KEY (id) REFERENCES atendimento);", "1.0"));
        scripts.push(new ScriptsMobileModel("FATOR_RISCO_AVALIACAO_CLINICA", "CREATE TABLE IF NOT EXISTS fator_risco_avaliacao_clinica (id INTEGER PRIMARY KEY AUTOINCREMENT, id_fator_risco INTEGER, id_avaliacao_clinica INTEGER, FOREIGN KEY (id) REFERENCES fator_risco, FOREIGN KEY (id) REFERENCES avaliacao_clinica);", "1.0"));
        scripts.push(new ScriptsMobileModel("TIPO_REGIAO", "CREATE TABLE IF NOT EXISTS tipo_regiao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, caminho_imagem TEXT);", "1.0"));
        scripts.push(new ScriptsMobileModel("REGIAO_BOCA", "CREATE TABLE IF NOT EXISTS regiao_boca (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_tipo_regiao INTEGER, FOREIGN KEY (id) REFERENCES tipo_regiao (id));", "1.0"));
        scripts.push(new ScriptsMobileModel("TIPO_LESAO", "CREATE TABLE IF NOT EXISTS tipo_lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);\"", "1.0"));
        scripts.push(new ScriptsMobileModel("LESAO", "CREATE TABLE IF NOT EXISTS lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_tipo_lesao INTEGER, FOREIGN KEY (id) REFERENCES tipo_lesao (id));", "1.0"));
        scripts.push(new ScriptsMobileModel("LOCAL_DA_LESAO", "CREATE TABLE IF NOT EXISTS local_da_lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, id_lesao INTEGER,  id_regiao_boca INTEGER,  id_avaliacao_clinica INTEGER, FOREIGN KEY (id) REFERENCES lesao, FOREIGN KEY (id) REFERENCES regiao_boca, FOREIGN KEY (id) REFERENCES  avaliacao_clinica);", "1.0"));
        scripts.push(new ScriptsMobileModel("DIAGNOSTICO", "CREATE TABLE IF NOT EXISTS diagnostico (id INTEGER PRIMARY KEY AUTOINCREMENT, hipotese_diagnostico TEXT, confirma_rastreamento BOOLEAN, observacao TEXT, id_atendimento INTEGER, FOREIGN KEY (id) REFERENCES atendimento);", "1.0"));
        scripts.push(new ScriptsMobileModel("ENCAMINHAMENTO", "CREATE TABLE IF NOT EXISTS encaminhamento (id INTEGER PRIMARY KEY AUTOINCREMENT, data_encaminhamento DATE, orientação TEXT, id_local_atendimento INTEGER, id_atendimento INTEGER, FOREIGN KEY (id) REFERENCES local_atendimento, FOREIGN KEY (id) REFERENCES atendimento);", "1.0"));
        scripts.push(new ScriptsMobileModel("TIPO_DE_PROCEDIMENTO", "CREATE TABLE IF NOT EXISTS tipo_de_procedimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);", "1.0"));
        scripts.push(new ScriptsMobileModel("RESULTADO_DA_CONDUTA", "CREATE TABLE IF NOT EXISTS resultado_da_conduta (id INTEGER PRIMARY KEY AUTOINCREMENT, anexo BLOB, observacao TEXT, id_tipo_de_procedimento INTEGER, id_encaminhamento INTEGER, FOREIGN KEY (id) REFERENCES tipo_de_procedimento, FOREIGN KEY (id) REFERENCES encaminhamento);", "1.0"));
        scripts.push(new ScriptsMobileModel("VERSAO_BANCO", "CREATE TABLE IF NOT EXISTS versao_banco (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, data DATE);", "1.0"));

        this.executeScript(scripts);
    }
}
