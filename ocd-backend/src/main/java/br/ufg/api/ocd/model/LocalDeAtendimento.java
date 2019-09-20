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
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "localDeAtendimento")
@Getter
@Setter
public class LocalDeAtendimento {

    public LocalDeAtendimento(String nome, String tipo, String regiao, String bairro, String cidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.regiao = regiao;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public LocalDeAtendimento() {
    }

    @Id
    private String id;
    private String nome;
    private String tipo;
    private String regiao;
    private String bairro;
    private String cidade;
}