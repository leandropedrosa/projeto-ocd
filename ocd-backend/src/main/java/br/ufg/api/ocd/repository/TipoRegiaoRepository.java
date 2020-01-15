package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoRegiao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRegiaoRepository extends MongoRepository<TipoRegiao, String> {

}
