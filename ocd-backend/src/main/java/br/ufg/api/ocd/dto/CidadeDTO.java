package br.ufg.api.ocd.dto;

import lombok.Data;

import java.util.List;

@Data
public class CidadeDTO {

    private String id;
    private String nome;
    private List<BairroDTO> bairros;
}

