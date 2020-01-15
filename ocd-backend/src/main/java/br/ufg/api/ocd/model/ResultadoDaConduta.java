package br.ufg.api.ocd.model;

import java.sql.Blob;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "resultadoDaConduta")
@Getter
@Setter
public class ResultadoDaConduta {
    @Id
    private String id;
    private Blob anexo;
    private String observacao;
    private TipoDeProcedimento tipoDeProcedimento;
    private Encaminhamento encaminhamento;

}
