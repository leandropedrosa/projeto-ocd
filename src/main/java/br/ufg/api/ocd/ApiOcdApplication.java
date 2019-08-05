package br.ufg.api.ocd;

import br.ufg.api.ocd.model.*;
import br.ufg.api.ocd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableSwagger2
public class ApiOcdApplication  implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(ApiOcdApplication.class, args);
	}


	/**
	 * Apenas acrescenta um paciente para simples teste.
	 * @param args
	 */
	@Override
	public void run(String... args) {

	}

	private void salvaTipoLesao(){
		tipoLesaoRepo.deleteAll();

		TipoDeLesao m = new TipoDeLesao();
		m.setDescricao("Maligna");

		TipoDeLesao pm = new TipoDeLesao();
		pm.setDescricao("Potencialmente Maligna");

		tipoLesaoRepo.save(m);
		tipoLesaoRepo.save(pm);
	}

	private void salvaLesao(){
		lesaoRepo.deleteAll();

		TipoDeLesao maligna = tipoLesaoRepo.findByDescricao("Maligna");

		Lesao m = new Lesao();
		m.setNome("Teste");
		m.setIdTipoLesao(maligna.getId());

		TipoDeLesao potecialmenteMaligna = tipoLesaoRepo.findByDescricao("Potencialmente Maligna");

		Lesao m2 = new Lesao();
		m2.setNome("Teste");
		m2.setIdTipoLesao(potecialmenteMaligna.getId());

		lesaoRepo.save(m);
		lesaoRepo.save(m2);
	}

	private void salvaTipoCancer(){
		tipoDeCancerRepo.deleteAll();

		TipoDeCancer cb = new TipoDeCancer();
		cb.setDescricao("Câncer de Boca");

		TipoDeCancer cbu = new TipoDeCancer();
		cbu.setDescricao("Câncer de Colo do Útero ");

		tipoDeCancerRepo.save(cb);
		tipoDeCancerRepo.save(cbu);
	}


	private void salvaFatorDeVunerabilidade(){
		fatorVunerabilidadeRepo.deleteAll();

		TipoDeCancer cb = tipoDeCancerRepo.findByDescricao("Câncer de Boca");

		FatorVunerabilidade f = new FatorVunerabilidade();
		f.setDescricao("Idade");
		f.setIdTipoCancer(cb.getId());

		FatorVunerabilidade f2 = new FatorVunerabilidade();
		f.setDescricao("É fumante");
		f.setIdTipoCancer(cb.getId());

		FatorVunerabilidade f3 = new FatorVunerabilidade();
		f.setDescricao("Exposição ao sol");
		f.setIdTipoCancer(cb.getId());

		FatorVunerabilidade f4 = new FatorVunerabilidade();
		f.setDescricao("Possui históriada doença");
		f.setIdTipoCancer(cb.getId());

		FatorVunerabilidade f5 = new FatorVunerabilidade();
		f.setDescricao("Faz uso de bebida álcoolica");
		f.setIdTipoCancer(cb.getId());

		TipoDeCancer ccu = tipoDeCancerRepo.findByDescricao("Câncer de Colo do Útero");

		FatorVunerabilidade f6 = new FatorVunerabilidade();
		f.setDescricao("Teste 1");
		f.setIdTipoCancer(ccu.getId());

		FatorVunerabilidade f7 = new FatorVunerabilidade();
		f.setDescricao("Teste 2");
		f.setIdTipoCancer(ccu.getId());

		fatorVunerabilidadeRepo.save(f);
		fatorVunerabilidadeRepo.save(f2);
		fatorVunerabilidadeRepo.save(f3);
		fatorVunerabilidadeRepo.save(f4);
		fatorVunerabilidadeRepo.save(f5);
		fatorVunerabilidadeRepo.save(f6);
		fatorVunerabilidadeRepo.save(f7);
	}

	private void salvaLocalAtendimento(){
		localAtendimentoRepo.deleteAll();

		LocalAtendimento r1 = new LocalAtendimento();
		r1.setDescricao("Região 1");

		LocalAtendimento r2 = new LocalAtendimento();
		r1.setDescricao("Região 2");

		localAtendimentoRepo.save(r1);
		localAtendimentoRepo.save(r2);
	}

	private void salvaLocalTipoUsuario(){
		tipoDeUsuarioRepo.deleteAll();

		TipoDeUsuario tu1 = new TipoDeUsuario();
		tu1.setDescricao("Dentista");

		TipoDeUsuario tu2 = new TipoDeUsuario();
		tu2.setDescricao("Auxiliar SB");

		TipoDeUsuario tu3 = new TipoDeUsuario();
		tu3.setDescricao("Técnico em Enfermagem");

		TipoDeUsuario tu4 = new TipoDeUsuario();
		tu4.setDescricao("Enfermeiro");

		TipoDeUsuario tu5 = new TipoDeUsuario();
		tu5.setDescricao("Agente de Saúde");

		tipoDeUsuarioRepo.save(tu1);
		tipoDeUsuarioRepo.save(tu2);
		tipoDeUsuarioRepo.save(tu3);
		tipoDeUsuarioRepo.save(tu4);
		tipoDeUsuarioRepo.save(tu5);
	}
}
