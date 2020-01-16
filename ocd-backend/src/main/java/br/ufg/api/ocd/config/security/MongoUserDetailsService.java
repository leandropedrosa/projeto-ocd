package br.ufg.api.ocd.config.security;

import br.ufg.api.ocd.model.Usuario;
import br.ufg.api.ocd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario user = repository.findByCpf(cpf);
        List<SimpleGrantedAuthority> authorities = null;
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        if (user.getCpf().equals("admin")) {
            authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
        } else {
            authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
        }
        return new User(user.getCpf(), user.getSenha(), authorities);
    }

}