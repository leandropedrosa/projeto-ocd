package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.LocalAtendimento;
import br.ufg.api.ocd.repository.LocalAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalAtendimentoService {

    @Autowired
    private LocalAtendimentoRepository repository;

    public void save(LocalAtendimento localAtendimento) {
        repository.save(localAtendimento);
    }


    public List<LocalAtendimento> getAll() {
        return repository.findAll();
    }


    public Optional<LocalAtendimento> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    public void update(LocalAtendimento localAtendimento) {
        repository.save(localAtendimento);
    }


    public void deleteAll() {
        repository.deleteAll();
    }
}
