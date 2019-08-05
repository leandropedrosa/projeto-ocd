package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "lesao")
@Getter
@Setter
public class Lesao {
    @Id
    private String id;
    private String idTipoLesao;
    private String nome;
}