package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.dto.RastreamentoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(value = "/api/OCD/rastreamento", description = "Manter Acompanhamento", produces = "application/json")
public interface RastreamentoSwagger {

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um Rastreamento", notes = "Insere um Acompanhamento", response = Rastreamento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    String create(@RequestBody RastreamentoDTO rastreamentoDTO);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca Rastreamento pelo id usuário", notes = "Busca Rastreamento pelo id usuário", response = Rastreamento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public Page<RastreamentoDTO> getByUsuario(@RequestParam("idUsuario") String idUsuario,
                                           @RequestParam(
                                                   value = "page",
                                                   required = false,
                                                   defaultValue = "0") int page,
                                           @RequestParam(
                                                   value = "size",
                                                   required = false,
                                                   defaultValue = "10") int size);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca Rastreamento pelo nome do paciente", notes = "Busca Rastreamento pelo nome do paciente", response = Rastreamento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public Page<RastreamentoDTO> getByNomePaciente(
            @RequestParam("idUsuario") String idUsuario,
            @RequestParam("nomePaciente") String nomePaciente,
                                           @RequestParam(
                                                   value = "page",
                                                   required = false,
                                                   defaultValue = "0") int page,
                                           @RequestParam(
                                                   value = "size",
                                                   required = false,
                                                   defaultValue = "10") int size);
}
