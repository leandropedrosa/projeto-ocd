package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cidade")
@Data
public class Cidade {
    @Id
    private String id;
    private String nome;

    @DBRef(lazy = true)
    private List<Bairro> bairros;
}

