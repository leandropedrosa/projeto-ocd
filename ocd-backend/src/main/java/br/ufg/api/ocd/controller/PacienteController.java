package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.PacienteDTO;
import br.ufg.api.ocd.service.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/paciente")
public class PacienteController {

    @Autowired
    PacienteService serv;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/getByNome/{nome}")
    public List<PacienteDTO> getByNome(
            @RequestParam("nome") String nome) {
        return serv.geByNome(nome).stream()
                .map(post -> modelMapper.map(post, PacienteDTO.class))
                .collect(Collectors.toList());
    }
}
