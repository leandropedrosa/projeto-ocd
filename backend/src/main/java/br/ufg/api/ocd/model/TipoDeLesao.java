package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoDeLesao")
@Getter
@Setter
public class TipoDeLesao {

    public TipoDeLesao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDeLesao() {
    }

    @Id
    private String id;
    private String descricao;
}