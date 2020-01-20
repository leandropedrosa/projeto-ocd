package br.ufg.api.ocd.config.initialization;

import br.ufg.api.ocd.model.Bairro;
import br.ufg.api.ocd.model.Cidade;
import br.ufg.api.ocd.repository.BairroRepository;

public class BairroInicialization {

    private static BairroRepository bairroRepository;

    public static void criarBairros(BairroRepository repository, Cidade cidade) {
        bairroRepository = repository;
        repository.deleteAll();

        salvaBairro(Bairro.builder().nome("ANDREIA CRISTINA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("BAIRRO CAPUAVA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("BAIRRO DA VITÓRIA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("BAIRRO FLORESTA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("BAIRRO GOIÁ I").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("BAIRRO N. SENHORA DE FÁTIMA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("BAIRRO SÃO FRANCISCO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CAMPINAS").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CHÁCARA DO GOVERNADOR").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CIDADE JARDIM").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("COLÔNIA SANTA MARTA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CONJ. ITATIAIA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CONJ. MARQUES DE ABREU").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CONJ. RIVIERA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CONJ. VERA CRUZ I").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("CONJ. VERA CRUZ II").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("FINSOCIAL").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM AMÉRICA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM BELA VISTA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM EUROPA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM GOIÁS").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM PLANALTO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM PRESIDENTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JARDIM VILA BOA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. BALNEÁRIO MEIA PONTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. CURITIBA I").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. CURITIBA II").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. CURITIBA III").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. DAS AROEIRAS").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. FERNANDO I").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. FERNANDO II").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. GUANABARA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. GUANABARA II").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. LAGEADO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. NOVO MUNDO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. PETRÓPOLIS").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("JD. PRIMAVERA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("MARECHAL RONDON").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("NOVA ESPERANÇA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("NOVA VILA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("NOVO HORIZONTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PARQUE AMAZÔNIA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PARQUE ATHENEU").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PARQUE DAS LARANJEIRAS").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PARQUE DOS BURITIS").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PARQUE IND. JOÃO BRAZ").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PARQUE SANTA CRUZ").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("PEDRO LUDOVICO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("RECANTO DO BOSQUE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("RIO FORMOSO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR AEROVIÁRIO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR BUENO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR CENTRO OESTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR COIMBRA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR MARISTA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR NORTE FERROVIÁRIO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR OESTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR RODOVIÁRIO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR SUDOESTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR SUL").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("SETOR URIAS MAGALHÃES").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("ST. AEROPORTO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("ST. CRIMÉIA OESTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("ST. UNIVERSITÁRIO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA ABAJÁ").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA BANDEIRANTE").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA CANAÃ").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA IRANI").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA MARIA LUIZA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA MONTECELLI").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA MORAES").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA MUTIRÃO I").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA NOVA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA OSVALDO ROSA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA PEDROSO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA REDENÇÃO").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA SANTA HELENA").cidade(cidade).build());
        salvaBairro(Bairro.builder().nome("VILA SANTA ISABEL").cidade(cidade).build());

    }


    private static void salvaBairro(Bairro bairro) {
        bairroRepository.save(bairro);
    }
}
