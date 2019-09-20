package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.FatorDeRisco;
import br.ufg.api.ocd.repository.FatorDeRiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FatorDeRiscoService {

    @Autowired
    private FatorDeRiscoRepository repository;

    public List<FatorDeRisco> getAll() {
        return repository.findAll();
    }

}
