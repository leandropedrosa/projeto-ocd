package br.ufg.api.ocd.config.initialization;

import br.ufg.api.ocd.model.RegiaoBoca;
import br.ufg.api.ocd.model.TipoRegiao;
import br.ufg.api.ocd.repository.RegiaoBocaRepository;
import br.ufg.api.ocd.repository.TipoRegiaoRepository;

import java.util.List;

public class RegiaoBocaInicialization {

    private static RegiaoBocaRepository regiaoBocaRepository;
    private static TipoRegiaoRepository tipoRegiaoRepository;
    private static List<TipoRegiao> tipoRegioes;

    public static void criaRegiaoBoca(RegiaoBocaRepository repository, TipoRegiaoRepository tRRepository) {
        regiaoBocaRepository = repository;
        tipoRegiaoRepository = tRRepository;
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

    private static void salvarRegiaoBoca(RegiaoBoca regiaoBoca) {
        regiaoBocaRepository.save(regiaoBoca);
    }

    private static TipoRegiao retornaTipoRegiao(String nome) {
        if (tipoRegioes == null) {
            tipoRegioes = tipoRegiaoRepository.findAll();
        }
        for (TipoRegiao item : tipoRegioes) {
            if (item.getNome().equals(nome)) return item;
        }
        return null;
    }
}
