package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;


@Document(collection = "resultadoDaConduta")
@Getter
@Setter
public class ResultadoDaConduta {
    @Id
    private String id;
    private File anexo;
    private String observacao;
    private TipoDeProcedimento tipoDeProcedimento;
    private Encaminhamento encaminhamento;

}
