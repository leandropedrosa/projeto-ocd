package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoDeCancer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeCancerRepository extends MongoRepository<TipoDeCancer, Integer> {
}
