package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoDeCancer")
@Getter
@Setter
public class TipoDeCancer {

    public TipoDeCancer(String descricao) {
        this.descricao = descricao;
    }

    public TipoDeCancer() {
    }
    @Id
    private String id;
    private String descricao;
}