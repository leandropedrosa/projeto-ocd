package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.FatorDeVunerabilidade;
import br.ufg.api.ocd.service.FatorVunerabilidadeService;
import br.ufg.api.ocd.swagger.FatorVunerabilidadeSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/OCD/fatorVunerabilidade")
public class FatorVunerabilidadeController implements FatorVunerabilidadeSwagger {

    @Autowired
    FatorVunerabilidadeService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/getByTipoCancer")
    public Collection<FatorDeVunerabilidade> getByTipoCancer(@PathVariable(value = "idTipoCancer") String idTipoCancer) {
        logger.debug("Getting all fatorVunerabilidades.");
        return serv.findByIdTipoCancer(idTipoCancer);
    }
}

