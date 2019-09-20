package br.ufg.api.ocd.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class FatoresDeRiscoDTO {

    private Integer id;
    @NotBlank(message = "{fatoresDeRisco.nome.not.blank}")
    private String nome;

    public FatoresDeRiscoDTO(Integer id,  String nome) {
        this.id = id;
        this.nome = nome;
    }
}
