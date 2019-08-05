package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.TipoDeLesao;
import br.ufg.api.ocd.repository.TipoDeLesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeLesaoService {

    @Autowired
    private TipoDeLesaoRepository repository;

    public void save(TipoDeLesao tipo) {
        repository.save(tipo);
    }


    public List<TipoDeLesao> getAll() {
        return repository.findAll();
    }


    public Optional<TipoDeLesao> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    public void update(TipoDeLesao tipo) {
        repository.save(tipo);
    }


    public void deleteAll() {
        repository.deleteAll();
    }

}
