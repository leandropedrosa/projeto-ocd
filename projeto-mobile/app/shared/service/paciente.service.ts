import { Injectable } from "@angular/core";
import {PacienteModel} from "~/shared/model/paciente.model";
import {BairroModel} from "~/shared/model/bairro.model";

@Injectable()
export class PacienteService {
    private pacientes = new Array<PacienteModel>(
        { id: "1", nome: "Labrador Retriever", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "2", nome: "German Shepherd", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "3", nome: "Golden Retriever", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "4", nome: "Bulldog", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "5", nome: "Beagle", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "6", nome: "Yorkshire Terrier", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "7", nome: "Poodle", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "8", nome: "Boxer", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "9", nome: "French Bulldog", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" },
        { id: "10", nome: "Rottweiler", sexo: "Masculino", dataNascimento: new Date(), email: "teste@teste.com", telefoneCelular: "99999999999", nomeMae:"teste", bairro: new BairroModel(), telefoneResponsavel: "99999999999" }
    );

    getPacientes(): any[] {
        return this.pacientes;
    }

    getPaciente(id: string): any {
        return this.pacientes.filter(item => item.id === id)[0];
    }
}
