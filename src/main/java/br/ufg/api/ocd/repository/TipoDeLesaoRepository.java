package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoDeLesao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeLesaoRepository extends MongoRepository<TipoDeLesao, String> {

    public TipoDeLesao findByDescricao(String nome);
}
