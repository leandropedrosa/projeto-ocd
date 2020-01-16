package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Diagnostico;
import br.ufg.api.ocd.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository repository;

    public Diagnostico salvar(Diagnostico diagnostico) {
        return repository.save(diagnostico);
    }

    public List<Diagnostico> salvarTodos(List<Diagnostico> diagnosticos) {
        return repository.saveAll(diagnosticos);
    }

}
