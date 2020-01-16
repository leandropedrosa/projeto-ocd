package br.ufg.api.ocd.config.initialization;


import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import br.ufg.api.ocd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("dev")
@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    TipoAtencaoRepository tipoAtencaoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    BairroRepository bairroRepository;

    @Autowired
    DistritoRepository distritoRepository;

    @Autowired
    TipoLocalAtendimentoRepository tipoLocalAtendimentoRepository;

    @Autowired
    LocalAtendimentoRepository localAtendimentoRepository;

    @Autowired
    TipoAtendimentoRepository tipoAtendimentoRepository;

    @Autowired
    FatorRiscoRepository fatorRiscoRepository;

    @Autowired
    TipoRegiaoRepository tipoRegiaoRepository;

    @Autowired
    RegiaoBocaRepository regiaoBocaRepository;

    @Autowired
    TipoLesaoRepository tipoLesaoRepository;

    @Autowired
    LesaoRepository lesaoRepository;

    @Autowired
    TipoDeProcedimentoRepository tipoDeProcedimentoRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;


    private List<Distrito> distritos;
    private List<TipoLocalAtendimento> tipos;
    List<TipoRegiao> tipoRegioes;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        criarTipoAtencao();
        criarCidade();
        criarBairro();
        criarDistrito();
        criarTipoLocalAtendimento();
        criarLocalAtendimento();
        criarTipoAtendimento();
        criarFatorRisco();
        criarTipoRegiao();
        criarRegiaoBoca();
        criarTipoLesao();
        criarLesao();
        criarTipoProcedimento();

        // criarRole();
        criarUsuario();
        //System.out.println("CRIPTO "+passwordEncoder.encode("p@55w0Rd")+" CRIPTO");
    }

    private void criarTipoAtencao() {
        tipoAtencaoRepository.deleteAll();
        salvaTipoAtencao(TipoAtencao.builder().nome("Atenção Primária").build());
        salvaTipoAtencao(TipoAtencao.builder().nome("Atenção Secundária").build());
    }

    private void criarCidade() {
        cidadeRepository.deleteAll();
        salvaCidade(Cidade.builder().nome("Goiânia").build());
    }

    private void criarBairro() {
        bairroRepository.deleteAll();
        List<Cidade> lista = cidadeRepository.findByNome("Goiânia");
        Cidade cidade = lista.get(0);

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

    private void criarDistrito() {
        distritoRepository.deleteAll();

        List<Bairro> lista = bairroRepository.findAll();

        for (Bairro item : lista) {
            if (item.getNome().equals("BAIRRO GOIÁ I"))
                salvaDistrito(Distrito.builder().nome("Oeste").bairro(item).build());
            if (item.getNome().equals("JD. NOVO MUNDO"))
                salvaDistrito(Distrito.builder().nome("Leste").bairro(item).build());
            if (item.getNome().equals("JARDIM AMÉRICA"))
                salvaDistrito(Distrito.builder().nome("Sul").bairro(item).build());
            if (item.getNome().equals("JD. GUANABARA"))
                salvaDistrito(Distrito.builder().nome("Norte").bairro(item).build());
            if (item.getNome().equals("SETOR NORTE FERROVIÁRIO"))
                salvaDistrito(Distrito.builder().nome("Central").bairro(item).build());
            if (item.getNome().equals("VILA MUTIRÃO I"))
                salvaDistrito(Distrito.builder().nome("Noroeste").bairro(item).build());
            if (item.getNome().equals("SETOR SUDOESTE"))
                salvaDistrito(Distrito.builder().nome("Sudoeste").bairro(item).build());
        }

    }

    private void criarTipoLocalAtendimento() {
        tipoLocalAtendimentoRepository.deleteAll();
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CAIS").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CIAMS").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("UPA").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CENTROS DE SAÚDE").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CENTROS DE SAÚDE DA FAMÍLIA - CSF").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("UNIDADE DE ATENDIMENTO A SAÚDE").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS").build());
        salvaTipoLocalAtendimento(TipoLocalAtendimento.builder().nome("OUTRAS UNIDADES").build());
    }


    private void criarLocalAtendimento() {
        localAtendimentoRepository.deleteAll();

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

    private void criarTipoAtendimento() {
        tipoAtencaoRepository.deleteAll();
        salvaTipoAtendimento(TipoAtendimento.builder().nome("Intervenção").build());
        salvaTipoAtendimento(TipoAtendimento.builder().nome("Acompanhamento").build());
        salvaTipoAtendimento(TipoAtendimento.builder().nome("Resultado").build());
    }

    private void criarFatorRisco() {
        fatorRiscoRepository.deleteAll();
        salvaFatorRisco(FatorRisco.builder().nome("Idade").build());
        salvaFatorRisco(FatorRisco.builder().nome("Sol").build());
        salvaFatorRisco(FatorRisco.builder().nome("Fumante").build());
        salvaFatorRisco(FatorRisco.builder().nome("Álcool").build());
        salvaFatorRisco(FatorRisco.builder().nome("História da doença secundária").build());

    }

    private void criarTipoRegiao() {
        tipoRegiaoRepository.deleteAll();
        salvarTipoRegiao(TipoRegiao.builder().nome("Região A").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região B").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região C").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região D").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região E").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região F").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região G").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região H").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região I").caminhoImagem("caminho da imagem").build());
        salvarTipoRegiao(TipoRegiao.builder().nome("Região J").caminhoImagem("caminho da imagem").build());

    }

    private void criarRegiaoBoca() {
        regiaoBocaRepository.deleteAll();
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Comissura labial esquerda").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Comissura labial direita").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Lábio inferior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Lábio inferior (lado direito)").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Lábio inferior (região de linha média)").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Lábio superior (lado esquerdo").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Lábio superior (lado direito)").tipoRegiao(retornaTipoRegiao("Região A")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Lábio superior (região de linha média)").tipoRegiao(retornaTipoRegiao("Região A")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa labial superior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região B")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa labial superior (lado direito)").tipoRegiao(retornaTipoRegiao("Região B")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa labial superior (região de linha média").tipoRegiao(retornaTipoRegiao("Região B")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Fundo de vestíbulo superior anterior").tipoRegiao(retornaTipoRegiao("Região B")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Freio labial superior").tipoRegiao(retornaTipoRegiao("Região B")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa labial inferior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região C")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa labial inferior (lado direito)").tipoRegiao(retornaTipoRegiao("Região C")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa labial inferior (região de linha média)").tipoRegiao(retornaTipoRegiao("Região C")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Fundo de vestíbulo inferior anterior").tipoRegiao(retornaTipoRegiao("Região C")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Freio labial inferior").tipoRegiao(retornaTipoRegiao("Região C")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa jugal esquerda (posterior)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa jugal esquerda (média)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa jugal esquerda (anterior)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa jugal direita (posterior)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa jugal direita (média)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Mucosa jugal direita (anterior)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Fundo de vestíbulo inferior posterior (lado direito)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Fundo de vestíbulo inferior posterior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Fundo de vestíbulo superior posterior (lado direito)").tipoRegiao(retornaTipoRegiao("Região D")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Fundo de vestíbulo superior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região D")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("?????").tipoRegiao(retornaTipoRegiao("Região E")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Palato duro").tipoRegiao(retornaTipoRegiao("Região F")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Palato mole").tipoRegiao(retornaTipoRegiao("Região F")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Borda lateral direita da língua (posterior)").tipoRegiao(retornaTipoRegiao("Região G")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Borda lateral direita da língua (média)").tipoRegiao(retornaTipoRegiao("Região G")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Borda lateral direita da língua (anterior)").tipoRegiao(retornaTipoRegiao("Região G")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Borda lateral esquerda da língua (posterior)").tipoRegiao(retornaTipoRegiao("Região H")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Borda lateral esquerda da língua (média)").tipoRegiao(retornaTipoRegiao("Região H")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Borda lateral esquerda da língua (anterior)").tipoRegiao(retornaTipoRegiao("Região H")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Assoalho bucal (lado direito)").tipoRegiao(retornaTipoRegiao("Região I")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Assoalho bucal (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região I")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Assoalho bucal (região de linha média)").tipoRegiao(retornaTipoRegiao("Região I")).build());

        salvarRegiaoBoca(RegiaoBoca.builder().nome("Gengiva superior anterior").tipoRegiao(retornaTipoRegiao("Região J")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Gengiva superior posterior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região J")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Gengiva superior posterior (lado direito)").tipoRegiao(retornaTipoRegiao("Região J")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Gengiva inferior anterior").tipoRegiao(retornaTipoRegiao("Região J")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Gengiva inferior posterior (lado esquerdo)").tipoRegiao(retornaTipoRegiao("Região J")).build());
        salvarRegiaoBoca(RegiaoBoca.builder().nome("Gengiva inferior posterior (lado direito)").tipoRegiao(retornaTipoRegiao("Região J")).build());

    }

    private void criarTipoLesao(){
        tipoLesaoRepository.deleteAll();

        salvarTipoLesao(TipoLesao.builder().nome("Potencialmente Maligna").build());
        salvarTipoLesao(TipoLesao.builder().nome("Maligna").build());
        salvarTipoLesao(TipoLesao.builder().nome("Outras").build());

    }

    private void criarLesao() {
        lesaoRepository.deleteAll();

        List<TipoLesao> lista = tipoLesaoRepository.findAll();

        for (TipoLesao item : lista) {
            if (item.getNome().equals("Potencialmente Maligna")){
                salvarLesao(Lesao.builder().nome("Leucoplasia").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Eritroplasia").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Queilite actínica").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Eritroleucoplasia").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Líquen").tipoLesao(item).build());
            }
            if(item.getNome().equals("Maligna")){
                salvarLesao(Lesao.builder().nome("Sim").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Não").tipoLesao(item).build());
            }
            if(item.getNome().equals("Outras")){
                salvarLesao(Lesao.builder().nome("Forma classificad").tipoLesao(item).build());
            }
        }

    }

    private void criarTipoProcedimento(){
        tipoDeProcedimentoRepository.deleteAll();

        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Biopsia").build());
        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Citologia").build());
        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Histopatológico").build());
        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Outros").build());

    }


    private void criarUsuario() {
        usuarioService.deleteAll();

        //    Role adminRole = roleRepository.findByName("ADMIN");
        //  Role userRole = roleRepository.findByName("USER");

        usuarioService.salvar(Usuario.builder().cpf("admin").email("teste@teste.com").nome("Teste").senha(passwordEncoder.encode("p@55w0Rd")).status("Ativo").build());
        usuarioService.salvar(Usuario.builder().cpf("1111111111").email("teste@teste.com").nome("Teste").senha(passwordEncoder.encode("p@55w0Rd")).status("Ativo").build());
    }


    private void salvaTipoAtencao(TipoAtencao tipoAtencao) {
        tipoAtencaoRepository.save(tipoAtencao);
    }

    private void salvaCidade(Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    private void salvaBairro(Bairro bairro) {
        bairroRepository.save(bairro);
    }

    private void salvaDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    private void salvaTipoLocalAtendimento(TipoLocalAtendimento tipoLocalAtendimento) {
        tipoLocalAtendimentoRepository.save(tipoLocalAtendimento);
    }

    private void salvaLocalAtendimento(LocalAtendimento localAtendimento) {
        localAtendimentoRepository.save(localAtendimento);
    }

    private void salvaTipoAtendimento(TipoAtendimento tipoAtendimento) {
        tipoAtendimentoRepository.save(tipoAtendimento);
    }

    private void salvaFatorRisco(FatorRisco fatorRisco) {
        fatorRiscoRepository.save(fatorRisco);
    }

    private void salvarTipoRegiao(TipoRegiao tipoRegiao) {
        tipoRegiaoRepository.save(tipoRegiao);
    }

    private void salvarRegiaoBoca(RegiaoBoca regiaoBoca) {
        regiaoBocaRepository.save(regiaoBoca);
    }


    private void salvarTipoLesao(TipoLesao tipoLesao) {
        tipoLesaoRepository.save(tipoLesao);
    }

    private void salvarLesao(Lesao lesao) {
        lesaoRepository.save(lesao);
    }

    private void salvarTipoProcedimento(TipoDeProcedimento tipoDeProcedimento) {
        tipoDeProcedimentoRepository.save(tipoDeProcedimento);
    }


    private void criarRole() {

        Role adminRole = roleRepository.findByName("ADMIN");
        if (adminRole == null) {
            Role newAdminRole = new Role();
            newAdminRole.setName("ADMIN");
            roleRepository.save(newAdminRole);
        }

        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            Role newUserRole = new Role();
            newUserRole.setName("USER");
            roleRepository.save(newUserRole);
        }
    }

    private Distrito retornaDistrito(String nome) {
        if (distritos == null) {
            distritos = distritoRepository.findAll();
        }
        for (Distrito item : distritos) {
            if (item.getNome().equals(nome)) return item;
        }
        return null;
    }

    private TipoLocalAtendimento retornaTipoLocalAtendimento(String nome) {
        if (tipos == null) {
            tipos = tipoLocalAtendimentoRepository.findAll();
        }
        for (TipoLocalAtendimento item : tipos) {
            if (item.getNome().equals(nome)) return item;
        }
        return null;
    }

    private TipoRegiao retornaTipoRegiao(String nome) {
        if (tipoRegioes == null) {
            tipoRegioes = tipoRegiaoRepository.findAll();
        }
        for (TipoRegiao item : tipoRegioes) {
            if (item.getNome().equals(nome)) return item;
        }
        return null;
    }
}

