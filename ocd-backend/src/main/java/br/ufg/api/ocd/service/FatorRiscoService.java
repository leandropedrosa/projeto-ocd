package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.FatorRisco;
import br.ufg.api.ocd.repository.FatorRiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatorRiscoService {

    @Autowired
    private FatorRiscoRepository repository;


    public List<FatorRisco> getAll() {
        return repository.findAll();
    }

    public List<FatorRisco> geByNome(String nome) {
        return repository.findByNome(nome);
    }

}
