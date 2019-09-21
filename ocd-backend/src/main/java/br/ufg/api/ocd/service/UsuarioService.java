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
import org.springframework.security.crypto.password.PasswordEncoder;
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
    PasswordEncoder passwordEncoder;

    public Boolean save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setStatus("Esperando Ativação");
        Role userRole = roleRepository.findByName("USER");
        //usuario.setRoles(new HashSet<>(Arrays.asList(userRole)));
        repository.save(usuario);
        logger.info("-- Usuario Salvo --");
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Usuario user = repository.findByCpf(cpf);
        if(user != null) {
            List<GrantedAuthority> authorities = null;
            //List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getCpf(), user.getPassword(), authorities);
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario findByCpf(String email) {
        return repository.findByCpf(email);
    }

    public Usuario findByCpfAndPassword(String cpf, String password) {
        return repository.findByCpfAndPassword(cpf, passwordEncoder.encode(password));
    }

    public Optional<Usuario> findById(String id) {
        logger.info("-- Usuario Salvo --");
        return repository.findById(id);
    }

    public Boolean update(Usuario usuario) {
        repository.save(usuario);
        logger.info("-- Usuario atualizado --");
        return true;
    }


}
