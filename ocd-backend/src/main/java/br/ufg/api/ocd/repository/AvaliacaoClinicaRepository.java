package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.AvaliacaoClinica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoClinicaRepository extends MongoRepository<AvaliacaoClinica, String> {

}
