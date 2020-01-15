package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "atendimento")
@Getter
@Setter
public class Atendimento {
    @Id
    private String id;
    private Date dataAtendimento;
    private Usuario usuario;
    private Paciente paciente;
    private TipoAtendimento tipoAtendimento;
}
