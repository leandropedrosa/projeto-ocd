package br.ufg.api.ocd.dto;

import lombok.Data;

@Data
public class DiagnosticoDTO {
    private String id;
    private String hipoteseDiagnostico;
    private Boolean confirmaRastreamento;
    private String observacao;
    private AtendimentoDTO atendimento;
}
