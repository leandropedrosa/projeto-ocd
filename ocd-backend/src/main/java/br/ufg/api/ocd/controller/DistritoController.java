package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.DistritoDTO;
import br.ufg.api.ocd.service.DistritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/distrito")
public class DistritoController {
    @Autowired
    DistritoService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/getByNome/{nome}")
    public List<DistritoDTO> getByNome(String nome) {
        return serv.geByNome(nome).stream()
                .map(post -> modelMapper.map(post, DistritoDTO.class))
                .collect(Collectors.toList());
    }
}
