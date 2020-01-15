package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoAtendimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAtendimentoRepository extends MongoRepository<TipoAtendimento, String> {

}
