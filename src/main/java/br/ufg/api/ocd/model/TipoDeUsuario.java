package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoDeUsuario")
@Getter
@Setter
public class TipoDeUsuario {
    public TipoDeUsuario(String descricao) {
        this.descricao = descricao;
    }

    public TipoDeUsuario() {
    }

    @Id
    private String id;
    private String descricao;
}