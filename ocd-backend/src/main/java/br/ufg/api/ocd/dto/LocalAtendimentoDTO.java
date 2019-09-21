package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.Lesao;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;

@Getter
public class LocalAtendimentoDTO {

    private Integer id;
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

    public LocalAtendimentoDTO(Integer id, String nome, String tipo, String regiao, String bairro, String cidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.regiao = regiao;
        this.bairro = bairro;
        this.cidade = cidade;
    }
}
