package br.ufg.api.ocd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocalAtendimentoRepository extends MongoRepository<LocalDeAtendimento, String> {
    List<LocalDeAtendimento> findByRegiao(String regiao);
}
