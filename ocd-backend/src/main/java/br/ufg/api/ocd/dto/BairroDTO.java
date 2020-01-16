package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class BairroDTO {
    private String id;
    private String nome;
    private CidadeDTO cidade;
}
