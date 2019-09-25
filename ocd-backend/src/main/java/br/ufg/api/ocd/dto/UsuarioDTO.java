package br.ufg.api.ocd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioDTO {

    private String id;
    private String status;
    @NotBlank(message = "{usuario.cpf.not.blank}")
    private String cpf;
    @NotBlank(message = "{usuario.password.not.blank}")
    private String password;
    private String nome;
    private String cargo;
    private String regiao;
    private String token;
    private String email;
}
