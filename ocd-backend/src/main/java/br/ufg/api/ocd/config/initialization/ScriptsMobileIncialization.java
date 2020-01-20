package br.ufg.api.ocd.config.initialization;

import br.ufg.api.ocd.model.ScriptsMobile;
import br.ufg.api.ocd.model.VersaoBanco;
import br.ufg.api.ocd.repository.ScriptsMobileRepository;

public class ScriptsMobileIncialization {
    private static ScriptsMobileRepository scriptsRepository;

    public static void criarScriptsIniciaisMobile(ScriptsMobileRepository repository, VersaoBanco versaoBanco) {
        scriptsRepository = repository;
        repository.deleteAll();
        salvaVersaoBanco(ScriptsMobile.builder().tabela("CIDADE").script("CREATE TABLE IF NOT EXISTS cidade (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("BAIRRO").script("CREATE TABLE IF NOT EXISTS bairro (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_cidade INTEGER, FOREIGN KEY (id_cidade) REFERENCES cidade (id));").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("DISTRITO").script("CREATE TABLE IF NOT EXISTS distrito (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_cidade INTEGER, id_bairro INTEGER, FOREIGN KEY (id_cidade) REFERENCES cidade (id),  FOREIGN KEY (id_bairro) REFERENCES bairro (id));").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("TIPO_LOCAL_ATENDIMENTO").script("CREATE TABLE IF NOT EXISTS tipo_local_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("LOCAL ATENDIMENTO").script("CREATE TABLE IF NOT EXISTS local_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, id_distrito INTEGER, id_tipo_local_atendimento INTEGER, FOREIGN KEY (id_distrito) REFERENCES distrito (id), FOREIGN KEY (id_tipo_local_atendimento) REFERENCES tipo_local_atendimento (id));").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("TIPO_ATENCAO").script("CREATE TABLE IF NOT EXISTS tipo_atencao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("USUARIO").script("CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, cpf INTEGER, nome TEXT, senha TEXT, status TEXT, email TEXT, telefone TEXT, id_tipo_atencao INTEGER, id_local_atendimento INTEGER, FOREIGN KEY (id) REFERENCES tipo_atencao, FOREIGN KEY (id) REFERENCES local_atendimento);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("TIPO_ATENDIMENTO").script("CREATE TABLE NOT IF EXISTS tipo_atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("PACIENTE").script("CREATE TABLE IF NOT EXISTS paciente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, data_nascimento DATE, sexo TEXT UNIQUE, email TEXT, telefone_celular TEXT, nome_da_mae TEXT, telefone_responsavel TEXT, id_bairro INTEGER, FOREIGN KEY (id) REFERENCES bairro);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("ATENDIMENTO").script("CREATE TABLE IF NOT EXISTS atendimento (id INTEGER PRIMARY KEY AUTOINCREMENT, data_atendimento DATE, descrição TEXT, id_usuario INTEGER,  id_paciente INTEGER,  id_tipo_atendimento INTEGER, id_local_atendimento INTEGER, FOREIGN KEY (id) REFERENCES usuario, FOREIGN KEY (id) REFERENCES paciente, FOREIGN KEY (id) REFERENCES  tipo_atendimento, FOREIGN KEY (id) REFERENCES local_atendimento);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("FATOR_RISCO").script("CREATE TABLE IF NOT EXISTS fator_risco (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("AVALIACAO_CLINICA").script("CREATE TABLE IF NOT EXISTS avaliacao_clinica (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario_sera_encaminhado BOOLEAN,  id_atendimento INTEGER, FOREIGN KEY (id) REFERENCES atendimento);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("FATOR_RISCO_AVALIACAO_CLINICA").script("CREATE TABLE IF NOT EXISTS fator_risco_avaliacao_clinica (id INTEGER PRIMARY KEY AUTOINCREMENT, id_fator_risco INTEGER, id_avaliacao_clinica INTEGER, FOREIGN KEY (id) REFERENCES fator_risco, FOREIGN KEY (id) REFERENCES avaliacao_clinica);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("TIPO_REGIAO").script("CREATE TABLE IF NOT EXISTS tipo_regiao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, caminho_imagem TEXT);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("REGIAO_BOCA").script("CREATE TABLE IF NOT EXISTS regiao_boca (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_tipo_regiao INTEGER, FOREIGN KEY (id) REFERENCES tipo_regiao (id));").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("TIPO_LESAO").script("CREATE TABLE IF NOT EXISTS tipo_lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("LESAO").script("CREATE TABLE IF NOT EXISTS lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE, id_tipo_lesao INTEGER, FOREIGN KEY (id) REFERENCES tipo_lesao (id));").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("LOCAL_DA_LESAO").script("CREATE TABLE IF NOT EXISTS local_da_lesao (id INTEGER PRIMARY KEY AUTOINCREMENT, id_lesao INTEGER,  id_regiao_boca INTEGER,  id_avaliacao_clinica INTEGER, FOREIGN KEY (id) REFERENCES lesao, FOREIGN KEY (id) REFERENCES regiao_boca, FOREIGN KEY (id) REFERENCES  avaliacao_clinica);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("DIAGNOSTICO").script("CREATE TABLE IF NOT EXISTS diagnostico (id INTEGER PRIMARY KEY AUTOINCREMENT, hipotese_diagnostico TEXT, confirma_rastreamento BOOLEAN, observacao TEXT, id_atendimento INTEGER, FOREIGN KEY (id) REFERENCES atendimento);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("ENCAMINHAMENTO").script("CREATE TABLE IF NOT EXISTS encaminhamento (id INTEGER PRIMARY KEY AUTOINCREMENT, data_encaminhamento DATE, orientação TEXT, id_local_atendimento INTEGER, id_atendimento INTEGER, FOREIGN KEY (id) REFERENCES local_atendimento, FOREIGN KEY (id) REFERENCES atendimento);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("TIPO_DE_PROCEDIMENTO").script("CREATE TABLE IF NOT EXISTS tipo_de_procedimento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT UNIQUE);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("RESULTADO_DA_CONDUTA").script("CREATE TABLE IF NOT EXISTS resultado_da_conduta (id INTEGER PRIMARY KEY AUTOINCREMENT, anexo BLOB, observacao TEXT, id_tipo_de_procedimento INTEGER, id_encaminhamento INTEGER, FOREIGN KEY (id) REFERENCES tipo_de_procedimento, FOREIGN KEY (id) REFERENCES encaminhamento);").versaoBanco(versaoBanco).build());
        salvaVersaoBanco(ScriptsMobile.builder().tabela("VERSAO_BANCO").script("CREATE TABLE IF NOT EXISTS versao_banco (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, data DATE);").versaoBanco(versaoBanco).build());
    }

    private static void salvaVersaoBanco(ScriptsMobile scriptsMobile) {
        scriptsRepository.save(scriptsMobile);
    }
}
