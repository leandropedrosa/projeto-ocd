import { ItemEventData } from "tns-core-modules/ui/list-view"
import { Component, Input, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { SegmentedBarItem } from "ui/segmented-bar";
import { DadosIniciaisService } from "../../shared/dadosIniciais.service";
import { LocalAtendimento } from "../../shared/localAtendimento.model";
import { UserService } from "../../shared/user.service";
import { Rastreamento } from "../../shared/rastreamento.model";
import { ActivatedRoute, Router } from '@angular/router';
import { ListPicker } from "tns-core-modules/ui/list-picker";
import { RadListView, SwipeActionsEventData, ListViewEventData } from "nativescript-ui-listview";
import { DatePicker } from "tns-core-modules/ui/date-picker";
import { DatePipe } from '@angular/common';
import { EventData, Observable } from "tns-core-modules/data/observable";

@Component({
    selector: "passo2",
    moduleId: module.id,
    templateUrl: "./passo2.component.html",
    styleUrls: ['./passo2.component.css']
})
export class Passo2Component implements OnInit {

    @Input("rastreamento")
    public rastreamento: Rastreamento;
    acao: string;
    submitted: boolean;
    selectedListPickerIndex1: number = 0;
    private _selectedItems: string;

    onItemTap(args: ItemEventData): void {
        console.log('Item with index: ' + args.index + ' tapped');
    }

    localAtendimento: LocalAtendimento[];

    currentDay: number = new Date().getDate();
    currentMonth: number = new Date().getMonth() + 1;
    currentYear: number = new Date().getFullYear();
    selectedBarIndex: number = 0;

    constructor(private userService: UserService, private dadosIniciaisService: DadosIniciaisService, private router: Router, private route: ActivatedRoute, private datePipe: DatePipe, private routerExtensions: RouterExtensions) {
        this.route.params.subscribe(res => this.rastreamento = res.rastreamento);
    }

    ngOnInit(): void {
        this.acao = "PASSO2";
        this.rastreamento.regiao = localStorage.getItem('regionUser');
        this.dadosIniciaisService.getLocalAtendimento(localStorage.getItem('regionUser')).subscribe(
            response => {
                this.localAtendimento = response;
                this.rastreamento.profissionalAtendimento = localStorage.getItem('nameUser');
                for (let local of this.localAtendimento) {
                    this.rastreamento.listPickerLocalAtendimento.push(local.nome);
                }
            });
    }

    public onSelectedIndexChanged(args: EventData) {
        const picker = <ListPicker>args.object;
        this.rastreamento.localAtendimento = this.rastreamento.listPickerLocalAtendimento[picker.selectedIndex];
    }

    continuarFluxo(opcao: string) {
        this.acao = opcao;
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


