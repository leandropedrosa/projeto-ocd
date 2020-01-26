package br.ufg.api.ocd.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

@Document(collection = "atendimento")
@Data
public class Atendimento {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dataAtendimento;
    private String descricao;
    private Usuario usuario;
    private Paciente paciente;
    private TipoAtendimento tipoAtendimento;
    private LocalAtendimento localAtendimento;

    @DBRef(lazy = true)
    private List<AvaliacaoClinica> avaliacaoClinicas;

    @DBRef(lazy = true)
    private List<Diagnostico> diagnosticos;

    @DBRef(lazy = true)
    private List<Encaminhamento> encaminhamentos;

}
