package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.dto.FatoresDeRiscoDTO;
import br.ufg.api.ocd.model.FatorRisco;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Api(value = "/api/fatorDeRisco", description = "Manter Fator Vunerabilidade", produces = "application/json")
public interface FatorDeRiscoSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os Fatores de Risco", notes = "Busca todos os Fatores de Risco", response = FatorRisco.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    List<FatoresDeRiscoDTO> getAll();
}
