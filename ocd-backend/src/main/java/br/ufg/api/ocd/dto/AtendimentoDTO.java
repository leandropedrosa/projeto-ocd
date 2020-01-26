package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AtendimentoDTO {
    private String id;
    private Date dataAtendimento;
    private String descricao;
    @JsonIgnore
    private Usuario usuario;
    @JsonIgnore
    private PacienteDTO paciente;
    @JsonIgnore
    private TipoAtendimentoDTO tipoAtendimento;
    @JsonIgnore
    private LocalAtendimentoDTO localAtendimento;
    @JsonIgnore
    private List<AvaliacaoClinicaDTO> avaliacaoClinicas;
    @JsonIgnore
    private List<DiagnosticoDTO> diagnosticos;
    @JsonIgnore
    private List<EncaminhamentoDTO> encaminhamentos;
}
