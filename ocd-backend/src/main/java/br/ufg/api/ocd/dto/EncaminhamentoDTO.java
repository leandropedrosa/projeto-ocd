package br.ufg.api.ocd.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EncaminhamentoDTO {
    private String id;
    private Date dataEncaminhamento;
    private String orientacao;
    private LocalAtendimentoDTO localAtendimento;
    private AtendimentoDTO atendimento;
    private List<ResultadoDaCondutaDTO> resultadoDasCondutasList;
}
