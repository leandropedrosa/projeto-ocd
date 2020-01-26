package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class FatorRiscoAvaliacaoClinicaDTO {
    private String id;
    private FatoresDeRiscoDTO fatorRisco;
    private AvaliacaoClinicaDTO avaliacaoClinica;
}
