package br.ufg.api.ocd.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cidade")
@Data
@Builder
public class Cidade {
    @Id
    private String id;
    private String nome;

    @DBRef(lazy = true)
    private List<Bairro> bairros;
}

