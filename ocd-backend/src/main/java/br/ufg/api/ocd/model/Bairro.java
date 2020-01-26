package br.ufg.api.ocd.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bairro")
@Data
@Builder
public class Bairro {
    @Id
    private String id;
   // @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String nome;
    private Cidade cidade;

}
