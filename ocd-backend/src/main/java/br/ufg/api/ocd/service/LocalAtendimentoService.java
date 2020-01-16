package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.LocalAtendimento;
import br.ufg.api.ocd.repository.LocalAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalAtendimentoService {

    @Autowired
    private LocalAtendimentoRepository repository;

    public List<LocalAtendimento> getAll() {

        return repository.findAll();
    }

    public List<LocalAtendimento> geByNome(String nome) {

        return repository.findByNome(nome);
    }

    public List<LocalAtendimento> geByTipoLocalAtendimento(String nome) {

        return repository.findByAndTipoLocalAtendimento_Nome(nome);
    }

    public List<LocalAtendimento> geByDistrito(String nome) {

        return repository.findByDistrito_Nome(nome);
    }
}
