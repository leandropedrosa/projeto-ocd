package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.model.Rastreamento;
import br.ufg.api.ocd.repository.LocalAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalAtendimentoService {

    @Autowired
    private LocalAtendimentoRepository repository;


    public List<LocalDeAtendimento> getAll() {
        return repository.findAll();
    }


    public Page<LocalDeAtendimento> findByRegiao(String regiao, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"nome");

        return repository.findByRegiao(regiao, pageRequest);
    }

}
