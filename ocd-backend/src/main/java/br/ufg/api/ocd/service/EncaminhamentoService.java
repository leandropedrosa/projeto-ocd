package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Encaminhamento;
import br.ufg.api.ocd.repository.EncaminhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncaminhamentoService {
    @Autowired
    private EncaminhamentoRepository repository;

    public Encaminhamento salvar(Encaminhamento Encaminhamento) {
        return repository.save(Encaminhamento);
    }

    public List<Encaminhamento> salvarTodos(List<Encaminhamento> Encaminhamentos) {
        return repository.saveAll(Encaminhamentos);
    }
}
