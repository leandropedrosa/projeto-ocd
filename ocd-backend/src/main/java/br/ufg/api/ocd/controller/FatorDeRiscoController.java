package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.FatoresDeRiscoDTO;
import br.ufg.api.ocd.service.FatorRiscoService;
import br.ufg.api.ocd.swagger.FatorDeRiscoSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/fatorDeRisco")
public class FatorDeRiscoController implements FatorDeRiscoSwagger {

    @Autowired
    FatorRiscoService serv;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<FatoresDeRiscoDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, FatoresDeRiscoDTO.class))
                .collect(Collectors.toList());
    }


}

