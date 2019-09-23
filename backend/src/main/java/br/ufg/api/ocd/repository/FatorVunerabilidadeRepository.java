package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.FatorDeVunerabilidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatorVunerabilidadeRepository extends MongoRepository<FatorDeVunerabilidade, String> {
    public List<FatorDeVunerabilidade> findByIdTipoCancer(String idTipoCancer);

}
