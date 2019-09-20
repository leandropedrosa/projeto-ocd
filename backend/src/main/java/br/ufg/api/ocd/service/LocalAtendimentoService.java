package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.repository.LocalAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalAtendimentoService {

    @Autowired
    private LocalAtendimentoRepository repository;

    public void save(LocalDeAtendimento localDeAtendimento) {
        repository.save(localDeAtendimento);
    }


    public List<LocalDeAtendimento> getAll() {
        return repository.findAll();
    }


    public Optional<LocalDeAtendimento> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    public void update(LocalDeAtendimento localDeAtendimento) {
        repository.save(localDeAtendimento);
    }


    public void deleteAll() {
        repository.deleteAll();
    }
}
