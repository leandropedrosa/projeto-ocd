package br.ufg.api.ocd.service;

import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository repository;


    public Boolean save(Usuario usuario) {
        repository.save(usuario);
        logger.info("-- Usuario Salvo --");
        return true;
    }


    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario findByEmailAndSenha(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }

    public Optional<Usuario> findById(int id) {
        logger.info("-- Usuario Salvo --");
        return repository.findById(id);
    }

    public Boolean deleteById(int id) {
        repository.deleteById(id);
        logger.info("-- Acompanhamento Deletado --");
        return true;
    }


    public Boolean update(Usuario usuario) {
        repository.save(usuario);
        logger.info("-- Usuario atualizado --");
        return true;
    }


    public Boolean deleteAll() {
        repository.deleteAll();
        logger.info("-- Todos os Usuarios foram deletados --");
        return true;
    }

}
