package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Lesao;
import br.ufg.api.ocd.repository.LesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LesaoService {

    @Autowired
    private LesaoRepository repository;

    public void save(Lesao lesao) {
        repository.save(lesao);
    }


    public List<Lesao> getAll() {
        return repository.findAll();
    }


    public Optional<Lesao> findById(int id) {
        return repository.findById(id);
    }

    public List<Lesao> findByIdTipoLesao(int id) {
        return repository.findByIdTipoLesao(id);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }


    public void update(Lesao lesao) {
        repository.save(lesao);
    }


    public void deleteAll() {
        repository.deleteAll();
    }
}
