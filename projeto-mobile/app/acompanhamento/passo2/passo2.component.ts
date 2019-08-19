import { ItemEventData } from "tns-core-modules/ui/list-view"
import { Component, Input, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { SegmentedBarItem } from "ui/segmented-bar";
import { TipoCancerService } from "../../shared/tipoCancer.service";
import { Rastreamento } from "../../shared/rastreamento.model";
import { ActivatedRoute, Router } from '@angular/router';
import { FatoresDeVunerabilidade } from "../../shared/fatoresVunerabilidade.model";
import { ListPicker } from "tns-core-modules/ui/list-picker";
import { RadListView, SwipeActionsEventData, ListViewEventData } from "nativescript-ui-listview";
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

    private _dataItems: Array<FatoresDeVunerabilidade>;

    private _selectedItems: string;

    onItemTap(args: ItemEventData): void {
        console.log('Item with index: ' + args.index + ' tapped');
    }

    listPickerCountries: Array<string> = ["Australia", "Belgium", "Bulgaria", "Canada", "Switzerland",
        "China", "Czech Republic", "Germany", "Spain", "Ethiopia", "Croatia", "Hungary",
        "Italy", "Jamaica", "Romania", "Russia", "United States"];

    listTiposDeCancer: Array<string> = ["Boca", "Colo de Útero"];

    selectedListPickerIndex1: number = 0;
    selectedListPickerIndex2: number = 0;

    currentDay: number = new Date().getDate();
    currentMonth: number = new Date().getMonth() + 1;
    currentYear: number = new Date().getFullYear();

    private getSegmentedBarItems = () => {
        let segmentedBarItem1 = new SegmentedBarItem();
        segmentedBarItem1.title = "Masculino";
        let segmentedBarItem2 = new SegmentedBarItem();
        segmentedBarItem2.title = "Feminino";
        return [segmentedBarItem1, segmentedBarItem2];
    }

    segmentedBarItems: Array<SegmentedBarItem> = this.getSegmentedBarItems();
    selectedBarIndex: number = 0;

    constructor(private router: Router, private route: ActivatedRoute, private tipoCancerService: TipoCancerService, private routerExtensions: RouterExtensions) {
        this.route.params.subscribe(res => this.rastreamento = res.rastreamento);
    }

    get dataItems(): Array<FatoresDeVunerabilidade> {
        return this._dataItems;
    }

    get selectedItems(): string {
        return this._selectedItems;
    }

    ngOnInit(): void {
        this.acao = "PASSO2";
        this._dataItems = this.tipoCancerService.getFatores(0);
        this._selectedItems = "No Selected items.";
    }

    continuarFluxo(opcao: string) {
        this.acao = opcao;
    }

    public selectedIndexChanged(args) {
        let picker = <ListPicker>args.object;
        this._dataItems = this.tipoCancerService.getFatores(picker.selectedIndex);
    }

    public onItemSelected(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<FatoresDeVunerabilidade>;
        let selectedTitles = "Selected items: ";
        for (let i = 0; i < selectedItems.length; i++) {
            selectedTitles += selectedItems[i] ? selectedItems[i].id : "";

            if (i < selectedItems.length - 1) {
                selectedTitles += ", ";
            }
        }

        this._selectedItems = selectedTitles;
        const selectedItem = this.dataItems[args.index];
    }

    public onItemSelecting(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<FatoresDeVunerabilidade>;
        let selectedTitles = "Selecting item: ";
        for (let i = 0; i < selectedItems.length; i++) {
            selectedTitles += selectedItems[i] ? selectedItems[i].id : "";

            if (i < selectedItems.length - 1) {
                selectedTitles += ", ";
            }
        }

        const selectedItem = this.dataItems[args.index];
    }

    public onItemDeselecting(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<FatoresDeVunerabilidade>;
        let selectedTitles = "Deselecting item: ";
        for (let i = 0; i < selectedItems.length; i++) {
            selectedTitles += selectedItems[i] ? selectedItems[i].id : "";

            if (i < selectedItems.length - 1) {
                selectedTitles += ", ";
            }
        }

        const selectedItem = this.dataItems[args.index];
    }

    public onItemDeselected(args: ListViewEventData) {
        const listview = args.object as RadListView;
        const selectedItems = listview.getSelectedItems() as Array<FatoresDeVunerabilidade>;
        if (selectedItems.length > 0) {
            let selectedTitles = "Selected items: ";
            for (let i = 0; i < selectedItems.length; i++) {
                selectedTitles += selectedItems[i] ? selectedItems[i].id : "";

                if (i < selectedItems.length - 1) {
                    selectedTitles += ", ";
                }
            }

            this._selectedItems = selectedTitles;
        } else {
            this._selectedItems = "No Selected items.";
        }

        const deselectedItem = this.dataItems[args.index];
    }

}


