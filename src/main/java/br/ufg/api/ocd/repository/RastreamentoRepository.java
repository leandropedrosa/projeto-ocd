package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Rastreamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RastreamentoRepository extends MongoRepository<Rastreamento, Integer> {
    Page<Rastreamento> findByIdUsuario(Integer idUsuario, Pageable pageable);
    Page<Rastreamento> findByIdUsuarioAndNomePaciente(Integer idUsuario, String nomePaciente, Pageable pageable);
}
