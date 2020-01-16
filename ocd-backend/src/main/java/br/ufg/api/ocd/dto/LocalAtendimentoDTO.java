package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class LocalAtendimentoDTO {
    private String id;
    private String nome;
    private DistritoDTO distrito;
    private TipoLocalAtendimentoDTO tipoLocalAtendimento;
}
