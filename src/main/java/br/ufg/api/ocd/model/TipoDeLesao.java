package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoLesao")
@Getter
@Setter
public class TipoDeLesao {
    @Id
    private String id;
    private String descricao;
}