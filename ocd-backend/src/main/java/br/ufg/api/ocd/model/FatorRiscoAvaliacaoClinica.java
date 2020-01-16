package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fatorRiscoAvaliacaoClinica")
@Data
public class FatorRiscoAvaliacaoClinica {
    @Id
    private String id;
    private FatorRisco fatorRisco;
    private AvaliacaoClinica avaliacaoClinica;

}
