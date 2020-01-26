package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Cidade;
import br.ufg.api.ocd.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;


    public List<Cidade> getAll() {
        return repository.findAll();
    }

    public List<Cidade> geByNome(String nome) {
        return repository.findByNome(nome);
    }

}
