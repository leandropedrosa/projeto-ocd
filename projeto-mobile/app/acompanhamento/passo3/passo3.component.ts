import {Component, Input, OnInit} from "@angular/core";
import {RouterExtensions} from "nativescript-angular/router";
import {Rastreamento} from "../../shared/rastreamento.model";
import {ActivatedRoute} from '@angular/router';
import {DatePicker} from "tns-core-modules/ui/date-picker";
import {ListPicker} from "tns-core-modules/ui/list-picker";
import {ListViewEventData, RadListView} from "nativescript-ui-listview";
import {DatePipe} from '@angular/common';
import {EventData} from "tns-core-modules/data/observable";
import {DadosIniciaisService} from "../../shared/dadosIniciais.service";
import {FatoresDeRisco} from "../../shared/fatoresDeRisco.model";
import {Lesao} from "../../shared/lesao.model";

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

    public _dataItemsFR: Array<FatoresDeRisco>;
    public _dataItemsLE: Array<Lesao>;
    public rastreamento: Rastreamento;
    acao: string;
    submitted: boolean;

    constructor(private dadosIniciaisService: DadosIniciaisService, private router: RouterExtensions, private route: ActivatedRoute, private datePipe: DatePipe) {
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe(params => {
            this.rastreamento =  JSON.parse(params['rastreamento']);
        });

        console.log(this.rastreamento);
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


