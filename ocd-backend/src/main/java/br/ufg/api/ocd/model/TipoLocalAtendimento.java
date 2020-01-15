package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "tipoLocalAtendimento")
@Getter
@Setter
public class TipoLocalAtendimento {
    @Id
    private String id;
    private String nome;
}
