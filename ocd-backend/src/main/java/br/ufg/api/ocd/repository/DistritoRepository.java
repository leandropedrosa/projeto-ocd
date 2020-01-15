package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Distrito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends MongoRepository<Distrito, String> {

}
