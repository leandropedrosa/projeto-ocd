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
    public FatorVunerabilidade(String descricao,String idTipoCancer) {
        this.descricao = descricao;
        this.idTipoCancer = idTipoCancer;
    }

    public FatorVunerabilidade() {
    }
    @Id
    private String id;
    private String descricao;
    private String idTipoCancer;
}