package br.ufg.api.ocd.config.initialization;


import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TipoDeLesaoRepository tipoLesaoRepo;

    @Autowired
    LesaoRepository lesaoRepo;

    @Autowired
    TipoDeCancerRepository tipoDeCancerRepo;

    @Autowired
    FatorVunerabilidadeRepository fatorVunerabilidadeRepo;

    @Autowired
    LocalAtendimentoRepository localAtendimentoRepo;

    @Autowired
    TipoDeUsuarioRepository tipoDeUsuarioRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        criarTiposDeUsuario();
        criarTipoDeLesao();
        criarTipoDeCancer();
        criarLesoes();
        criarFatorDeVunerabilidade();
        criarLocaDeAtendimento();
        criarUsuario();
    }

    private void criarUsuario() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        TipoDeCancer d = tipoDeCancerRepo.findByDescricao("Dentista");
        TipoDeCancer asb = tipoDeCancerRepo.findByDescricao("Auxiliar SB");

        salvaUsuario(new Usuario("Administrador", "administrador@gmail.com", passwordEncoder.encode("123"), "3232sdsd", d.getId()), "ADM");
        salvaUsuario(new Usuario("Teste", "teste@gmail.com", passwordEncoder.encode("123"), "3232sdsd", asb.getId()), "USER");
    }

    private void criarLesoes() {
        lesaoRepo.deleteAll();
        TipoDeLesao maligna = tipoLesaoRepo.findByDescricao("Maligna");
        salvaLesao(new Lesao("Lesão Maligna", maligna.getId()));

        TipoDeLesao potecialmenteMaligna = tipoLesaoRepo.findByDescricao("Potencialmente Maligna");
        salvaLesao(new Lesao("Lesão Potencialmente Maligna", potecialmenteMaligna.getId()));
    }

    private void criarTipoDeLesao() {
        tipoLesaoRepo.deleteAll();
        salvaTipoDeLesao(new TipoDeLesao("Maligna"));
        salvaTipoDeLesao(new TipoDeLesao("Potencialmente Maligna"));
    }

    private void criarTipoDeCancer() {
        tipoDeCancerRepo.deleteAll();
        salvaTipoDeCancer(new TipoDeCancer("Câncer de Boca"));
        salvaTipoDeCancer(new TipoDeCancer("Câncer de Colo do Útero"));
    }

    private void criarFatorDeVunerabilidade() {
        fatorVunerabilidadeRepo.deleteAll();

        TipoDeCancer cb = tipoDeCancerRepo.findByDescricao("Câncer de Boca");

        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("Idade", cb.getId()));
        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("É fumante", cb.getId()));
        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("Exposição ao sol", cb.getId()));
        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("Possui históriada doença", cb.getId()));
        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("Faz uso de bebida álcoolica", cb.getId()));

        TipoDeCancer ccu = tipoDeCancerRepo.findByDescricao("Câncer de Colo do Útero");
        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("Fator 1", ccu.getId()));
        salvaFatorDeVunerabilidade(new FatorDeVunerabilidade("Fator 2", ccu.getId()));
    }

    private void criarLocaDeAtendimento() {
        localAtendimentoRepo.deleteAll();
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região 1"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região 2"));
    }

    private void criarTiposDeUsuario() {
        tipoDeUsuarioRepo.deleteAll();
        salvaTipoDeUsuario(new TipoDeUsuario("Dentista"));
        salvaTipoDeUsuario(new TipoDeUsuario("Auxiliar SB"));
        salvaTipoDeUsuario(new TipoDeUsuario("Técnico em Enfermagem"));
        salvaTipoDeUsuario(new TipoDeUsuario("Enfermeiro"));
        salvaTipoDeUsuario(new TipoDeUsuario("Agente de Saúde"));
    }

    private void salvaUsuario(Usuario usuario, String roleName) {

        Role role = new Role(roleName);

        this.roleRepository.save(role);
        usuario.setRoles(Collections.singletonList(role));
        usuario.setStatus("Ativo");
        userRepository.save(usuario);
    }

    private void salvaLesao(Lesao lesao) {
        lesaoRepo.save(lesao);
    }

    private void salvaTipoDeLesao(TipoDeLesao tipo) {
        tipoLesaoRepo.save(tipo);
    }

    private void salvaTipoDeCancer(TipoDeCancer tipo) {
        tipoDeCancerRepo.save(tipo);
    }

    private void salvaFatorDeVunerabilidade(FatorDeVunerabilidade fator) {
        fatorVunerabilidadeRepo.save(fator);
    }

    private void salvaLocalDeAtendimento(LocalDeAtendimento local) {
        localAtendimentoRepo.save(local);
    }

    private void salvaTipoDeUsuario(TipoDeUsuario tipo) {
        tipoDeUsuarioRepo.save(tipo);
    }

}

