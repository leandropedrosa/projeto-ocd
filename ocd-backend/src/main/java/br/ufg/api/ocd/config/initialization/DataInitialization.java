package br.ufg.api.ocd.config.initialization;


import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import br.ufg.api.ocd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    RoleRepository roleRepository;

    @Autowired
    LesaoRepository lesaoRepo;

    @Autowired
    LocalAtendimentoRepository localAtendimentoRepo;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        criarTipoAtencao();
        criarCidade();
        criarBairro();
        criarDistrito();
       // criarTipoLocalAtendimento();
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

    private void criarBairro(){
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

        for (Bairro item :lista) {
            if (item.getNome().equals("BAIRRO GOIÁ I")) salvaDistrito(Distrito.builder().nome("Oeste").bairro(item).build());
            if (item.getNome().equals("JD. NOVO MUNDO")) salvaDistrito(Distrito.builder().nome("Leste").bairro(item).build());
            if (item.getNome().equals("JARDIM AMÉRICA")) salvaDistrito(Distrito.builder().nome("Sul").bairro(item).build());
            if (item.getNome().equals("JD. GUANABARA")) salvaDistrito(Distrito.builder().nome("Norte").bairro(item).build());
            if (item.getNome().equals("SETOR NORTE FERROVIÁRIO")) salvaDistrito(Distrito.builder().nome("Central").bairro(item).build());
            if (item.getNome().equals("VILA MUTIRÃO I")) salvaDistrito(Distrito.builder().nome("Noroeste").bairro(item).build());
            if (item.getNome().equals("SETOR SUDOESTE")) salvaDistrito(Distrito.builder().nome("Sudoeste").bairro(item).build());
        }

    }



    private void criarTipoLocalAtendimento() {
        tipoLocalAtendimentoRepository.deleteAll();
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CAIS").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CIAMS").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("UPA").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CENTROS DE SAÚDE").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CENTROS DE SAÚDE DA FAMÍLIA - CSF").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("UNIDADE DE ATENDIMENTO A SAÚDE").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("CEO - CENTRO DE ESPECIALIDADES ODONTOLOGICAS").build());
        salvatipoLocalAtendimento(TipoLocalAtendimento.builder().nome("OUTRAS UNIDADES").build());
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





    private void salvatipoLocalAtendimento(TipoLocalAtendimento tpoLocalAtendimento) {
        tipoLocalAtendimentoRepository.save(tpoLocalAtendimento);
    }

    private void salvaLesao(Lesao lesao) {
        lesaoRepo.save(lesao);
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
}

