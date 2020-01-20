package br.ufg.api.ocd.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lesao")
@Data
@Builder
public class ScriptsMobile {
    @Id
    private String id;
    private String tabela;
    private String script;
    private VersaoBanco versaoBanco;
}
