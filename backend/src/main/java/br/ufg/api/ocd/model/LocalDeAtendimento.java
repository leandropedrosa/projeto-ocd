package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "localDeAtendimento")
@Getter
@Setter
public class LocalDeAtendimento {

    public LocalDeAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public LocalDeAtendimento() {
    }

    @Id
    private String id;
    private String descricao;
    private String endereco;
    private String fone;
}