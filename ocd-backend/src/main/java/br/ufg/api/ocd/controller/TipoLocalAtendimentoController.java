package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.FatoresDeRiscoDTO;
import br.ufg.api.ocd.dto.TipoLocalAtendimentoDTO;
import br.ufg.api.ocd.service.TipoLocalAtendimentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/tipoLocalAtendimento")
public class TipoLocalAtendimentoController {
    
    @Autowired
    TipoLocalAtendimentoService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/getByNome/{nome}")
    public List<TipoLocalAtendimentoDTO> getByNome(String nome) {
        return serv.geByNome(nome).stream()
                .map(post -> modelMapper.map(post, TipoLocalAtendimentoDTO.class))
                .collect(Collectors.toList());
    }
}
