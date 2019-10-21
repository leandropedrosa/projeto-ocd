import { Observable } from "tns-core-modules/data/observable";

export class PacienteViewModel extends Observable {

    constructor() {
        super();
    }

    set paciente(value: Paciente) {
        this.set("_paciente", value);
    }

    get paciente(): Paciente {
        return this.get("_paciente");
    }
}

export class Paciente {
        public nomePaciente: string;
        public nomeMae: string;
        public bairro: string;
        public cidade: string;
        public dtNascimento: string;
        public sexo: string;
        public cpf: string;
        public email: string;
        public numTelefone: string;
        public idade: number;

    constructor(nomePaciente, nomeMae, bairro, city, cidade, dtNascimento, sexo, cpf, email, numTelefone, idade) {
        this.nomePaciente = nomePaciente;
        this.nomeMae = nomeMae;
        this.bairro = bairro;
        this.cidade = cidade;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.email = email;
        this.numTelefone = numTelefone;
        this.idade = idade;
    }
}