package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.TipoLocalAtendimento;
import br.ufg.api.ocd.repository.TipoLocalAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoLocalAtendimentoService {

    @Autowired
    private TipoLocalAtendimentoRepository repository;

    public List<TipoLocalAtendimento> getAll() {
        return repository.findAll();
    }

    public List<TipoLocalAtendimento> geByNome(String nome) {
        return repository.findByNome(nome);
    }
}
