package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "fatorVunerabilidade")
@Getter
@Setter
public class FatorVunerabilidade {
    @Id
    private Integer id;
    private String descricao;
    private Integer idTipoCancer;
}