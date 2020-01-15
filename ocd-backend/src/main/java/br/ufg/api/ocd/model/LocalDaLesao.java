package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "localDaLesao")
@Getter
@Setter
public class LocalDaLesao {
    @Id
    private String id;
    private Lesao lesao;
    private RegiaoBoca regiaoBoca;
    private AvaliacaoClinica avaliacaoClinica;
}
