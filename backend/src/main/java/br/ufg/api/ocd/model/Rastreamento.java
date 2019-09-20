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

import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Document(collection = "rastreamento")
@Getter
@Setter
public class Rastreamento {
    @Id
    private String id;
    private String nomePaciente;
    private String nomeMae;
    private String bairro;
    private String cidade;
    private Date dtNascimento;
    private String sexo;
    private String cpf;
    private String email;

    private String localAtendimento;
    private Date dataAtendimento;
    private String idUsuario;

    private List<FatorDeRisco> fatoresDeRisco;
    private List<Lesao> lesoes;
    private String localReferencia;
    private Date dtRetornoSugerido;
    private Date dataSugeridaRetorno;
}