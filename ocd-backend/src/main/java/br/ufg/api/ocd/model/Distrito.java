package br.ufg.api.ocd.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "distrito")
@Data
@Builder
public class Distrito {
    @Id
    private String id;
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String nome;
    private Bairro bairro;

    @DBRef(lazy = true)
    private List<LocalAtendimento> locaisDeAtendimento;
}
