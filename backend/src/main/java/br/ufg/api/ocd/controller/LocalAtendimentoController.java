package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.model.Rastreamento;
import br.ufg.api.ocd.service.LocalAtendimentoService;
import br.ufg.api.ocd.swagger.LocalAtendimentoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/localDeAtendimento")
public class LocalAtendimentoController implements LocalAtendimentoSwagger {

    @Autowired
    LocalAtendimentoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/regiao{regiao}")
    public Page<LocalDeAtendimento> getByRegiao(
            @RequestParam("regiao") String regiao,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return serv.findByRegiao(regiao, page, size);
    }
}

