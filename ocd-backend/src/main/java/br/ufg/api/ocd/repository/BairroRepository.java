package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Bairro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends MongoRepository<Bairro, String> {

}
