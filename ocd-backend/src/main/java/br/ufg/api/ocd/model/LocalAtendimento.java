package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "localAtendimento")
@Getter
@Setter


public class LocalAtendimento {
    @Id
    private String id;
    private String nome;
    private Distrito distrito;
    private TipoLocalAtendimento tipoLocalAtendimento;
}
