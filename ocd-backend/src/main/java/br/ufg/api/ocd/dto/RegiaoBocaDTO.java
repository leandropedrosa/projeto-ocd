package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class RegiaoBocaDTO {
    private String id;
    private String nome;
    private TipoRegiaoDTO tipoRegiao;
}
