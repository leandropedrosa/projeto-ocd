package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@Api(value = "/api/OCD/ceo", description = "Manter CEO", produces = "application/json")
public interface LocalAtendimentoSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os ceo", notes = "Busca todos os ceo", response = LocalDeAtendimento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    Collection<LocalDeAtendimento> getAll();

}
