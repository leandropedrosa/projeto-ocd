package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.model.LocalDeAtendimento;
import br.ufg.api.ocd.model.Rastreamento;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@Api(value = "/api/localAtendimento", description = "Manter CEO", produces = "application/json")
public interface LocalAtendimentoSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca pelos locais de atendimento por região", notes = "Busca pelos locais de atendimento por região", response = Rastreamento.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public Page<LocalDeAtendimento> getByRegiao(@RequestParam("regiao") String regiao,
                                           @RequestParam(
                                                   value = "page",
                                                   required = false,
                                                   defaultValue = "0") int page,
                                           @RequestParam(
                                                   value = "size",
                                                   required = false,
                                                   defaultValue = "10") int size);

}
