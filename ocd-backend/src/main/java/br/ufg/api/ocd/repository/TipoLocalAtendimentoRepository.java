package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoLocalAtendimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLocalAtendimentoRepository extends MongoRepository<TipoLocalAtendimento, String> {

}
