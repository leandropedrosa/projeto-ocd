package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.CidadeDTO;
import br.ufg.api.ocd.service.CidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/cidade")
public class CidadeController {

    @Autowired
    CidadeService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CidadeDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, CidadeDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/getByNome/{nome}")
    public List<CidadeDTO> geByNome(String nome) {
        return serv.geByNome(nome).stream()
                .map(post -> modelMapper.map(post, CidadeDTO.class))
                .collect(Collectors.toList());
    }
}
