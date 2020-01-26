package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.Bairro;
import lombok.Data;

import java.util.List;

@Data
public class DistritoDTO {
    private String id;
    private String nome;
    private Bairro bairro;
    private List<LocalAtendimentoDTO> locaisDeAtendimento;
}
