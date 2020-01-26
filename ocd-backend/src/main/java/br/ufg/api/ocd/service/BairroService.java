package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Bairro;
import br.ufg.api.ocd.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BairroService {

    @Autowired
    private BairroRepository repository;


    public List<Bairro> getAll() {
        return repository.findAll();
    }

    public List<Bairro> geByNome(String nome) {
        return repository.findByNome(nome);
    }

}
