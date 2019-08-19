import { Component, Input, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { SegmentedBarItem } from "ui/segmented-bar";
import { Rastreamento } from "../../shared/rastreamento.model";
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: "passo4",
    moduleId: module.id,
    templateUrl: "./passo4.component.html",
    styleUrls: ['./passo4.component.css']
})
export class Passo4Component implements OnInit {
    currentDay: number = new Date().getDate();
    currentMonth: number = new Date().getMonth() + 1;
    currentYear: number = new Date().getFullYear();
    @Input("rastreamento")
    public rastreamento: Rastreamento;
    acao: string;
    submitted: boolean;
    private getSegmentedBarItems = () => {
        let segmentedBarItem1 = new SegmentedBarItem();
        segmentedBarItem1.title = "Masculino";
        let segmentedBarItem2 = new SegmentedBarItem();
        segmentedBarItem2.title = "Feminino";
        return [segmentedBarItem1, segmentedBarItem2];
    }
    segmentedBarItems: Array<SegmentedBarItem> = this.getSegmentedBarItems();
    selectedBarIndex: number = 0;

    message = "You have successfully authenticated. This is where you build your core application functionality.";

    constructor(private route: ActivatedRoute, private routerExtensions: RouterExtensions) {
        this.route.params.subscribe(res => this.rastreamento = res.rastreamento);
    }

    ngOnInit(): void {
        this.acao = "PASSO4";
    }

    continuarFluxo(opcao: string) {
        this.acao = opcao;
    }

}


