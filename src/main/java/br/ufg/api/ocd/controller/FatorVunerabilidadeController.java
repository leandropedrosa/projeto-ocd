package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.FatorVunerabilidade;
import br.ufg.api.ocd.service.FatorVunerabilidadeService;
import br.ufg.api.ocd.swagger.FatorVunerabilidadeSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/OCD/fatorVunerabilidade")
public class FatorVunerabilidadeController implements FatorVunerabilidadeSwagger {

    @Autowired
    FatorVunerabilidadeService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/getByTipoCancer")
    public Collection<FatorVunerabilidade> getByTipoCancer(@PathVariable(value = "idTipoCancer") Integer idTipoCancer) {
        logger.debug("Getting all fatorVunerabilidades.");
        return serv.findByIdTipoCancer(idTipoCancer);
    }
}

