package br.ufg.api.ocd.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class RastreamentoDTO {

    private Integer id;

    // passo1
    private String nomePaciente;
    private String nomeMae;
    private String bairro;
    private String cidade;
    private String dtNascimento;
    private String sexo;
    private String cpf;
    private String email;

    // passo2
    private String localAtendimento;
    private String dataAtendimento;
    private String profissionalAtendimento;

    // passo3
    private List<FatoresDeRiscoDTO> listFatoresRisco;
    private List<LesaoDTO> listPresencaLesao;
    private String localReferencia;
    private String dataSugeridaRetorno;
    private String regiao;
}
