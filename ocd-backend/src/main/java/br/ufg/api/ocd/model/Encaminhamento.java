package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "encaminhamento")
@Getter
@Setter
public class Encaminhamento {
    @Id
    private String id;
    private Date dataEncaminhamento;
    private String orientacao;
    private LocalAtendimento localAtendimento;
    private Atendimento atendimento;

}
