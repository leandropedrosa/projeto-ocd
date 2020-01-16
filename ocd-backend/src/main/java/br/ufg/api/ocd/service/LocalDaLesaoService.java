package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.LocalDaLesao;
import br.ufg.api.ocd.repository.LocalDaLesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalDaLesaoService {
    @Autowired
    private LocalDaLesaoRepository repository;

    public List<LocalDaLesao> getAll() {
        return repository.findAll();
    }
}
