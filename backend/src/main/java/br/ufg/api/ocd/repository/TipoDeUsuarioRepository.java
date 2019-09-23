package br.ufg.api.ocd.repository;

import br.ufg.api.ocd.model.TipoDeUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeUsuarioRepository extends MongoRepository<TipoDeUsuario, String> {

    public TipoDeUsuario findByDescricao(String nome);
}
