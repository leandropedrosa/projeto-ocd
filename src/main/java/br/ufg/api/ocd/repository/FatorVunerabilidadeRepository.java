package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.FatorVunerabilidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatorVunerabilidadeRepository extends MongoRepository<FatorVunerabilidade, String> {
    public List<FatorVunerabilidade> findByIdTipoCancer(String idTipoCancer);

}
