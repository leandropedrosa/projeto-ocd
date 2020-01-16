package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.BairroDTO;
import br.ufg.api.ocd.service.BairroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/bairro")
public class BairroController {

    @Autowired
    BairroService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<BairroDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, BairroDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/getByNome/{nome}")
    public List<BairroDTO> geByNome(String nome) {
        return serv.geByNome(nome).stream()
                .map(post -> modelMapper.map(post, BairroDTO.class))
                .collect(Collectors.toList());
    }
}
