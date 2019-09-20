package br.ufg.api.ocd.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LesaoDTO {

    private Integer id;
    @NotBlank(message = "{lesao.nome.not.blank}")
    private String nome;

    public LesaoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
