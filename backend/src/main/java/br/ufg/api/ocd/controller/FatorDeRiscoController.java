package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.FatorDeRisco;
import br.ufg.api.ocd.service.FatorDeRiscoService;
import br.ufg.api.ocd.swagger.FatorDeRiscoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/fatorDeRisco")
public class FatorDeRiscoController implements FatorDeRiscoSwagger {

    @Autowired
    FatorDeRiscoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public Collection<FatorDeRisco> getAll() {
        logger.debug("Getting all fatorVunerabilidades.");
        return serv.getAll();
    }
}

