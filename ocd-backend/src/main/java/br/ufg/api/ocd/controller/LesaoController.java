package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.LesaoDTO;
import br.ufg.api.ocd.service.LesaoService;
import br.ufg.api.ocd.swagger.LesaoSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/lesao")
public class LesaoController implements LesaoSwagger {

    @Autowired
    LesaoService serv;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<LesaoDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, LesaoDTO.class))
                .collect(Collectors.toList());
    }
}
