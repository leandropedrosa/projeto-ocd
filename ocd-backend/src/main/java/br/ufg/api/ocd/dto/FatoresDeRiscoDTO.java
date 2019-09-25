package br.ufg.api.ocd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FatoresDeRiscoDTO {
    private String id;
    @NotBlank(message = "{fatoresDeRisco.nome.not.blank}")
    private String nome;


}
