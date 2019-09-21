package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.Lesao;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;

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
    @NotBlank(message = "{usuario.cargo.not.blank}")
    private String cargo;
    @NotBlank(message = "{usuario.regiao.not.blank}")
    private String regiao;
    private String token;
    @NotBlank(message = "{usuario.email.not.blank}")
    private String email;

    public UsuarioDTO(Integer id, String status, String cpf, String password, String nome, String cargo, String regiao, String token, String email) {
        this.id = id;
        this.status = status;
        this.cpf = cpf;
        this.password = password;
        this.nome = nome;
        this.cargo = cargo;
        this.regiao = regiao;
        this.token = token;
        this.email = email;
    }

}
