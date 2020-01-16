package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.RegiaoBoca;
import br.ufg.api.ocd.repository.RegiaoBocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoBocaService {
    @Autowired
    private RegiaoBocaRepository repository;

    public List<RegiaoBoca> getAll() {
        return repository.findAll();
    }
}
