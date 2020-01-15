package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.RegiaoBoca;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoBocaRepository extends MongoRepository<RegiaoBoca, String> {

}
