package br.ufg.api.ocd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatorDeRiscoRepository extends MongoRepository<FatorDeRisco, String> {
}
