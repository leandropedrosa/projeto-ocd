package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.LocalAtendimento;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.Optional;

@Api(value = "/api/OCD/ceo", description = "Manter CEO", produces = "application/json")
public interface LocalAtendimentoSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os ceo", notes = "Busca todos os ceo", response = LocalAtendimento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    Collection<LocalAtendimento> getAll();

}
