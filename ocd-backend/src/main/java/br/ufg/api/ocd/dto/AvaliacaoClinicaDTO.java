package br.ufg.api.ocd.dto;

import lombok.Data;

import java.util.List;

@Data
public class AvaliacaoClinicaDTO {
    private String id;
    private Boolean usuarioSeraEncaminhado;
    private AtendimentoDTO atendimento;
    private List<FatorRiscoAvaliacaoClinicaDTO> fatorRiscoAvaliacaoClinicas;
    private List<LocalDaLesaoDTO> localDasLesaos;
}
