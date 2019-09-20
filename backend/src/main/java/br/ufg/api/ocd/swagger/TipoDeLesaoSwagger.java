package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.TipoDeLesao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.Optional;

@Api(value = "/api/OCD/tipoLesao", description = "Manter Tipo de Lesão", produces = "application/json")
public interface TipoDeLesaoSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os Tipo de Lesãos", notes = "Busca todos os Tipo de Lesãos", response = TipoDeLesao.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    Collection<TipoDeLesao> getAll();
}
