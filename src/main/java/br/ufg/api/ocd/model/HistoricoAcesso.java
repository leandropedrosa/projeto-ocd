package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Document(collection = "historicoAcesso")
@Getter
@Setter
public class HistoricoAcesso {
    @Id
    private Integer id;
    @DBRef
    private Usuario usuario;
    private String data;

    public HistoricoAcesso(Usuario usuario, String data) {
        this.usuario = usuario;
        this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}