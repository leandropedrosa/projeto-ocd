package br.ufg.api.ocd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LesaoDTO {
    private String id;
    @NotBlank(message = "{lesao.nome.not.blank}")
    private String nome;
}
