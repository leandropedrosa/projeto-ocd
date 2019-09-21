/*
 * Copyright (c) 2019. Universidade Federal de Goiás (UFG)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "usuario")
@Getter
@Setter
public class Usuario {
    @Id
    private String id;
    private String status;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String cpf;
    private String nome;
    private String password;
    private String cargo;
    private String regiao;
    private String token;
    private String email;
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    //@DBRef
    //private Set<Role> roles;

    public Usuario() {
    }
    public Usuario(Usuario user) {
        super();
        this.status = user.status;
        this.cpf = user.cpf;
        this.nome = user.nome;
        this.password = user.password;
        this.cargo = user.cargo;
        this.regiao = user.regiao;
        this.email = user.email;
    }

    public Usuario(String status, String cpf, String nome, String password, String cargo, String regiao, String email) {
        super();
        this.status = status;
        this.cpf = cpf;
        this.nome = nome;
        this.password = password;
        this.cargo = cargo;
        this.regiao = regiao;
        this.email = email;
    }
}