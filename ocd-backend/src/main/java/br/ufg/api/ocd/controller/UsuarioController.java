package br.ufg.api.ocd.controller;

import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.service.UsuarioService;
import br.ufg.api.ocd.swagger.UsuarioSwagger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController implements UsuarioSwagger {

    @Autowired
    UsuarioService serv;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/resetPassword/{cpf}")
    public UsuarioDTO esqueceuSenha(@PathVariable(value = "cpf") String cpf) {
        return modelMapper.map(serv.findByCpf(cpf), UsuarioDTO.class);
    }

    @PostMapping(value = "/authenticate/{user}")
    public UsuarioDTO loginBasic(@PathVariable(value = "user") UsuarioDTO user) {
        return modelMapper.map(serv.findByCpfAndPassword(user.getCpf(), user.getPassword()), UsuarioDTO.class);
    }
}

