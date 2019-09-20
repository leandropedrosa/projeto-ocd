package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.service.UsuarioService;
import br.ufg.api.ocd.swagger.UsuarioSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/OCD/usuario")
public class UsuarioController implements UsuarioSwagger {

    @Autowired
    UsuarioService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/resetPassword/{cpf}")
    public Usuario esqueceuSenha(@PathVariable(value = "cpf") String cpf) {
        logger.debug("Obtendo usuários com id= {}...", cpf);
        return serv.findByCpf(cpf);
    }

    @PostMapping(value = "/authenticate")
    public Usuario loginBasic(@PathVariable(value = "cpf") String cpf,
                                 @PathVariable(value = "password") String password
    ) {
        return serv.findByCpfAndPassword(cpf,password);
    }
}

