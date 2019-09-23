package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.Rastreamento;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Api(value = "/api/OCD/acompanhamento", description = "Manter Acompanhamento", produces = "application/json")
public interface RastreamentoSwagger {

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um Rastreamento", notes = "Insere um Acompanhamento", response = Rastreamento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    String create(@RequestBody Rastreamento rastreamento);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca Rastreamento pelo id usuário", notes = "Busca Rastreamento pelo id usuário", response = Rastreamento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public Page<Rastreamento> getByUsuario(@RequestParam("idUsuario") String idUsuario,
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
    public Page<Rastreamento> getByNomePaciente(
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
