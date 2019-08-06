package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "usuario")
@Getter
@Setter
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String status;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String email;
    private String senha;
    private String numConselho;
    private String idTipoUsuario;
    @DBRef
    private List<Role> roles;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String numConselho, String idTipoUsuario) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numConselho = numConselho;
        this.idTipoUsuario = idTipoUsuario;
    }
}