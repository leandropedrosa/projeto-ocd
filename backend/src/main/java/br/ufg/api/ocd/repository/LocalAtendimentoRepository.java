package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.model.Rastreamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalAtendimentoRepository extends MongoRepository<LocalDeAtendimento, String> {
    Page<LocalDeAtendimento> findByRegiao(String regiao, Pageable pageable);
}
