package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.FatorDeVunerabilidade;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@Api(value = "/api/OCD/fatorVunerabilidade", description = "Manter Fator Vunerabilidade", produces = "application/json")
public interface FatorVunerabilidadeSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os Fatores Vunerabilidade por tipo de câncer", notes = "Busca todos os Fatores Vunerabilidade por tipo de câncer", response = FatorDeVunerabilidade.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    Collection<FatorDeVunerabilidade> getByTipoCancer(@ApiParam(value = "idTipoCancer") String idTipoCancer);
}
