package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.TipoDeLesao;
import br.ufg.api.ocd.service.TipoDeLesaoService;
import br.ufg.api.ocd.swagger.TipoDeLesaoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/OCD/tipoLesao")
public class TipoDeLesaoController implements TipoDeLesaoSwagger {

    @Autowired
    TipoDeLesaoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/getAll")
    public Collection<TipoDeLesao> getAll() {
        logger.debug("Getting all tipoLesaos.");
        return serv.getAll();
    }

}

