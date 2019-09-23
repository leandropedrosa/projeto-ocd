package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.service.LocalAtendimentoService;
import br.ufg.api.ocd.swagger.LocalAtendimentoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/OCD/localDeAtendimento")
public class LocalAtendimentoController implements LocalAtendimentoSwagger {

    @Autowired
    LocalAtendimentoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/getAll")
    public Collection<LocalDeAtendimento> getAll() {
        logger.debug("Getting all ceos.");
        return serv.getAll();
    }
}

