package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.model.Rastreamento;
import br.ufg.api.ocd.service.RastreamentoService;
import br.ufg.api.ocd.swagger.RastreamentoSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/acompanhamento")
public class RastreamentoController implements RastreamentoSwagger {

    @Autowired
    RastreamentoService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public String create(@RequestBody Rastreamento rastreamento) {
        logger.debug("Saving acompanhamento.");
        serv.save(rastreamento);
        return "Usuário records created.";
    }

    @GetMapping("/getByUsuario")
    public Page<Rastreamento> getByUsuario(@RequestParam("idUsuario") String idUsuario,
                                     @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
                                    @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return serv.findByIdUsuario(idUsuario, page, size);
    }

    @GetMapping("/getByNomePaciente")
    public Page<Rastreamento> getByNomePaciente(
                                           @RequestParam("idUsuario") String idUsuario,
                                           @RequestParam("nomePaciente") String nomePaciente,
                                           @RequestParam(
                                                   value = "page",
                                                   required = false,
                                                   defaultValue = "0") int page,
                                           @RequestParam(
                                                   value = "size",
                                                   required = false,
                                                   defaultValue = "10") int size) {
        return serv.findByNomePaciente(idUsuario, nomePaciente, page, size);
    }
}

