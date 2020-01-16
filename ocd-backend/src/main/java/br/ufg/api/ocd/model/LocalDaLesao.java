package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "localDaLesao")
@Data
public class LocalDaLesao {
    @Id
    private String id;
    private Lesao lesao;
    private RegiaoBoca regiaoBoca;
    private AvaliacaoClinica avaliacaoClinica;

}
