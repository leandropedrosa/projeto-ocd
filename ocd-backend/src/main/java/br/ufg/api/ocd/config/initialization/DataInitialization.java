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

@Profile("dev")
@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    TipoAtencaoRepository tipoAtencaoRepository;

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

