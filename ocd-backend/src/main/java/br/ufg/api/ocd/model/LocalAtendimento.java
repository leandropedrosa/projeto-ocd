package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "localAtendimento")
@Data
public class LocalAtendimento {
    @Id
    private String id;
    private String nome;
    private Distrito distrito;
    private TipoLocalAtendimento tipoLocalAtendimento;
}
