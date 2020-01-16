package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.RegiaoBocaDTO;
import br.ufg.api.ocd.dto.TipoLesaoDTO;
import br.ufg.api.ocd.service.RegiaoBocaService;
import br.ufg.api.ocd.service.TipoLesaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/regiaoBoca")
public class RegiaoBocaController {

    @Autowired
    RegiaoBocaService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<RegiaoBocaDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, RegiaoBocaDTO.class))
                .collect(Collectors.toList());
    }
}
