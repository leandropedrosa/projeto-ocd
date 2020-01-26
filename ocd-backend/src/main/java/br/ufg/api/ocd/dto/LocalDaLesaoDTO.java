package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class LocalDaLesaoDTO {
    private String id;
    private LesaoDTO lesao;
    private RegiaoBocaDTO regiaoBoca;
    private AvaliacaoClinicaDTO avaliacaoClinica;
}
