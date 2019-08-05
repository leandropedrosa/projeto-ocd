package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.LocalAtendimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalAtendimentoRepository extends MongoRepository<LocalAtendimento, Integer> {
}
