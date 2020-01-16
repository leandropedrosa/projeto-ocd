package br.ufg.api.ocd.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ResultadoDaCondutaDTO {
    private String id;
    private MultipartFile anexo;
    private String observacao;
    private TipoDeProcedimentoDTO tipoDeProcedimento;
    private EncaminhamentoDTO encaminhamento;
}
