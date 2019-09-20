package br.ufg.api.ocd.config.initialization;


import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

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
        criarLesoes();
        criarFatorDeRisco();
        criarLocaDeAtendimento();
        criarUsuario();
    }

    private void criarUsuario() {
        userRepository.deleteAll();
        roleRepository.deleteAll();

        salvaUsuario(new Usuario("Ativo", "1111111111", "Adm", passwordEncoder.encode("123"), "Primária", "Norte", "administrador@gmail.com"), "ADM");
        salvaUsuario(new Usuario("Ativo", "2222222222", "User", passwordEncoder.encode("123"), "Secundária", "Norte", "teste@gmail.com"), "ADM");
    }

    private void criarLesoes() {
        lesaoRepo.deleteAll();
        salvaLesao(new Lesao("Potencialmente maligna (leucoplasia)"));
        salvaLesao(new Lesao("Potencialmente maligna (eritroleucoplasia)"));
        salvaLesao(new Lesao("Potencialmente maligna (líquen)"));
        salvaLesao(new Lesao("Potencialmente maligna (queilite actínica)"));
        salvaLesao(new Lesao("Outro"));
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
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região campinas - centro","Distrito","Campinas - centro","Setor norte ferroviário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região leste","Distrito","Leste","Jardim novo mundo","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região noroeste","Distrito","Noroeste","Vila mutirão","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região norte","Distrito","Norte","Jardim guanabara i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região oeste","Distrito","Oeste","Setor bairro goiá","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Distrito sudoeste","Distrito","Sudoeste","Setor sudoeste","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Região sul","Distrito","Sul","Jardim américa","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Amendoeiras","Cais","Leste","Setor parque das amendoeiras","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Bairro goiá","Cais","Oeste","Setor bairro goiá","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Campinas","Cais","Campinas/centro","Setor dos funcionários","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Cândida de morais","Cais","Noroeste","Setor cândida de morais","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Chácara do governador","Cais","Leste","Setor chácara do governador","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Deputado joão natal","Cais","Campinas/centro","Setor vila nova","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Finsocial","Cais","Noroeste","Setor finsocial","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim guanabara iii","Cais","Norte","Jardim guanabara iii","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim novo mundo","Cais","Leste","Jardim novo mundo","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim américa","Ciams","Sul","Jardim américa","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Novo horizonte","Ciams","Sudoeste","Novo horizonte","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Pedro ludovico","Ciams","Sul","Setor pedro ludovico","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Urias magalhães","Ciams","Norte","Setor urias magalhães","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("João batista de sousa júnior - upa itaipu","Upa","Sudoeste","Residencial itaipu","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Maria pires perillo - upa noroeste","Upa","Noroeste","Jardim curitiba i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("“Benedito dos santos vieira” setor perim","Centros de saúde","Norte","Setor perim","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Cidade jardim (antigo rodoviário) - michele muniz do carmo","Centros de saúde","Campinas/centro","Setor cidade jardim","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Conjunto riviera","Centros de saúde","Leste","Jardim brasil","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Dr. Afonso h. Da s. E souza vila água branca","Centros de saúde","Leste","Setor água branca","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Esplanada do anicuns","Centros de saúde","Campinas/centro","Setor esplanada dos anincus","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Fama","Centros de saúde","Campinas/centro","Setor marechal rondon","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("“Hortência mendonça” - vila redenção","Centros de saúde","Sul","Vila redenção","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("“Isabel maria da silva” - vila maria dilce","Centros de saúde","Norte","Vila maria dilce","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim vila boa","Centros de saúde","Sudoeste","Vila boa","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jd. Balneário m. Ponte","Centros de saúde","Norte","Jardim balneário meia ponte","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("“José do egídio martins” - vila união","Centros de saúde","Sudoeste","Vila união","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("“Marinho lemos” – negrão de lima","Centros de saúde","Campinas/centro","Setor negrão de lima","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Norte ferroviário","Centros de saúde","Campinas/centro","Setor norte ferroviário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque amazônia","Centros de saúde","Sul","Parque amazônia","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque anhanguera","Centros de saúde","Sudoeste","Parque anhanguera","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque ind. João braz","Centros de saúde","Oeste","Parque ind. João braz","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Setor criméia leste","Centros de saúde","Campinas/centro","Setor criméia leste","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila canaã","Centros de saúde","Campinas/centro","Vila canaã","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila clemente","Centros de saúde","Norte","Vila clemente","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila mauá","Centros de saúde","Sudoeste","Vila mauá","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila moraes","Centros de saúde","Campinas/centro","Vila moraes","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila santa helena","Centros de saúde","Campinas/centro","Vila paraíso","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Andréia cristina","Centro de saúde da família - csf","Sudoeste","Setor andréia cristina","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Antonio carlos pires","Centro de saúde da família - csf","Norte","Setor antonio carlos pires","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Aruanã iii","Centro de saúde da família - csf","Leste","Conjunto aruanã iii","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Bairro da vitória ii","Centro de saúde da família - csf","Noroeste","Bairro da vitória","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Bairro goiá","Centro de saúde da família - csf","Oeste","Setor bairro goiá","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Bairro são francisco","Centro de saúde da família - csf","Oeste","Bairro são francisco","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Barravento","Centro de saúde da família - csf","Noroeste","Residencial barravento","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Boa vista / floresta","Centro de saúde da família - csf","Noroeste","Bairro boa vista","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Buena vista","Centro de saúde da família - csf","Oeste","Residencial buena vista i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Cachoeira dourada","Centro de saúde da família - csf","Norte","Jardim guanabara i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Campus samambaia","Centro de saúde da família - csf","Norte","Campus samambaia","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Condomínio das esmeraldas","Centro de saúde da família - csf","Sudoeste","Condomínio das esmeraldas i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Condomínio morada do sol","Centro de saúde da família - csf","Noroeste","Setor morada do sol","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Conjunto itatiaia","Centro de saúde da família - csf","Norte","Conjunto itatiaia i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vera cruz i","Centro de saúde da família - csf","Oeste","Conjunto vera cruz i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vera cruz ii","Centro de saúde da família - csf","Oeste","Vera cruz ii","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Criméia oeste","Centro de saúde da família - csf","Campinas/centro","Setor criméia oeste","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Distrito de vila rica","Centro de saúde da família - csf","Norte","Setor vila rica","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Dom fernando ii","Centro de saúde da família - csf","Leste","Jardim dom fernando ii","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Estrela dalva","Centro de saúde da família - csf","Noroeste","Setor estrela dalva","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Garavelo b","Centro de saúde da família - csf","Sudoeste","Setor garavelo b","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Grajaú","Centro de saúde da família - csf","Sudoeste","Setor grajaú","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim aroeira","Centro de saúde da família - csf","Leste","Jardim das aroeiras","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim caravelas","Centro de saúde da família - csf","Sudoeste","Jardim caravelas","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim colorado","Centro de saúde da família - csf","Noroeste","Setor jardim colorado","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("JARDIM CURITIBA I e II","CENTRO DE SAÚDE DA FAMÍLIA - CSF","NOROESTE","JARDIM CURITIBA II","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim curitiba iii","Centro de saúde da família - csf","Noroeste","Bairro boa vista","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim guanabara i","Centro de saúde da família - csf","Norte","Jardim guanabara","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim mariliza","Centro de saúde da família - csf","Leste","Jardim mariliza","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim mirabel","Centro de saúde da família - csf","Oeste","Setor bairro goiá","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim novo planalto","Centro de saúde da família - csf","Noroeste","Setor novo planalto","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim primavera","Centro de saúde da família - csf","Noroeste","Jardim primavera","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Jardim aritana","Centro de saúde da família - csf","Oeste","Jardim aritana","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Leste universitário","Centro de saúde da família - csf","Campinas/centro","Setor leste universitário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Madre germana ii","Centro de saúde da família - csf","Sudoeste","Conjunto habitacional madre germana ii","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Núcleo de apoio a saúde da familia - nasf curitiba i","Centro de saúde da família - csf","Noroeste","Jardim curitiba i","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque atheneu i","Centro de saúde da família - csf","Leste","Parque atheneu","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque dos buritis","Centro de saúde da família - csf","Oeste","Parque dos buritis","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque eldorado oeste","Centro de saúde da família - csf","Oeste","Parque eldorado oeste","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque santa rita","Centro de saúde da família - csf","Sudoeste","Parque santa rita","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Parque tremendão","Centro de saúde da família - csf","Noroeste","Parque tremendão","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Real conquista","Centro de saúde da família - csf","Sudoeste","Setor real conquista","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Militão rodrigues (antigo recanto das minas gerais)","Centro de saúde da família - csf","Leste","Jardim abapuru","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial brisa da mata","Centro de saúde da família - csf","Noroeste","Residencial brisa da mata","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial ana clara","Centro de saúde da família - csf","Sudoeste","Condomínio das esmeraldas","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial eli forte","Centro de saúde da família - csf","Sudoeste","Residencial eli forte","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial goiânia viva","Centro de saúde da família - csf","Oeste","Reserva ecologica do residencial goiânia viva","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial itaipu","Centro de saúde da família - csf","Sudoeste","Residencial itaipu","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial jardim do cerrado","Centro de saúde da família - csf","Oeste","Residencial jardim do cerrado 4","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial jardim do cerrado vi","Centro de saúde da família - csf","Oeste","Jardim do cerrado vi","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial vale dos sonhos","Centro de saúde da família - csf","Norte","Residencial vale dos sonhos","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial ville de france","Centro de saúde da família - csf","Leste","Residencial ville de france","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencial ytapuã","Centro de saúde da família - csf","Oeste","Residencial ytapuã","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("São carlos","Centro de saúde da família - csf","Noroeste","Bairro são carlos","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Setor luana park","Centro de saúde da família - csf","Oeste","Setor luana park","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Setor recanto do bosque","Centro de saúde da família - csf","Noroeste","Setor recanto do bosque","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Setor são judas tadeu","Centro de saúde da família - csf","Norte","Setor são judas tadeu","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Setor santo hilário","Centro de saúde da família - csf","Leste","Bairro santo hilário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila mutirão","Centro de saúde da família - csf","Noroeste","Vila mutirão","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vf-18 - finsocial","Centro de saúde da família - csf","Noroeste","Vila finsocial","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila pedroso","Centro de saúde da família - csf","Leste","Vila pedroso","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vila regina","Centro de saúde da família - csf","Oeste","Vila regina","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Ambulatório municipal de psiquiatria","Unidade de atendimento à saúde mental","Sul","Jardim américa","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial – caps noroeste/jardim liberdade","Unidade de atendimento à saúde mental","Noroeste","Vila mutirão","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial - caps beija-flor","Unidade de atendimento à saúde mental","Sudoeste","Jardim presidente","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial - caps esperança","Unidade de atendimento à saúde mental","Oeste","Jardim petropóles","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial - caps girassol","Unidade de atendimento à saúde mental","Campinas/centro","Setor campinas","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial - caps novo mundo","Unidade de atendimento à saúde mental","Leste","Jardim das aroeiras","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial - caps vida","Unidade de atendimento à saúde mental","Sul","Setor marista","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial - caps – ad/casa","Unidade de atendimento à saúde mental","Sul","Setor sul","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial infanto-juvenil – caps água viva","Unidade de atendimento à saúde mental","Sul","Setor vila nova","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de atenção psicossocial infanto juvenil - caps negrão de lima","Unidade de atendimento à saúde mental","Campinas/centro","Setor negrão de lima","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de convivencia cuca fresca","Unidade de atendimento à saúde mental","Sul","Jardim américa","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Pronto socorro psiquiátrico “wassily chuc”","Unidade de atendimento à saúde mental","Sul","Setor bueno","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residência terapêutica beija-flor i","Unidade de atendimento à saúde mental","Sudoeste","Setor faiçalville","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residência terapêutica beija-flor ii (unidade feminina)","Unidade de atendimento à saúde mental","Sudoeste","Setor faiçalville","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residência terapêutica mendanha i (unidade feminina)","Unidade de atendimento à saúde mental","Oeste","Jardim petropóles","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residência terapêutica mendanha ii (unidade masculina)","Unidade de atendimento à saúde mental","Oeste","Jardim petropóles","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residência terapêutica novo mundo i","Unidade de atendimento à saúde mental","Leste","Jardim novo mundo","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Residencia terapeutica novo mundo ii","Unidade de atendimento à saúde mental","Leste","Vila concordia","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Associação de trab. E prod. Solidária em saúde mental - gerarte i","Unidade de atendimento à saúde mental","Sul","Setor marista","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Unidade de trab. E prod. Solidária da saúde mental - gerarte ii","Unidade de atendimento à saúde mental","Campinas/centro","Setor dos funcionários","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de comercialização de economia solidária - loja arte e saúde","Unidade de atendimento à saúde mental","Sul","Setor aeroporto","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de referencia - crdt","Ceo - centro de especialidades odontológicas","Sul","Setor sul","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Cais jardim novo mundo","Ceo - centro de especialidades odontológicas","Campinas - centro","Jardim novo mundo","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Cais cândida de moraes","Ceo - centro de especialidades odontológicas","Campinas/centro","Vila moraes","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Ciams novo horizonte","Ceo - centro de especialidades odontológicas","Sudoeste","Novo horizonte","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Ambulatório municipal de queimaduras","Outras unidades","Campinas/centro","Setor dos funcionários","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vigilancia em saude do trabalhador","Outras unidades","Campinas/centro","Setor norte ferroviário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de referência em ortopedia e fisioterapia crof","Outras unidades","Campinas/centro","Setor aeroviário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro de referência em atenção à saúde da pessoa idosa - craspi","Outras unidades","Campinas/centro","Setor cidade jardim","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Crdt -“cândido j. S. De moura”","Outras unidades","Campinas/centro","Setor norte ferroviário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Vigilância em zoonoses","Outras unidades","Rural","Fazenda val das pombas, rodov. Go-020 km 05","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Farmácia de insumos e medicamentos especiais","Outras unidades","Campinas/centro","Vila viana","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Farmacia distrital central","Outras unidades","Campinas/centro","Setor norte ferroviário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Farmacia distrital oeste","Outras unidades","Oeste","Setor bairro goiá","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Farmacia popular/faculdade de farmacia da universidade federal de goiás - ufg","Outras unidades","Campinas/centro","Setor leste universitário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Farmacia popular do brasil","Outras unidades","Campinas/centro","Setor central","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Hospital da mulher e maternidade dona iris","Outras unidades","Sul","Vila redenção","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Maternidade nascer cidadão","Outras unidades","Noroeste","Jardim curitiba iii","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Ouvidoria da saúde","Outras unidades","Noroeste","Park lozandes","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Serviço de ver. De óbitos - svo","Outras unidades","Campinas/centro","Setor cidade jardim","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Serviço esp. Em eng. De segurança e em medicina do trabalho – sesmt","Outras unidades","Noroeste","Park lozandes","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Consultorio de rua","Outras unidades","Campinas/centro","Setor leste universitário","Goiânia"));
        salvaLocalDeAtendimento(new LocalDeAtendimento("Centro municipal de vacinação","Outras unidades","Sul","Setor pedro ludovico","Goiânia"));
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

    private void salvaFatorDeVunerabilidade(FatorDeRisco fator) {
        fatorVunerabilidadeRepo.save(fator);
    }

    private void salvaLocalDeAtendimento(LocalDeAtendimento local) {
        localAtendimentoRepo.save(local);
    }

}

