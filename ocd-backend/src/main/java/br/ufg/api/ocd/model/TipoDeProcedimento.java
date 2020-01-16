package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoDeProcedimento")
@Data
public class TipoDeProcedimento {
    @Id
    private String id;
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String nome;
}
