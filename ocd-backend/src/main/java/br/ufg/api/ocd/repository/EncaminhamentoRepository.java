package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Encaminhamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncaminhamentoRepository extends MongoRepository<Encaminhamento, String> {

}
