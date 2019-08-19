// The following is a sample implementation of a backend service using Progress Kinvey (https://www.progress.com/kinvey).
// Feel free to swap in your own service / APIs / etc here for your own apps.

import { Injectable } from "@angular/core";
import { DatePipe } from '@angular/common';
import { UserService as KinveyUserService } from "kinvey-nativescript-sdk/lib/angular";
import { ObservableArray } from "data/observable-array";
import { Paciente } from "./paciente.model";

@Injectable()
export class PacienteService {
    pacientes: Array<Paciente> = new Array<Paciente>();

    constructor(private kinveyUserService: KinveyUserService, private datePipe: DatePipe) { }

    getDataItems(): Array<Paciente> {
        let paciente1: Paciente = new Paciente();
        paciente1.dtConsuta = new Date('01/01/2018');
        paciente1.dtRetornoSugerido = new Date('01/06/2018');
        paciente1.dtRetorno = new Date('01/08/2018');
        this.ajustaDados(1, paciente1);

        let paciente2: Paciente = new Paciente();
        paciente1.dtConsuta = new Date('01/01/2019');
        paciente1.dtRetornoSugerido = new Date('01/06/2019');
        this.ajustaDados(2, paciente2);

        let paciente3: Paciente = new Paciente();
        paciente1.dtConsuta = new Date('01/01/2019');
        this.ajustaDados(3, paciente3);

        let paciente4: Paciente = new Paciente();
        paciente1.dtConsuta = new Date('01/01/2018');
        this.ajustaDados(4, paciente4);

        let paciente5: Paciente = new Paciente();
        paciente1.dtConsuta = new Date('01/01/2018');
        paciente1.dtRetornoSugerido = new Date('01/06/2018');
        paciente1.dtRetorno = new Date('01/08/2018');
        this.ajustaDados(5, paciente5);

        this.pacientes.push(paciente1);
        this.pacientes.push(paciente2);
        this.pacientes.push(paciente3);
        this.pacientes.push(paciente4);
        this.pacientes.push(paciente5);
        return this.pacientes;
    }

    private ajustaDados(id: number, paciente: Paciente): void {
        paciente.id = id;
        paciente.nome = 'teste' + id;
        paciente.procedimento = paciente.dtRetornoSugerido === undefined ? 'Consuta' : 'Retorno';
        this.verificaStatus(paciente);
        this.verificaUltimaData(paciente);

    }

    private verificaStatus(paciente: Paciente): void {
        var currenceDate: Date = new Date(this.datePipe.transform(new Date(), "dd/MM/yyyy"));
        paciente.status = (paciente.dtRetornoSugerido !== undefined && paciente.dtRetorno === undefined) ? (currenceDate.getTime() > paciente.dtRetornoSugerido.getTime() ? "Em espera" : "Ok") : "Ok";
    }

    private verificaUltimaData(paciente: Paciente): void {
        let dtUltima: Date = paciente.dtRetornoSugerido === undefined ? (paciente.dtRetorno === undefined ? paciente.dtConsuta : paciente.dtRetorno) : paciente.dtRetornoSugerido;
        paciente.dtUltima = this.datePipe.transform(dtUltima, 'dd/MM/yyyy');
    }


}
