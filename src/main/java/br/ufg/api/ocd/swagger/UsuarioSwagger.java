package br.ufg.api.ocd.swagger;

import br.ufg.api.ocd.dto.UsuarioDTO;
import br.ufg.api.ocd.model.Usuario;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Api(value = "/api/OCD/usuario", description = "Manter Usuário", produces = "application/json")
public interface UsuarioSwagger {

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um Usuário", notes = "Insere um Usuário", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    String create(@RequestBody Usuario usuario);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Efetua o login pelo Email e a Senha", notes = "Efetua o login pelo Email e a Senha", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public Usuario login(@ApiParam(value = "email") String email, @ApiParam(value = "senha") String senha);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca usuário pelo email", notes = "Busca usuário pelo email", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public Usuario esqueceuSenha(@ApiParam(value = "email") String email);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualizar senha do Usuário", notes = "Atualizar senha do Usuário", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public String updateSenha(@ApiParam(value = "idUsuario") int idUsuario, @ApiParam(value = "senha") String senha);

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualizar Status do Usuário", notes = "Atualizar Status do Usuário", response = Usuario.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acessando o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public String updateStatus(@ApiParam(value = "idUsuario") int idUsuario);
}
