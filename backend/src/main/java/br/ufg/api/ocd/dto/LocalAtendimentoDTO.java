package br.ufg.api.ocd.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LocalAtendimentoDTO {

    private Integer id;
    @NotBlank(message = "{usuario.status.not.blank}")
    private String status;
    @NotBlank(message = "{usuario.login.not.blank}")
    private String login;
    @NotBlank(message = "{usuario.senha.not.blank}")
    private String senha;
    @NotBlank(message = "{usuario.nome.not.blank}")
    private String nome;

    public LocalAtendimentoDTO(Integer id, String status, String login, String senha, String nome) {
        this.id = id;
        this.status = status;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }
}
