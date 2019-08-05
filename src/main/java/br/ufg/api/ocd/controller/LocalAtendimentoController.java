package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.LocalAtendimento;
import br.ufg.api.ocd.service.LocalAtendimentoService;
import br.ufg.api.ocd.swagger.LocalAtendimentoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/OCD/ceo")
public class LocalAtendimentoController implements LocalAtendimentoSwagger {

    @Autowired
    LocalAtendimentoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/getAll")
    public Collection<LocalAtendimento> getAll() {
        logger.debug("Getting all ceos.");
        return serv.getAll();
    }
}

