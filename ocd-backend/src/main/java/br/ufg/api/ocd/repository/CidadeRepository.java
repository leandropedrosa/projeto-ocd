package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Cidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {

    public List<Cidade> findByNome(String nome);

}
