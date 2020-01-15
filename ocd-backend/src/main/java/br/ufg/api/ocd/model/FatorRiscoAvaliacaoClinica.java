package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "fatorRiscoAvaliacaoClinica")
@Getter
@Setter
public class FatorRiscoAvaliacaoClinica {
    @Id
    private String id;
    private FatorRisco fatorRisco;
    private AvaliacaoClinica avaliacaoClinica;

}
