package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.LocalDaLesao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalDaLesaoRepository extends MongoRepository<LocalDaLesao, String> {

}
