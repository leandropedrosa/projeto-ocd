package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.config.security.AuthenticationBean;
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
public class UsuarioController implements UsuarioSwagger {

    @Autowired
    UsuarioService serv;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/resetPassword/{cpf}")
    public UsuarioDTO esqueceuSenha(@PathVariable(value = "cpf") String cpf) {
        return modelMapper.map(serv.findByCpf(cpf), UsuarioDTO.class);
    }

    @GetMapping(value = "/getByCPF/{cpf}")
    public UsuarioDTO getByCpf(@RequestParam String cpf ) {
        return modelMapper.map(serv.findByCpf(cpf), UsuarioDTO.class);
    }

    @RequestMapping(value = "/login/{cpf}/{password}/{tipoAtencao}", method = RequestMethod.POST)
    public UsuarioDTO login(@PathVariable("cpf") String cpf, @PathVariable("password") String password, @PathVariable("tipoAtencao") String tipoAtencao){
        return modelMapper.map(serv.findByCpfAndPasswordAndTipoAtencao(cpf, password,tipoAtencao), UsuarioDTO.class);
    }

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

}

