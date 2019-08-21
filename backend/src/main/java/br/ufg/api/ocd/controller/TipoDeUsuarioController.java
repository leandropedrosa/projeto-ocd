package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.TipoDeUsuario;
import br.ufg.api.ocd.service.TipoDeUsuarioService;
import br.ufg.api.ocd.swagger.TipoUsuarioSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/OCD/tipoProfissional")
public class TipoDeUsuarioController implements TipoUsuarioSwagger {

    @Autowired
    TipoDeUsuarioService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/getAll")
    public Collection<TipoDeUsuario> getAll() {
        logger.debug("Getting all tipoProfissionals.");
        return serv.getAll();
    }
}

