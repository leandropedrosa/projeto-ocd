package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {

    public List<Paciente> findByNome(String nome);
}
