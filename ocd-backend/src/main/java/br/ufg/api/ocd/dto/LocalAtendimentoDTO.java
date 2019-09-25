package br.ufg.api.ocd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LocalAtendimentoDTO {
    private String id;
    @NotBlank(message = "{usuario.status.not.blank}")
    private String nome;
    @NotBlank(message = "{usuario.login.not.blank}")
    private String tipo;
    @NotBlank(message = "{usuario.senha.not.blank}")
    private String regiao;
    @NotBlank(message = "{usuario.nome.not.blank}")
    private String bairro;
    @NotBlank(message = "{usuario.nome.not.blank}")
    private String cidade;
}
