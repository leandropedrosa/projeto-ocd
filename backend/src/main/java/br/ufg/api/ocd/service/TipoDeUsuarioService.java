package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.TipoDeUsuario;
import br.ufg.api.ocd.repository.TipoDeUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeUsuarioService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private TipoDeUsuarioRepository repository;


    public Boolean save(TipoDeUsuario tipoDeUsuario) {
        repository.save(tipoDeUsuario);
        logger.info("-- TipoDeUsuario Salvo --");
        return true;
    }


    public List<TipoDeUsuario> getAll() {
        return repository.findAll();
    }


    public Optional<TipoDeUsuario> findById(String id) {
        logger.info("-- TipoDeUsuario Salvo --");
        return repository.findById(id);
    }

    public Boolean deleteById(String id) {
        repository.deleteById(id);
        logger.info("-- Acompanhamento Deletado --");
        return true;
    }


    public Boolean update(TipoDeUsuario usuario) {
        repository.save(usuario);
        logger.info("-- TipoDeUsuario atualizado --");
        return true;
    }


    public Boolean deleteAll() {
        repository.deleteAll();
        logger.info("-- Todos os TipoDeUsuarios foram deletados --");
        return true;
    }

}
