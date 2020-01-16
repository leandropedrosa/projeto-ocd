package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.TipoLesao;
import br.ufg.api.ocd.repository.TipoLesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoLesaoService {

    @Autowired
    private TipoLesaoRepository repository;

    public List<TipoLesao> getAll() {
        return repository.findAll();
    }


}
