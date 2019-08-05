package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.TipoDeCancer;
import br.ufg.api.ocd.service.TipoDeCancerService;
import br.ufg.api.ocd.swagger.TipoDeCancerSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/OCD/tipoCancer")
public class TipoDeCancerController implements TipoDeCancerSwagger {

    @Autowired
    TipoDeCancerService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/getAll")
    public Collection<TipoDeCancer> getAll() {
        logger.debug("Getting all tipoCancers.");
        return serv.getAll();
    }
}

