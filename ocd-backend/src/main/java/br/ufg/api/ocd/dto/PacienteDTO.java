package br.ufg.api.ocd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PacienteDTO {

    private String id;
    @NotBlank(message = "{paciente.nomePaciente.not.blank}")
    private String nomePaciente;
    @NotBlank(message = "{paciente.regiao.not.blank}")
    private String regiao;
    @NotBlank(message = "{paciente.ultimaData.not.blank}")
    private String ultimaData;
    @NotBlank(message = "{paciente.ultimoProcedimento.not.blank}")
    private String ultimoProcedimento;
    @NotBlank(message = "{paciente.status.not.blank}")
    private String status;
}
