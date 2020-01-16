package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.FatoresDeRiscoDTO;
import br.ufg.api.ocd.dto.TipoRegiaoDTO;
import br.ufg.api.ocd.service.TipoRegiaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/tipoRegiao")
public class TipoRegiaoController {

    @Autowired
    TipoRegiaoService serv;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<TipoRegiaoDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, TipoRegiaoDTO.class))
                .collect(Collectors.toList());
    }
}
