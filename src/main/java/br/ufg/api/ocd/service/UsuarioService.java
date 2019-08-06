package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Role;
import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.repository.RoleRepository;
import br.ufg.api.ocd.repository.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Boolean save(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.setStatus("Esperando Ativação");
        Role userRole = roleRepository.findByName("ADM");
        usuario.setRoles(Arrays.asList(userRole));
        repository.save(usuario);
        logger.info("-- Usuario Salvo --");
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = repository.findByEmail(email);
        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(List<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSenha(), authorities);
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario findByEmailAndSenha(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }

    public Optional<Usuario> findById(String id) {
        logger.info("-- Usuario Salvo --");
        return repository.findById(id);
    }

    public Boolean deleteById(String id) {
        repository.deleteById(id);
        logger.info("-- Acompanhamento Deletado --");
        return true;
    }


    public Boolean update(Usuario usuario) {
        repository.save(usuario);
        logger.info("-- Usuario atualizado --");
        return true;
    }


    public Boolean deleteAll() {
        repository.deleteAll();
        logger.info("-- Todos os Usuarios foram deletados --");
        return true;
    }

}
