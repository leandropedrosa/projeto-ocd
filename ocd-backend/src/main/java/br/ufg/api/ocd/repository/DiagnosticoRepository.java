package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Diagnostico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends MongoRepository<Diagnostico, String> {

}
