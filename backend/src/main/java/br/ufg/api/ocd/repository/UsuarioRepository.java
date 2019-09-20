package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    public Usuario findByCpfAndPassword(String cpf, String password);
    public Usuario findByCpf(String cpf);
}
