package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Rastreamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RastreamentoRepository extends MongoRepository<Rastreamento, Integer> {
    Page<Rastreamento> findByIdUsuario(String idUsuario, Pageable pageable);
    Page<Rastreamento> findByIdUsuarioAndNomePaciente(String idUsuario, String nomePaciente, Pageable pageable);
}
