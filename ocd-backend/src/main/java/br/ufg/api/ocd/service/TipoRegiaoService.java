package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.TipoRegiao;
import br.ufg.api.ocd.repository.TipoRegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoRegiaoService {

    @Autowired
    private TipoRegiaoRepository repository;

    public List<TipoRegiao> getAll() {
        return repository.findAll();
    }


}
