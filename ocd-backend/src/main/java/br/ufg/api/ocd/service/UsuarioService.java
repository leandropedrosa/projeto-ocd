package br.ufg.api.ocd.service;

import br.ufg.api.ocd.dto.DadosIniciaisDTO;
import br.ufg.api.ocd.dto.LesaoDTO;
import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.model.ScriptsMobile;
import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.repository.RoleRepository;
import br.ufg.api.ocd.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.ufg.api.ocd.util.MD5Util.retornaMD5;

@Service
public class UsuarioService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ScriptsMobileService scriptsMobileService;

    public Usuario findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Usuario findByCpfAndPassword(String cpf, String password) {

        return repository.findByCpfAndSenha(cpf, retornaMD5(password));
    }

    public DadosIniciaisDTO getDadosInciais(String cpf){

        Usuario usuarioDB = repository.findByCpf(cpf);

        List<ScriptsMobile> scriptsDB = scriptsMobileService.findAll();

       return DadosIniciaisDTO.builder().usuario(modelMapper.map(usuarioDB, UsuarioDTO.class)).scriptsIniciais(scriptsDB).build();
    }
}
