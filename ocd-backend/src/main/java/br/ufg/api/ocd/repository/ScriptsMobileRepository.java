package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.ScriptsMobile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScriptsMobileRepository extends MongoRepository<ScriptsMobile, String> {

    public List<ScriptsMobile> findByVersaoBanco_Descricao(String descricao);
}
