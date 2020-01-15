package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "cidade")
@Getter
@Setter
public class Cidade {
    @Id
    private String id;
    private String nome;
}

