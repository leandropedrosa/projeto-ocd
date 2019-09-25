package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Lesao;
import br.ufg.api.ocd.repository.LesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LesaoService {

    @Autowired
    private LesaoRepository repository;

    public List<Lesao> getAll() {
        return repository.findAll();
    }

}
