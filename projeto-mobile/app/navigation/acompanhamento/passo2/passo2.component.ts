import {Component, Input, OnInit} from "@angular/core";
import {DadosIniciaisService} from "../../../shared/dadosIniciais.service";
import {LocalAtendimento} from "../../../shared/localAtendimento.model";
import {ActivatedRoute} from '@angular/router';
import {ListPicker} from "tns-core-modules/ui/list-picker";
import {DatePicker} from "tns-core-modules/ui/date-picker";
import {DatePipe} from '@angular/common';
import {EventData} from "tns-core-modules/data/observable";
import {AuthenticationService} from "../../../shared/authentication.service";
import {User} from "../../../shared/user.model";
import {RouterExtensions} from "nativescript-angular";
import {Rastreamento} from "../../../shared/rastreamento.model";

@Component({
    selector: "passo2",
    moduleId: module.id,
    templateUrl: "./passo2.component.html",
    styleUrls: ['./passo2.component.css']
})
export class Passo2Component implements OnInit {
    public acao: string;
    submitted: boolean;
    public selectedListPickerIndex1: number = 0;
    public rastreamento: Rastreamento;
    public localAtendimento: LocalAtendimento[];

    currentDay: number = new Date().getDate();
    currentMonth: number = new Date().getMonth() + 1;
    currentYear: number = new Date().getFullYear();

    constructor(private authenticationService: AuthenticationService, private dadosIniciaisService: DadosIniciaisService, private datePipe: DatePipe, private router: RouterExtensions, private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe(params => {
            this.rastreamento =  JSON.parse(params['matriciamento']);
        });

        console.dir(this.rastreamento);
        this.acao = "PASSO2";
        let currentUser: User = this.authenticationService.getLoggedInUser();
        this.rastreamento.regiao = currentUser.regiao;
        this.dadosIniciaisService.getLocalAtendimento(currentUser.regiao).subscribe(
            response => {
                this.localAtendimento = response;
                this.rastreamento.profissionalAtendimento = currentUser.nome;
                for (let local of this.localAtendimento) {
                    this.rastreamento.listPickerLocalAtendimento.push(local.nome);
                }
            });
    }

    public onSelectedIndexChanged(args: EventData) {
        const picker = <ListPicker>args.object;
        this.rastreamento.localAtendimento = this.rastreamento.listPickerLocalAtendimento[picker.selectedIndex];
    }

    passo1() {
        this.router.navigate(['/passo1'], { queryParams: {rastreamento:JSON.stringify(this.rastreamento)} });
    }

    passo3() {
        this.router.navigate(['/passo3'], { queryParams: {rastreamento:JSON.stringify(this.rastreamento)} });
    }

    onDateAtendimentoLoaded(data: EventData) {
        const datePicker = <DatePicker>data.object;
        datePicker.on("dateChange", (dtAtendimento) => {
            console.dir(dtAtendimento);
            this.rastreamento.dataAtendimento = this.datePipe.transform(dtAtendimento, 'dd/MM/yyyy');
            console.dir(this.rastreamento.dataAtendimento);
        });
    }

}


