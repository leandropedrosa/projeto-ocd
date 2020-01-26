package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.AvaliacaoClinica;
import br.ufg.api.ocd.repository.AvaliacaoClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoClinicaService {

    @Autowired
    private AvaliacaoClinicaRepository repository;

    public AvaliacaoClinica salvar(AvaliacaoClinica AvaliacaoClinica) {
        return repository.save(AvaliacaoClinica);
    }

    public List<AvaliacaoClinica> salvarTodos(List<AvaliacaoClinica> AvaliacaoClinicas) {
        return repository.saveAll(AvaliacaoClinicas);
    }
}
