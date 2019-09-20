package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.FatorDeRisco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatorDeRiscoRepository extends MongoRepository<FatorDeRisco, String> {
}
