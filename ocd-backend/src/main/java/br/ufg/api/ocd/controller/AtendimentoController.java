package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.AtendimentoDTO;
import br.ufg.api.ocd.dto.LocalAtendimentoDTO;
import br.ufg.api.ocd.model.Atendimento;
import br.ufg.api.ocd.service.AtendimentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoService serv;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/geByNomePaciente/{nomePaciente}")
    public List<AtendimentoDTO> geByNomePaciente(@RequestParam("nomePaciente") String nomePaciente) {
        return serv.geByNomePaciente(nomePaciente).stream()
                .map(post -> modelMapper.map(post, AtendimentoDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/salvar/{atendimento}")
    public AtendimentoDTO salvar(@RequestBody AtendimentoDTO atendimento) {
        Atendimento atendimentoDB = serv.salvar(modelMapper.map(atendimento, Atendimento.class));
        return modelMapper.map(atendimentoDB, AtendimentoDTO.class);

    }
}
