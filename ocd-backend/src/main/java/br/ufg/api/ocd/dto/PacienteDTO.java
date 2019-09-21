package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.Lesao;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;

@Getter
public class PacienteDTO {

    private Integer id;
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

    public PacienteDTO(Integer id, String nomePaciente, String regiao, String ultimaData, String ultimoProcedimento, String status) {
        this.id = id;
        this.status = status;
        this.nomePaciente = nomePaciente;
        this.regiao = regiao;
        this.ultimaData = ultimaData;
        this.ultimoProcedimento = ultimoProcedimento;
    }
}
