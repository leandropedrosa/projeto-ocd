package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoLesao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLesaoRepository extends MongoRepository<TipoLesao, String> {

}
