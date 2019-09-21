package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.LocalAtendimentoDTO;
import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.service.LocalAtendimentoService;
import br.ufg.api.ocd.swagger.LocalAtendimentoSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/localDeAtendimento")
public class LocalAtendimentoController implements LocalAtendimentoSwagger {

    @Autowired
    LocalAtendimentoService serv;

    private ModelMapper modelMapper = new ModelMapper();


    @GetMapping(value = "/regiao/{regiao}")
    public Page<LocalAtendimentoDTO> getByRegiao(
            @RequestParam("regiao") String regiao,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {

        return new PageImpl<LocalAtendimentoDTO>(serv.findByRegiao(regiao, page, size).stream()
                .map(post -> modelMapper.map(post, LocalAtendimentoDTO.class))
                .collect(Collectors.toList()));
    }
}

