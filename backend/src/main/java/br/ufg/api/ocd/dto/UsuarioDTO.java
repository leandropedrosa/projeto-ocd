package br.ufg.api.ocd.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UsuarioDTO {

    private Integer id;
    @NotBlank(message = "{usuario.status.not.blank}")
    private String status;
    @NotBlank(message = "{usuario.cpf.not.blank}")
    private String cpf;
    @NotBlank(message = "{usuario.password.not.blank}")
    private String password;
    @NotBlank(message = "{usuario.nome.not.blank}")
    private String nome;
    @NotBlank(message = "{usuario.nivelAtencao.not.blank}")
    private String nivelAtencao;
    @NotBlank(message = "{usuario.regiao.not.blank}")
    private String regiao;
    @NotBlank(message = "{usuario.token.not.blank}")
    private String token;

    public UsuarioDTO(Integer id, String status, String cpf, String password, String nome, String nivelAtencao, String regiao, String token) {
        this.id = id;
        this.status = status;
        this.cpf = cpf;
        this.password = password;
        this.nome = nome;
        this.nivelAtencao = nivelAtencao;
        this.regiao = regiao;
        this.token = token;
    }
}
