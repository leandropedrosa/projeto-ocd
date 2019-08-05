package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.service.UsuarioService;
import br.ufg.api.ocd.swagger.UsuarioSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/OCD/usuario")
public class UsuarioController implements UsuarioSwagger {

    @Autowired
    UsuarioService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostMapping(value = "/create")
    public String create(@RequestBody Usuario usuario) {
        logger.debug("Salvando usuario...");
        serv.save(usuario);
        return "Usuário criado...";
    }

    @GetMapping(value = "/login/{email}/{senha}")
    public Usuario login(@PathVariable(value = "email") String email, @PathVariable(value = "senha") String senha) {
        logger.debug("Buscando todos os usuários...");
        return serv.findByEmailAndSenha(email, senha);
    }

    @GetMapping(value = "/esqueceuSenha/{email}")
    public Usuario esqueceuSenha(@PathVariable(value = "email") String email) {
        logger.debug("Obtendo usuários com id= {}...", email);
        return serv.findByEmail(email);
    }

    @PutMapping(value = "/updateSenha/{idUsuario}/{senha}")
    public String updateSenha(@PathVariable(value = "idUsuario") int idUsuario, @PathVariable(value = "senha") String senha) {
        Optional<Usuario> objeto = serv.findById(idUsuario);
        Usuario usuario = objeto.get();
        usuario.setSenha(senha);
        serv.update(usuario);
        return "Usuario record for usuario-id= " + usuario.getId() + " updated.";
    }
    @PutMapping(value = "/updateStatus/{idUsuario}")
    public String updateStatus(@PathVariable(value = "idUsuario") int idUsuario) {
        Optional<Usuario> objeto = serv.findById(idUsuario);
        Usuario usuario = objeto.get();
        usuario.setStatus("Ativo");
        serv.update(usuario);
        return "Usuario record for usuario-id= " + usuario.getId() + " updated.";
    }
}

