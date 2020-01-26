package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.LocalDaLesaoDTO;
import br.ufg.api.ocd.service.LocalDaLesaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/localDaLesao")
public class LocalDaLesaoController {

    @Autowired
    LocalDaLesaoService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<LocalDaLesaoDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, LocalDaLesaoDTO.class))
                .collect(Collectors.toList());
    }
}
