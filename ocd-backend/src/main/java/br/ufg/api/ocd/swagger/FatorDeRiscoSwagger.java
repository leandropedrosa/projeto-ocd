package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.FatorDeRisco;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@Api(value = "/api/fatorVunerabilidade", description = "Manter Fator Vunerabilidade", produces = "application/json")
public interface FatorDeRiscoSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os Fatores de Risco", notes = "Busca todos os Fatores de Risco", response = FatorDeRisco.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    Collection<FatorDeRisco> getAll();
}
