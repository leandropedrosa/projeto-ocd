import { Component, Input, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { SegmentedBarItem } from "ui/segmented-bar";
import { Rastreamento } from "../../shared/rastreamento.model";
import { EventData, Observable } from "tns-core-modules/data/observable"
import { DatePicker } from "tns-core-modules/ui/date-picker";
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
    selector: "passo1",
    moduleId: module.id,
    templateUrl: "./passo1.component.html",
    styleUrls: ['./passo1.component.css']
})
export class Passo1Component implements OnInit {
    @Input("rastreamento")
    public rastreamento: Rastreamento;
    acao: string;
    submitted: boolean;
    currentDay: number = new Date().getDate();
    currentMonth: number = new Date().getMonth() + 1;
    currentYear: number = new Date().getFullYear();

    selectedBarIndex: number = 0;

    private getSegmentedBarItems = () => {
        let segmentedBarItem1 = new SegmentedBarItem();
        segmentedBarItem1.title = "Masculino";
        let segmentedBarItem2 = new SegmentedBarItem();
        segmentedBarItem2.title = "Feminino";
        return [segmentedBarItem1, segmentedBarItem2];
    }
    segmentedBarItems: Array<SegmentedBarItem> = this.getSegmentedBarItems();

    constructor(private routerExtensions: RouterExtensions, private datePipe: DatePipe) {
        this.rastreamento = new Rastreamento();
    }

    ngOnInit(): void {
        this.acao = "PASSO1";
    }

    continuarFluxo(opcao: string) {
        this.acao = opcao;
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


