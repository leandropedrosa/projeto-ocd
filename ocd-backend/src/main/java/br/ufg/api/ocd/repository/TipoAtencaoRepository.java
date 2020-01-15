package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoAtencao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAtencaoRepository extends MongoRepository<TipoAtencao, String> {

}
