package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private String id;
    private String cpf;
    private String nome;
    private String senha;
    private String status;
    private String email;
    private String telefone;
    private TipoAtencaoDTO tipoAtencao;
    private LocalAtendimentoDTO localAtendimento;
}
