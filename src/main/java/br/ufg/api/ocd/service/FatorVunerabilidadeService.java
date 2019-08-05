package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.FatorVunerabilidade;
import br.ufg.api.ocd.repository.FatorVunerabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FatorVunerabilidadeService {

    @Autowired
    private FatorVunerabilidadeRepository repository;

    public void save(FatorVunerabilidade fator) {
        repository.save(fator);
    }


    public List<FatorVunerabilidade> getAll() {
        return repository.findAll();
    }

    public List<FatorVunerabilidade> findByIdTipoCancer(String idTipoCancer) {
        return repository.findByIdTipoCancer(idTipoCancer);
    }

    public Optional<FatorVunerabilidade> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    public void update(FatorVunerabilidade fator) {
        repository.save(fator);
    }


    public void deleteAll() {
        repository.deleteAll();
    }
}
