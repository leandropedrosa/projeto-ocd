package br.ufg.api.ocd.dto;

import lombok.Data;

import java.util.List;

@Data
public class TipoLocalAtendimentoDTO {

    private String id;
    private String nome;
    private List<LocalAtendimentoDTO> locaisDeAtendimento;

}
