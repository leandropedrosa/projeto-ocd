package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.Bairro;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PacienteDTO {
    private String id;
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String email;
    private String telefoneCelular;
    private String nomeDaMae;
    private String telefoneResponsavel;
    private Bairro bairro;
    private List<AtendimentoDTO> atendimentos;
}
