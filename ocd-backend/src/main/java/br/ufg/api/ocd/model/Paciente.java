package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "paciente")
@Data
public class Paciente {
    @Id
    private String id;
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String email;
    private String telefoneCelular;
    private String nomeDaMae;
    private String telefoneResponsavel;
    private Bairro bairro;

    @DBRef(lazy = true)
    private List<Atendimento> atendimentos;

}



