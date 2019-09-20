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
    private Date dtNascimento;
    private String sexo;
    private String nomeMae;
    private String cpf;
    private String numSus;
    private String numTelefone;
    private String email;
    private String localAtendimento;
    private Date dtReferencia;
    private Date dtContraReferencia;
    private String idTipoCancer;
    private List<String> fatoresVunerabilidade;
    private List<String> lesoes;
    private Blob diagnosticoHistopatologico;
    private Date dtRetornoReal;
    private Date dtRetornoSugerido;
    private Date dtConsulta;
    private String idUsuario;
    private String bairro;
    private String cidade;
}