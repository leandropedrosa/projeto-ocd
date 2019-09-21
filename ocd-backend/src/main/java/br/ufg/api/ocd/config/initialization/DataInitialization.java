package br.ufg.api.ocd.config.initialization;


import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LesaoRepository lesaoRepo;

    @Autowired
    FatorDeRiscoRepository fatorVunerabilidadeRepo;

    @Autowired
    LocalAtendimentoRepository localAtendimentoRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
       // criarLesoes();
       // criarFatorDeRisco();
       // criarLocaDeAtendimento();
       // criarRole();
       // criarUsuario();
    }

    private void criarUsuario() {
        userRepository.deleteAll();

       // Role adminRole = roleRepository.findByName("ADMIN");
       // Role userRole = roleRepository.findByName("USER");

        salvaUsuario(new Usuario("Ativo", "1111111111", "Adm", passwordEncoder.encode("123"), "Administrador", "Norte", "administrador@gmail.com"));
        salvaUsuario(new Usuario("Ativo", "2222222222", "User", passwordEncoder.encode("123"), "Teste", "Norte", "teste@gmail.com"));

        UsuariosInitialization.criaListaDeUsuarios(passwordEncoder).stream().forEach(usuario -> salvaUsuario(usuario));
    }

    private void criarLesoes() {
        lesaoRepo.deleteAll();
        salvaLesao(new Lesao("Potencialmente maligna (leucoplasia)"));
        salvaLesao(new Lesao("Potencialmente maligna (eritroleucoplasia)"));
        salvaLesao(new Lesao("Potencialmente maligna (líquen)"));
        salvaLesao(new Lesao("Potencialmente maligna (queilite actínica)"));
        salvaLesao(new Lesao("Maligna"));
        salvaLesao(new Lesao("Não Maligna"));
        salvaLesao(new Lesao("Outro"));
    }

    private void criarFatorDeRisco() {
        fatorVunerabilidadeRepo.deleteAll();

        salvaFatorDeVunerabilidade(new FatorDeRisco("Idade"));
        salvaFatorDeVunerabilidade(new FatorDeRisco("É fumante"));
        salvaFatorDeVunerabilidade(new FatorDeRisco("Exposição ao sol"));
        salvaFatorDeVunerabilidade(new FatorDeRisco("Possui históriada doença"));
        salvaFatorDeVunerabilidade(new FatorDeRisco("Faz uso de bebida álcoolica"));

    }

    private void criarLocaDeAtendimento() {
        localAtendimentoRepo.deleteAll();
        LocalAtendimentoInitialization.criaListaDeLocais().stream().forEach(local -> salvaLocalDeAtendimento(local));
    }

    private void salvaUsuario(Usuario usuario) {

        //usuario.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(usuario);
    }

    private void salvaLesao(Lesao lesao) {
        lesaoRepo.save(lesao);
    }

    private void salvaFatorDeVunerabilidade(FatorDeRisco fator) {
        fatorVunerabilidadeRepo.save(fator);
    }

    private void salvaLocalDeAtendimento(LocalDeAtendimento local) {
        localAtendimentoRepo.save(local);
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

