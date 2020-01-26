package br.ufg.api.ocd.dto;

import lombok.Data;

import java.util.List;
@Data
public class TipoRegiaoDTO {
    private String id;
    private String nome;
    private String caminhoImagem;
    private List<RegiaoBocaDTO> regioes;
}
