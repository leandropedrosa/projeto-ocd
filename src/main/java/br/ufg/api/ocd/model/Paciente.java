package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paciente")
@Getter
@Setter
public class Paciente {
    @Id
    private String id;
    private String nome;
    private String dtNascimento;
    private String nomeMae;
    private String sexo;
    private String fone;
    private String endereco;
    private String statusPaciente;
    private String email;
    private String cartaoSus;
    private String cpf;
}