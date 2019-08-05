package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.HistoricoAcesso;
import br.ufg.api.ocd.repository.HistoricoAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoAcessoService {

    @Autowired
    private HistoricoAcessoRepository repository;

    public void save(HistoricoAcesso historico) {
        repository.save(historico);
    }


    public List<HistoricoAcesso> getAll() {
        return repository.findAll();
    }


    public Optional<HistoricoAcesso> findById(int id) {
        return repository.findById(id);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }


    public void update(HistoricoAcesso historico) {
        repository.save(historico);
    }


    public void deleteAll() {
        repository.deleteAll();
    }
}
