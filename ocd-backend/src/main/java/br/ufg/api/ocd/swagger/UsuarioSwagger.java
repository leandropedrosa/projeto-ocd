package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.model.Usuario;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(value = "/api/usuario", description = "Manter Usuário", produces = "application/json")
public interface UsuarioSwagger {

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca usuário pelo cpf", notes = "Busca usuário pelo email", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public UsuarioDTO esqueceuSenha(@ApiParam(value = "cpf") String cpf);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Efetua login", notes = "Efetua login", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public UsuarioDTO loginBasic(@ApiParam(value = "user") UsuarioDTO user);
}
