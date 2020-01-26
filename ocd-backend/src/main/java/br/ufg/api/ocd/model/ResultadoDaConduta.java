package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;


@Document(collection = "resultadoDaConduta")
@Data
public class ResultadoDaConduta {
    @Id
    private String id;
    private File anexo;
    private String observacao;
    private TipoDeProcedimento tipoDeProcedimento;
    private Encaminhamento encaminhamento;

}
