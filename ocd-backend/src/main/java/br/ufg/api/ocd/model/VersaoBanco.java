package br.ufg.api.ocd.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "versaoBanco")
@Data
@Builder
public class VersaoBanco {
    @Id
    private String id;
    private String descricao;
    private Date data;
}
