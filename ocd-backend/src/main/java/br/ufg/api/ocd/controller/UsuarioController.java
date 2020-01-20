package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.config.security.AuthenticationBean;
import br.ufg.api.ocd.dto.DadosIniciaisDTO;
import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.service.UsuarioService;
import br.ufg.api.ocd.swagger.UsuarioSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService serv;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/getByCPF/{cpf}")
    public UsuarioDTO getByCpf(@RequestParam String cpf) {
        return modelMapper.map(serv.findByCpf(cpf), UsuarioDTO.class);
    }

    @PostMapping(value = "/getDadosInciais/{cpf}")
    public DadosIniciaisDTO getDadosIniciais(@RequestParam String cpf) {
        return serv.getDadosInciais(cpf);
    }

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

}

