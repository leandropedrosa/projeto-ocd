package br.ufg.api.ocd.service;

import br.ufg.api.ocd.repository.RastreamentoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RastreamentoService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private RastreamentoRepository repository;


    public Rastreamento save(Rastreamento rastreamento) {
        logger.info("-- Acompanhamento Salvo --");
        return repository.save(rastreamento);
    }


    public List<Rastreamento> getAll() {
        return repository.findAll();
    }


    public Page<Rastreamento> findByIdUsuario(String idUsuario, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"nome");

        return repository.findByIdUsuario(idUsuario, pageRequest);
    }

    public Page<Rastreamento>  findByNomePaciente(String idUsuario, String nomePaciente, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"nome");

        return repository.findByIdUsuarioAndNomePaciente(idUsuario, nomePaciente, pageRequest);
    }

    public Optional<Rastreamento> findById(int id) {
        return repository.findById(id);
    }

    public Boolean update(Rastreamento rastreamento) {
        repository.save(rastreamento);
        logger.info("-- Acompanhamento atualizado --");
        return true;
    }

}
