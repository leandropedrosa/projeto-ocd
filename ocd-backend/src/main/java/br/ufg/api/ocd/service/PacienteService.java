package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Paciente;
import br.ufg.api.ocd.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> geByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

}
