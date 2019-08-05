package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.HistoricoAcesso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoAcessoRepository extends MongoRepository<HistoricoAcesso, Integer> {

}
