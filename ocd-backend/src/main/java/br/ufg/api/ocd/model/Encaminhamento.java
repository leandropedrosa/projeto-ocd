package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "encaminhamento")
@Data
public class Encaminhamento {
    @Id
    private String id;
    private Date dataEncaminhamento;
    private String orientacao;
    private LocalAtendimento localAtendimento;
    private Atendimento atendimento;

    @DBRef(lazy = true)
    private List<ResultadoDaConduta> resultadoDasCondutasList;

}
