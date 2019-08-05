package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.TipoDeCancer;
import br.ufg.api.ocd.repository.TipoDeCancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeCancerService {

    @Autowired
    private TipoDeCancerRepository repository;

    public void save(TipoDeCancer tipo) {
        repository.save(tipo);
    }


    public List<TipoDeCancer> getAll() {
        return repository.findAll();
    }


    public Optional<TipoDeCancer> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    public void update(TipoDeCancer tipo) {
        repository.save(tipo);
    }


    public void deleteAll() {
        repository.deleteAll();
    }

}
