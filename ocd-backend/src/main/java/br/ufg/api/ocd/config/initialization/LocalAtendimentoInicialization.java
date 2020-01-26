package br.ufg.api.ocd.config.initialization;

import br.ufg.api.ocd.model.Distrito;
import br.ufg.api.ocd.model.LocalAtendimento;
import br.ufg.api.ocd.model.TipoLocalAtendimento;
import br.ufg.api.ocd.repository.DistritoRepository;
import br.ufg.api.ocd.repository.LocalAtendimentoRepository;
import br.ufg.api.ocd.repository.TipoLocalAtendimentoRepository;

import java.util.List;

public class LocalAtendimentoInicialization {

    private static LocalAtendimentoRepository localAtendimentoRepository;
    private static DistritoRepository distritoRepository;
    private static TipoLocalAtendimentoRepository tipoLocalAtendimentoRepository;
    private static List<Distrito> distritos;
    private static List<TipoLocalAtendimento> tipos;

    public static void criaLocalAtendimento(LocalAtendimentoRepository repository, DistritoRepository dRepository, TipoLocalAtendimentoRepository tRepository) {
        localAtendimentoRepository = repository;
        distritoRepository = dRepository;
        tipoLocalAtendimentoRepository = tRepository;
        repository.deleteAll();

        salvaLocalAtendimento(LocalAtendimento.builder().nome("Amendoeiras").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Bairro Goiá").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Campinas").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Cândida De Morais").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Chácara Do Governador").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Deputado João Natal").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Finsocial").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Guanabara III").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Novo Mundo").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CAIS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim América").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CIAMS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Novo Horizonte").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CIAMS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Pedro Ludovico").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CIAMS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Urias Magalhães").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CIAMS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("João Batista De Sousa Júnior - Upa Itaipu").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UPA")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Maria Pires Perillo - Upa Noroeste").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UPA")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Benedito Dos Santos Vieira Setor Perim").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Cidade Jardim (Antigo Rodoviário) - Michele Muniz Do Carmo").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Conjunto Riviera").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Dr. Afonso H. Da S. E Souza Vila Água Branca").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Esplanada Do Anicuns").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Fama").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Hortência Mendonça - Vila Redenção").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Isabel Maria Da Silva - Vila Maria Dilce").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Vila Boa").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jd. Balneário M. Ponte").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("José Do Egídio Martins - Vila União").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Marinho Lemos – Negrão De Lima").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Norte Ferroviário").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Amazônia").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Anhanguera").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Ind. João Braz").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Setor Criméia Leste").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Canaã").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Clemente").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Mauá").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Moraes").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Santa Helena").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTROS DE SAÚDE")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Andréia Cristina").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Antonio Carlos Pires").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Aruanã III").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Bairro Da Vitória II").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Bairro Goiá").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Bairro São Francisco").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Barravento").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Boa Vista / Floresta").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Buena Vista").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Cachoeira Dourada").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Campus Samambaia").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Condomínio Das Esmeraldas").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Condomínio Morada Do Sol").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Conjunto Itatiaia").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vera Cruz I").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vera Cruz II").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Criméia Oeste").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Distrito De Vila Rica").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Dom Fernando II").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Estrela Dalva").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Garavelo B").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Grajaú").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Aroeira").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Caravelas").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Colorado").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Curitiba I e II").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Curitiba III").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Guanabara I").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Mariliza").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Mirabel").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Novo Planalto").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Primavera").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Jardim Aritana").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Leste Universitário").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Madre Germana II").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Núcleo De Apoio A Saúde Da Familia - Nasf Curitiba I").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Atheneu I").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Dos Buritis").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Eldorado Oeste").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Santa Rita").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Parque Tremendão").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Real Conquista").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Militão Rodrigues (Antigo Recanto Das Minas Gerais)").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Brisa Da Mata").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Ana Clara").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Eli Forte").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Goiânia Viva").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Itaipu").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Jardim Do Cerrado").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Jardim Do Cerrado Vi").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Vale Dos Sonhos").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Ville De France").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencial Ytapuã").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("São Carlos").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Setor Luana Park").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Setor Recanto Do Bosque").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Setor São Judas Tadeu").distrito(retornaDistrito("Norte")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Setor Santo Hilário").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Mutirão").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vf-18 - Finsocial").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Pedroso").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vila Regina").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CENTRO DE SAÚDE DA FAMÍLIA - CSF")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Ambulatório Municipal De Psiquiatria").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial – Caps Noroeste/Jardim Liberdade").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial - Caps Beija-Flor").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial - Caps Esperança").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial - Caps Girassol").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial - Caps Novo Mundo").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial - Caps Vida").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial - Caps – Ad/Casa").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial Infanto-Juvenil – Caps Água Viva").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Atenção Psicossocial Infanto Juvenil - Caps Negrão De Lima").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Convivencia Cuca Fresca").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Pronto Socorro Psiquiátrico Wassily Chuc").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residência Terapêutica Beija-Flor I").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residência Terapêutica Beija-Flor II (Unidade Feminina)").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residência Terapêutica Mendanha I (Unidade Feminina)").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residência Terapêutica Mendanha II (Unidade Masculina)").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residência Terapêutica Novo Mundo I").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Residencia Terapeutica Novo Mundo II").distrito(retornaDistrito("Leste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Associação De Trab. E Prod. Solidária Em Saúde Mental - Gerarte I").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Unidade De Trab. E Prod. Solidária Da Saúde Mental - Gerarte II").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Comercialização De Economia Solidária - Loja Arte E Saúde").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("UNIDADES DE ATENDIMENTO À SAÚDE MENTAL")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Referencia - Crdt").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Cais Jardim Novo Mundo").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Cais Cândida De Moraes").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Ciams Novo Horizonte").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Ambulatório Municipal De Queimaduras").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vigilancia Em Saude Do Trabalhador").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Referência Em Ortopedia E Fisioterapia Crof").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro De Referência Em Atenção À Saúde Da Pessoa Idosa - Craspi").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Crdt -Cândido J. S. De Moura").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Vigilância Em Zoonoses").distrito(retornaDistrito("Sudoeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Farmácia De Insumos E Medicamentos Especiais").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Farmacia Distrital Central").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Farmacia Distrital Oeste").distrito(retornaDistrito("Oeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Farmacia Popular / Faculdade De Farmacia Da Universidade Federal De Goiás - Ufg").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Farmacia Popular Do Brasil").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Hospital Da Mulher E Maternidade Dona Iris").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Maternidade Nascer Cidadão").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Ouvidoria Da Saúde").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Serviço De Ver. De Óbitos - Svo").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Serviço Esp. Em Eng. De Segurança E Em Medicina Do Trabalho – Sesmt").distrito(retornaDistrito("Noroeste")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Consultorio De Rua").distrito(retornaDistrito("Central")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
        salvaLocalAtendimento(LocalAtendimento.builder().nome("Centro Municipal De Vacinação").distrito(retornaDistrito("Sul")).tipoLocalAtendimento(retornaTipoLocalAtendimento("OUTRAS UNIDADES")).build());
    }

    private static void salvaLocalAtendimento(LocalAtendimento localAtendimento) {
        localAtendimentoRepository.save(localAtendimento);
    }

    private static Distrito retornaDistrito(String nome) {
        if (distritos == null) {
            distritos = distritoRepository.findAll();
        }
        for (Distrito item : distritos) {
            if (item.getNome().equals(nome)) return item;
        }
        return null;
    }

    private static TipoLocalAtendimento retornaTipoLocalAtendimento(String nome) {
        if (tipos == null) {
            tipos = tipoLocalAtendimentoRepository.findAll();
        }
        for (TipoLocalAtendimento item : tipos) {
            if (item.getNome().equals(nome)) return item;
        }
        return null;
    }
}
