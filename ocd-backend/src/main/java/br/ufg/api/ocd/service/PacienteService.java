package br.ufg.api.ocd.service;

import br.ufg.api.ocd.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;


    public List<Paciente> getAll() {
        return repository.findAll();
    }


    public Optional<Paciente> findById(String id) {
        return repository.findById(id);
    }

}
