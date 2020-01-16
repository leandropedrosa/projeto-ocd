package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    public Usuario findByCpfAndSenha(String cpf, String senha);
    public Usuario findByCpf(String cpf);
}
