package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoDeProcedimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeProcedimentoRepository extends MongoRepository<TipoDeProcedimento, String> {

}
