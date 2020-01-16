package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.TipoLesao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;

@Data
public class LesaoDTO {
    private String id;
    private String nome;
    private TipoLesaoDTO tipoLesao;
}
