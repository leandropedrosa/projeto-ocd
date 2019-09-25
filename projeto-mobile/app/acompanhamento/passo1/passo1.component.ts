import {Component, Input, OnInit} from "@angular/core";
import {RouterExtensions} from "nativescript-angular/router";
import {Rastreamento} from "../../shared/rastreamento.model";
import {EventData} from "tns-core-modules/data/observable"
import {DatePicker} from "tns-core-modules/ui/date-picker";
import {DatePipe} from '@angular/common';
import {ActivatedRoute} from '@angular/router';

@Component({
    selector: "passo1",
    moduleId: module.id,
    templateUrl: "./passo1.component.html",
    styleUrls: ['./passo1.component.css']
})
export class Passo1Component implements OnInit {
    public acao: string;
    submitted: boolean;
    public currentDay: number = new Date().getDate();
    public currentMonth: number = new Date().getMonth() + 1;
    public currentYear: number = new Date().getFullYear();
    public rastreamento: Rastreamento;

    constructor(private router: RouterExtensions, private route: ActivatedRoute, private datePipe: DatePipe) {
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe(params => {
            this.rastreamento =  JSON.parse(params['rastreamento']);
        });

        console.dir(this.rastreamento);
        if (!this.rastreamento) {
            this.rastreamento = new Rastreamento();
        }
        this.acao = "PASSO1";
        console.dir("Passo1");
    }

    passo2() {
        this.router.navigate(['/passo2'], { queryParams: {rastreamento:JSON.stringify(this.rastreamento)} });
    }

    onDateNascimentoLoaded(data: EventData) {
        const datePicker = <DatePicker>data.object;
        datePicker.on("dateChange", (dtNascimento) => {
            console.dir(dtNascimento);
            this.rastreamento.dtNascimento = this.datePipe.transform(dtNascimento, 'dd/MM/yyyy');
            console.dir(this.rastreamento.dtNascimento);
        });
    }
}


