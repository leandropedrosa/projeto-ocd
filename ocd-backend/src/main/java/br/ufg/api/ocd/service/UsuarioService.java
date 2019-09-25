package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Role;
import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.repository.RoleRepository;
import br.ufg.api.ocd.repository.UsuarioRepository;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class UsuarioService{// implements UserDetailsService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    public Boolean save(Usuario usuario) {
        usuario.setPassword(retornaMD5(usuario.getPassword()));
        usuario.setStatus("Esperando Ativação");
        Role userRole = roleRepository.findByName("USER");
        //usuario.setRoles(new HashSet<>(Arrays.asList(userRole)));
        repository.save(usuario);
        logger.info("-- Usuario Salvo --");
        return true;
    }
/*
    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario user = repository.findByCpf(cpf);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));

        return new User(user.getCpf(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
*/
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario findByCpf(String email) {
        return repository.findByCpf(email);
    }

    public Usuario findByCpfAndPassword(String cpf, String password) {
        return repository.findByCpfAndPassword(cpf, retornaMD5(password));
    }

    public Optional<Usuario> findById(String id) {
        logger.info("-- Usuario Salvo --");
        return repository.findById(id);
    }

    private static String retornaMD5(String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
}
