package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Distrito;
import br.ufg.api.ocd.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {
    @Autowired
    private DistritoRepository repository;

    public List<Distrito> getAll() {
        return repository.findAll();
    }

    public List<Distrito> geByNome(String nome) {
        return repository.findByNome(nome);
    }
}
