package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Bairro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BairroRepository extends MongoRepository<Bairro, String> {

    public List<Bairro> findByNome(String nome);

}
