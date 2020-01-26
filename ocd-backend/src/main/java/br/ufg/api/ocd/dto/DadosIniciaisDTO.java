package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.ScriptsMobile;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DadosIniciaisDTO {
    private UsuarioDTO usuario;
    private List<ScriptsMobile> scriptsIniciais;
}
