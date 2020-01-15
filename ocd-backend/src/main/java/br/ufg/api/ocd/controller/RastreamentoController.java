package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.RastreamentoDTO;
import br.ufg.api.ocd.service.RastreamentoService;
import br.ufg.api.ocd.swagger.RastreamentoSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/rastreamento")
public class RastreamentoController implements RastreamentoSwagger {

    @Autowired
    RastreamentoService serv;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public String create(@RequestBody RastreamentoDTO rastreamentoDTO) {
        serv.save(modelMapper.map(rastreamentoDTO, Rastreamento.class));
        return "Rastreamento records created.";
    }

    @GetMapping("/getByUsuario")
    public Page<RastreamentoDTO> getByUsuario(@RequestParam("idUsuario") String idUsuario,
                                              @RequestParam(
                                                      value = "page",
                                                      required = false,
                                                      defaultValue = "0") int page,
                                              @RequestParam(
                                                      value = "size",
                                                      required = false,
                                                      defaultValue = "10") int size) {
        Page<Rastreamento> lista = serv.findByIdUsuario(idUsuario, page, size);
        return new PageImpl<RastreamentoDTO>(lista.stream()
                .map(post -> modelMapper.map(post, RastreamentoDTO.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/getByNomePaciente")
    public Page<RastreamentoDTO> getByNomePaciente(
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
        Page<Rastreamento> lista = serv.findByNomePaciente(idUsuario, nomePaciente, page, size);
        return new PageImpl<RastreamentoDTO>(lista.stream()
                .map(post -> modelMapper.map(post, RastreamentoDTO.class))
                .collect(Collectors.toList()));
    }
}

