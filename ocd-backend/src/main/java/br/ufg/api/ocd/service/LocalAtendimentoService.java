package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.repository.LocalAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalAtendimentoService {

    @Autowired
    private LocalAtendimentoRepository repository;


    public List<LocalDeAtendimento> getAll() {
        return repository.findAll();
    }


    public List<LocalDeAtendimento> findByRegiao(String regiao) {

        return repository.findByRegiao(regiao);
    }

}
