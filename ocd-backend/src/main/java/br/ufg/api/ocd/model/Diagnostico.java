package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "diagnostico")
@Getter
@Setter
public class Diagnostico {
    @Id
    private String id;
    private String hipoteseDiagnostico;
    private Boolean confirmaRastreamento;
    private String observacao;
    private Atendimento atendimento;

}
