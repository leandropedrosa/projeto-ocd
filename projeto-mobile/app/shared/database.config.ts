import {DatabaseService} from "~/shared/sqlite.service";

export class DatabaseConfig {

    constructor(private database: DatabaseService) {
        this.createDataBase();
        this.populateDataBaseTeste();
    }

    private createDataBase() {
        this.database.getdbConnection()
            .then(db => {

                db.execSQL("CREATE TABLE IF NOT EXISTS cidade (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);").then(() => {
                }, error => {
                    console.log("CREATE TABLE CIDADE ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS distrito (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_cidade INTEGER, FOREIGN KEY (id_cidade) REFERENCES cidade (id));").then(() => {
                }, error => {
                    console.log("CREATE TABLE DISTRITO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS bairro (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_cidade INTEGER, FOREIGN KEY (id_cidade) REFERENCES cidade (id));").then(() => {
                }, error => {
                    console.log("CREATE TABLE BAIRRO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS tipo_local_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);").then(() => {
                }, error => {
                    console.log("CREATE TABLE LOCAL_ATENDIMENTO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS local_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, id_distrito INTEGER, id_tipo_local_atendimento INTEGER, FOREIGN KEY (id_distrito) REFERENCES distrito (id), FOREIGN KEY (id_tipo_local_atendimento) REFERENCES tipo_local_atendimento (id));").then(() => {
                }, error => {
                    console.log("CREATE TABLE LOCAL_ATENDIMENTO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS fatores_risco (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").then(() => {
                }, error => {
                    console.log("CREATE TABLE FATORES_RISCO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS regioes_lesoes (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, caminho_imagem TEXT);").then(() => {
                }, error => {
                    console.log("CREATE TABLE REGIOES_LESOES ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_distrito_lesao INTEGER, FOREIGN KEY (id_distrito_lesao) REFERENCES regioes_lesoes (id));").then(() => {
                }, error => {
                    console.log("CREATE TABLE LESAO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS tipo_lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").then(() => {
                }, error => {
                    console.log("CREATE TABLE TIPO_LESAO ERROR", error);
                });

                db.execSQL("CREATE TABLE IF NOT EXISTS tipo_lesao_classificada (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_tipo_lesao INTEGER, FOREIGN KEY (id_tipo_lesao) REFERENCES tipo_lesao (id));").then(() => {
                }, error => {
                    console.log("CREATE TABLE TIPO_LESAO_CLASSIFICADA ERROR", error);
                });

                db.closedbConnection();
            }, error => {
                console.log("OPEN DB ERROR", error);
            });
    }

    private dropDataBase() {
        this.database.getdbConnection()
            .then(db => {

                db.execSQL("DROP TABLE tipo_lesao_classificada;").then(() => {
                }, error => {
                    console.log("DROP TABLE tipo_lesao_classificada ERROR", error);
                });

                db.execSQL("DROP TABLE tipo_lesao;").then(() => {
                }, error => {
                    console.log("DROP TABLE tipo_lesao ERROR", error);
                });

                db.execSQL("DROP TABLE lesao;").then(() => {
                }, error => {
                    console.log("DROP TABLE lesao ERROR", error);
                });

                db.execSQL("DROP TABLE regioes_lesoes;").then(() => {
                }, error => {
                    console.log("DROP TABLE regioes_lesoes ERROR", error);
                });

                db.execSQL("DROP TABLE fatores_risco;").then(() => {
                }, error => {
                    console.log("DROP TABLE fatores_risco ERROR", error);
                });

                db.execSQL("DROP TABLE local_atendimento;").then(() => {
                }, error => {
                    console.log("DROP TABLE local_atendimento ERROR", error);
                });

                db.execSQL("DROP TABLE bairro;").then(() => {
                }, error => {
                    console.log("DROP TABLE bairro ERROR", error);
                });

                db.execSQL("DROP TABLE distrito;").then(() => {
                }, error => {
                    console.log("DROP TABLE distrito ERROR", error);
                });

                db.execSQL("DROP TABLE cidade;").then(() => {
                }, error => {
                    console.log("DROP TABLE cidade ERROR", error);
                });

                db.closedbConnection();
            }, error => {
                console.log("OPEN DB ERROR", error);
            });
    }

    private populateDataBaseTeste() {
        this.database.getdbConnection()
            .then(db => {

                db.execSQL(this.scriptCidade()).then(() => {
                }, error => {
                    console.log("INSERT TABLE cidade", error);
                });

                db.execSQL(this.scriptDistrito()).then(() => {
                }, error => {
                    console.log("INSERT TABLE Distrito", error);
                });

                db.execSQL(this.scriptBairro()).then(() => {
                }, error => {
                    console.log("INSERT TABLE Bairro", error);
                });

                db.execSQL(this.scriptTipoLocalAtendimento()).then(() => {
                }, error => {
                    console.log("INSERT TABLE TipoLocalAtendimento", error);
                });

                db.execSQL(this.scriptLocalAtendimento()).then(() => {
                }, error => {
                    console.log("INSERT TABLE LocalAtendimento", error);
                });

                db.closedbConnection();
            }, error => {
                console.log("OPEN DB ERROR", error);
            });
    }

    private scriptCidade() {
        return "INSERT INTO cidade (nome) VALUES ( 'Goiânia' );";
    }

    private scriptDistrito() {
        return " INSERT INTO distrito ( nome, id_cidade ) VALUES ( 'Oeste', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO distrito ( nome, id_cidade ) VALUES ('Leste', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO distrito ( nome, id_cidade ) VALUES ('Sul', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO distrito ( nome, id_cidade ) VALUES ('Norte', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO distrito ( nome, id_cidade ) VALUES ('Central', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO distrito ( nome, id_cidade ) VALUES ('Noroeste', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO distrito ( nome, id_cidade ) VALUES ('Sudoeste', (select id from cidade where nome = 'Goiânia')); "
    }

    private scriptBairro() {
        return " INSERT INTO bairro (nome) VALUES ( 'ST. UNIVERSITÁRIO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('ST. AEROPORTO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR OESTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR BUENO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM AMÉRICA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR COIMBRA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR SUL', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA NOVA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('BAIRRO FLORESTA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('BAIRRO DA VITÓRIA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('FINSOCIAL', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. CURITIBA I', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. CURITIBA II', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. CURITIBA III', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA MUTIRÃO I', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. PRIMAVERA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('RECANTO DO BOSQUE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('NOVA ESPERANÇA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR AEROVIÁRIO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA ABAJÁ', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA IRANI', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CAMPINAS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. PETRÓPOLIS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('BAIRRO CAPUAVA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA SANTA HELENA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('BAIRRO SÃO FRANCISCO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR CENTRO OESTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CAMPINAS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR URIAS MAGALHÃES', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. BALNEÁRIO MEIA PONTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('ST. CRIMÉIA OESTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('MARECHAL RONDON', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. GUANABARA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. GUANABARA II', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CONJ. ITATIAIA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('NOVA VILA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA MONTECELLI', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR NORTE FERROVIÁRIO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM EUROPA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('NOVO HORIZONTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR SUDOESTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM VILA BOA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM PRESIDENTE', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM PLANALTO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('RIO FORMOSO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('ANDREIA CRISTINA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CHÁCARA DO GOVERNADOR', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PARQUE SANTA CRUZ', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM BELA VISTA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PARQUE ATHENEU', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA REDENÇÃO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PEDRO LUDOVICO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PARQUE AMAZÔNIA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JARDIM GOIÁS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR MARISTA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PARQUE DAS LARANJEIRAS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('BAIRRO N. SENHORA DE FÁTIMA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CIDADE JARDIM', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('SETOR RODOVIÁRIO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CONJ. MARQUES DE ABREU', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PARQUE IND. JOÃO BRAZ', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CONJ. VERA CRUZ I', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CONJ. VERA CRUZ II', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('PARQUE DOS BURITIS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA CANAÃ', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('BAIRRO GOIÁ I', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. NOVO MUNDO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA PEDROSO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('CONJ. RIVIERA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. LAGEADO', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. FERNANDO I', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. FERNANDO II', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('JD. DAS AROEIRAS', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA MORAES', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA SANTA ISABEL', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA MARIA LUIZA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('COLÔNIA SANTA MARTA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA OSVALDO ROSA', (select id from cidade where nome = 'Goiânia')); "
            + " INSERT INTO bairro (nome) VALUES ('VILA BANDEIRANTE', (select id from cidade where nome = 'Goiânia')); ";
    }

    private scriptTipoLocalAtendimento() {
        return " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'CAIS' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'CIAMS' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'UPA' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'CENTROS DE SAÚDE' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'CENTRO DE SAÚDE DA FAMÍLIA - CSF' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'UNIDADES DE ATENDIMENTO À SAÚDE MENTAL' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS' ); "
            + " INSERT INTO tipo_local_atendimento (nome) VALUES ( 'OUTRAS UNIDADES' ); "
    }

    private scriptLocalAtendimento() {
        return " INSERT INTO local_atendimento (nome, id_distrito, id_tipo_local_atendimento ) VALUES ( 'CAIS' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'CIAMS' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'UPA' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'CENTROS DE SAÚDE' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'CENTRO DE SAÚDE DA FAMÍLIA - CSF' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'UNIDADES DE ATENDIMENTO À SAÚDE MENTAL' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS' ); "
            + " INSERT INTO local_atendimento (nome) VALUES ( 'OUTRAS UNIDADES' ); "
    }
}