package br.ufg.api.ocd.config.initialization;


import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static br.ufg.api.ocd.config.initialization.BairroInicialization.criarBairros;
import static br.ufg.api.ocd.config.initialization.LocalAtendimentoInicialization.criaLocalAtendimento;
import static br.ufg.api.ocd.config.initialization.RegiaoBocaInicialization.criaRegiaoBoca;
import static br.ufg.api.ocd.config.initialization.ScriptsMobileIncialization.criarScriptsIniciaisMobile;

//@Profile("dev")
@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VersaoBancoRepository versaoBancoRepository;

    @Autowired
    private ScriptsMobileRepository scriptsRepository;

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
    UsuarioRepository usuarioRepository;

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
        criarVersaoBanco();
        // criarRole();
        criarUsuario();
        criarScripts();
        //System.out.println("CRIPTO "+passwordEncoder.encode("p@55w0Rd")+" CRIPTO");
    }

    private void criarVersaoBanco() {
        versaoBancoRepository.deleteAll();
        salvaVersaoBanco(VersaoBanco.builder().descricao("1.0").data(new Date()).build());
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
        List<Cidade> lista = cidadeRepository.findByNome("Goiânia");
        criarBairros(bairroRepository, lista.get(0));
    }

    private void criarScripts() {
        //  List<VersaoBanco> lista = versaoBancoRepository.findAllOrderByDataAsc();
        //  criarScriptsIniciaisMobile(scriptsRepository, lista.get(0));
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
        criaLocalAtendimento(localAtendimentoRepository, distritoRepository, tipoLocalAtendimentoRepository);
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
        criaRegiaoBoca(regiaoBocaRepository, tipoRegiaoRepository);
    }

    private void criarTipoLesao() {
        tipoLesaoRepository.deleteAll();

        salvarTipoLesao(TipoLesao.builder().nome("Potencialmente Maligna").build());
        salvarTipoLesao(TipoLesao.builder().nome("Maligna").build());
        salvarTipoLesao(TipoLesao.builder().nome("Outras").build());

    }

    private void criarLesao() {
        lesaoRepository.deleteAll();

        List<TipoLesao> lista = tipoLesaoRepository.findAll();

        for (TipoLesao item : lista) {
            if (item.getNome().equals("Potencialmente Maligna")) {
                salvarLesao(Lesao.builder().nome("Leucoplasia").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Eritroplasia").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Queilite actínica").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Eritroleucoplasia").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Líquen").tipoLesao(item).build());
            }
            if (item.getNome().equals("Maligna")) {
                salvarLesao(Lesao.builder().nome("Sim").tipoLesao(item).build());
                salvarLesao(Lesao.builder().nome("Não").tipoLesao(item).build());
            }
            if (item.getNome().equals("Outras")) {
                salvarLesao(Lesao.builder().nome("Forma classificad").tipoLesao(item).build());
            }
        }

    }

    private void criarTipoProcedimento() {
        tipoDeProcedimentoRepository.deleteAll();

        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Biopsia").build());
        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Citologia").build());
        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Histopatológico").build());
        salvarTipoProcedimento(TipoDeProcedimento.builder().nome("Outros").build());

    }


    private void criarUsuario() {
        usuarioRepository.deleteAll();

        //    Role adminRole = roleRepository.findByName("ADMIN");
        //  Role userRole = roleRepository.findByName("USER");

        usuarioRepository.save(Usuario.builder().cpf("admin").email("teste@teste.com").nome("Teste").senha(passwordEncoder.encode("p@55w0Rd")).status("Ativo").build());
        usuarioRepository.save(Usuario.builder().cpf("1111111111").email("teste@teste.com").nome("Teste").senha(passwordEncoder.encode("p@55w0Rd")).status("Ativo").build());
    }

    private void salvaVersaoBanco(VersaoBanco versaoBanco) {
        versaoBancoRepository.save(versaoBanco);
    }

    private void salvaTipoAtencao(TipoAtencao tipoAtencao) {
        tipoAtencaoRepository.save(tipoAtencao);
    }

    private void salvaCidade(Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    private void salvaDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    private void salvaTipoLocalAtendimento(TipoLocalAtendimento tipoLocalAtendimento) {
        tipoLocalAtendimentoRepository.save(tipoLocalAtendimento);
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


}

