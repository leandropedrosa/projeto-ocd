package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.Lesao;
import br.ufg.api.ocd.service.LesaoService;
import br.ufg.api.ocd.swagger.LesaoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/lesao")
public class LesaoController implements LesaoSwagger {

    @Autowired
    LesaoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public Collection<Lesao> getAll() {
        logger.debug("Getting all lesaos.");
        return serv.getAll();
    }
}

