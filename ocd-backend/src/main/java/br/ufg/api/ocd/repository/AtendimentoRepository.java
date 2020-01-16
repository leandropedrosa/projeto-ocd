package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Atendimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends MongoRepository<Atendimento, String> {

    public List<Atendimento> findAllByPaciente_Nome(String nome);
}