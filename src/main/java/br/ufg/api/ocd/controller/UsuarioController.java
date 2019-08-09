package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.service.UsuarioService;
import br.ufg.api.ocd.swagger.UsuarioSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/OCD/usuario")
public class UsuarioController implements UsuarioSwagger {

    @Autowired
    UsuarioService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/login/{cpf}/{senha}")
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
    public String updateSenha(@PathVariable(value = "idUsuario") String idUsuario, @PathVariable(value = "senha") String senha) {
        Optional<Usuario> objeto = serv.findById(idUsuario);
        Usuario usuario = objeto.get();
        usuario.setSenha(senha);
        serv.update(usuario);
        return "Usuario record for usuario-id= " + usuario.getId() + " updated.";
    }
    @PutMapping(value = "/updateStatus/{idUsuario}")
    public String updateStatus(@PathVariable(value = "idUsuario") String idUsuario) {
        Optional<Usuario> objeto = serv.findById(idUsuario);
        Usuario usuario = objeto.get();
        usuario.setStatus("Ativo");
        serv.update(usuario);
        return "Usuario record for usuario-id= " + usuario.getId() + " updated.";
    }
}

