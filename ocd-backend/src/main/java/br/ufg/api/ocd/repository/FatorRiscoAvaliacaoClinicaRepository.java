package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.FatorRiscoAvaliacaoClinica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatorRiscoAvaliacaoClinicaRepository extends MongoRepository<FatorRiscoAvaliacaoClinica, String> {

}
