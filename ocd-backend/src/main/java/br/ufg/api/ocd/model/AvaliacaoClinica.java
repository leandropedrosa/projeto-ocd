package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "avaliacaoClinica")
@Getter
@Setter
public class AvaliacaoClinica {
    @Id
    private String id;
    private Boolean usuarioSeraEncaminhado;
    private Atendimento atendimento;

}
