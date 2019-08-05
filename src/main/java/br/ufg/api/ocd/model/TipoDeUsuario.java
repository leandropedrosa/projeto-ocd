package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoProfissional")
@Getter
@Setter
public class TipoDeUsuario {
    @Id
    private Integer id;
    private String descricao;
}