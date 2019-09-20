import { Component, Input, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { SegmentedBarItem } from "ui/segmented-bar";
import { Rastreamento } from "../../shared/rastreamento.model";
import { ActivatedRoute, Router } from '@angular/router';
import { DatePicker } from "tns-core-modules/ui/date-picker";
import { ListPicker } from "tns-core-modules/ui/list-picker";
import { RadListView, SwipeActionsEventData, ListViewEventData } from "nativescript-ui-listview";
import { DatePipe } from '@angular/common';
import { EventData, Observable } from "tns-core-modules/data/observable";
import { DadosIniciaisService } from "../../shared/dadosIniciais.service";
import { FatoresDeRisco } from "../../shared/fatoresDeRisco.model";
import { Lesao } from "../../shared/lesao.model";

@Component({
    selector: "passo3",
    moduleId: module.id,
    templateUrl: "./passo3.component.html",
    styleUrls: ['./passo3.component.css']
})
export class Passo3Component implements OnInit {

    currentDay: number = new Date().getDate();
    currentMonth: number = new Date().getMonth() + 1;
    currentYear: number = new Date().getFullYear();

    selectedListPickerIndex1: number = 0;

    private _dataItemsFR: Array<FatoresDeRisco>;
    private _selectedItemsFR: string;
    private _dataItemsLE: Array<Lesao>;

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

    constructor(private dadosIniciaisService: DadosIniciaisService, private router: Router, private route: ActivatedRoute, private datePipe: DatePipe, private routerExtensions: RouterExtensions) {
        this.route.params.subscribe(res => this.rastreamento = res.rastreamento);
    }

    ngOnInit(): void {
        this.acao = "PASSO3";
        this.dadosIniciaisService.getFatoresDeRisco().subscribe(
            response => {
                this._dataItemsFR = response;
            });
        this.dadosIniciaisService.getLesoes().subscribe(
            response => {
                this._dataItemsFR = response;
            });
    }

    continuarFluxo(opcao: string) {
        this.acao = opcao;
    }

    onDataSugeridaRetornoLoaded(data: EventData) {
        const datePicker = <DatePicker>data.object;
        datePicker.on("dateChange", (dataSugeridaRetorno) => {
            console.dir(dataSugeridaRetorno);
            this.rastreamento.dataSugeridaRetorno = this.datePipe.transform(dataSugeridaRetorno, 'dd/MM/yyyy');
            console.dir(this.rastreamento.dataSugeridaRetorno);
        });
    }

    public onSelectedIndexChanged(args: EventData) {
        const picker = <ListPicker>args.object;
        this.rastreamento.localReferencia = this.rastreamento.listPickerLocalAtendimento[picker.selectedIndex];
    }

    get dataItemsFR(): Array<FatoresDeRisco> {
        return this._dataItemsFR;
    }

    get dataItemsLE(): Array<Lesao> {
        return this._dataItemsLE;
    }

    public onItemSelectedFR(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<FatoresDeRisco>;
        let onExiste: boolean = false;
        for (let selecionado of selectedItems) {
            for (let fator of this.rastreamento.listFatoresRisco) {
                if (fator.id == selecionado.id) {
                    onExiste = true;
                }
            }
            if (!onExiste) {
                this.rastreamento.listFatoresRisco.push(selecionado);
            }
        }
    }

    public onItemDeselectedFR(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<FatoresDeRisco>;
        for (let selecionado of selectedItems) {
            for (let fator of this.rastreamento.listFatoresRisco) {
                if (fator.id == selecionado.id) {
                    this.rastreamento.listFatoresRisco.pop();
                }
            }
        }
    }

    public onItemSelectedLE(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<Lesao>;
        let onExiste: boolean = false;
        for (let selecionado of selectedItems) {
            for (let fator of this.rastreamento.listFatoresRisco) {
                if (fator.id == selecionado.id) {
                    onExiste = true;
                }
            }
            if (!onExiste) {
                this.rastreamento.listFatoresRisco.push(selecionado);
            }
        }
    }

    public onItemDeselectedLE(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<Lesao>;
        for (let selecionado of selectedItems) {
            for (let fator of this.rastreamento.listFatoresRisco) {
                if (fator.id == selecionado.id) {
                    this.rastreamento.listFatoresRisco.pop();
                }
            }
        }
    }
}


