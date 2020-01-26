package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "avaliacaoClinica")
@Data
public class AvaliacaoClinica {
    @Id
    private String id;
    private Boolean usuarioSeraEncaminhado;
    private Atendimento atendimento;

    @DBRef(lazy = true)
    private List<FatorRiscoAvaliacaoClinica> fatorRiscoAvaliacaoClinicas;

    @DBRef(lazy = true)
    private List<LocalDaLesao> localDasLesaos;



}
