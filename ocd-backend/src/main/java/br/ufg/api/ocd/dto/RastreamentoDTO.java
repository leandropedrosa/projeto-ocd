package br.ufg.api.ocd.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class RastreamentoDTO {

    private Integer id;

    // passo1
    @NotBlank(message = "{rastreamento.nomePaciente.not.blank}")
    private String nomePaciente;
    @NotBlank(message = "{rastreamento.nomeMae.not.blank}")
    private String nomeMae;
    @NotBlank(message = "{rastreamento.bairro.not.blank}")
    private String bairro;
    @NotBlank(message = "{rastreamento.cidade.not.blank}")
    private String cidade;
    @NotBlank(message = "{rastreamento.dtNascimento.not.blank}")
    private String dtNascimento;
    @NotBlank(message = "{rastreamento.sexo.not.blank}")
    private String sexo;
    @NotBlank(message = "{rastreamento.cpf.not.blank}")
    private String cpf;
    @NotBlank(message = "{rastreamento.email.not.blank}")
    private String email;

    // passo2
    @NotBlank(message = "{rastreamento.localAtendimento.not.blank}")
    private String localAtendimento;
    @NotBlank(message = "{rastreamento.dataAtendimento.not.blank}")
    private String dataAtendimento;
    @NotBlank(message = "{rastreamento.idUsuario.not.blank}")
    private String idUsuario;
    @NotBlank(message = "{rastreamento.profissionalAtendimento.not.blank}")
    private String profissionalAtendimento;

    // passo3
    @NotBlank(message = "{rastreamento.listFatoresRisco.not.blank}")
    private List<FatoresDeRiscoDTO> listFatoresRisco;
    @NotBlank(message = "{rastreamento.listPresencaLesao.not.blank}")
    private List<LesaoDTO> listPresencaLesao;
    @NotBlank(message = "{rastreamento.localReferencia.not.blank}")
    private String localReferencia;
    @NotBlank(message = "{rastreamento.dataSugeridaRetorno.not.blank}")
    private String dataSugeridaRetorno;
    @NotBlank(message = "{rastreamento.regiao.not.blank}")
    private String regiao;

}
