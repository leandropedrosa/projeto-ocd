package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.LocalAtendimentoDTO;
import br.ufg.api.ocd.swagger.LocalAtendimentoSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/localDeAtendimento")
public class LocalAtendimentoController implements LocalAtendimentoSwagger {

    @Autowired
    LocalAtendimentoService serv;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping(value = "/regiao/{regiao}")
    public List<LocalAtendimentoDTO> getByRegiao(
            @RequestParam("regiao") String regiao) {
        return serv.findByRegiao(regiao).stream()
                .map(post -> modelMapper.map(post, LocalAtendimentoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/all")
    public List<LocalAtendimentoDTO> getAll() {
        return serv.getAll().stream()
                .map(post -> modelMapper.map(post, LocalAtendimentoDTO.class))
                .collect(Collectors.toList());
    }
}

