import {Component, OnInit, ViewChild} from "@angular/core";
import { ObservableArray } from "tns-core-modules/data/observable-array";
import { TokenModel, AutoCompleteCompletionMode, AutoCompleteDisplayMode, AutoCompleteSuggestMode } from "nativescript-ui-autocomplete";
import { RadAutoCompleteTextViewComponent } from "nativescript-ui-autocomplete/angular";
import {RouterExtensions} from "nativescript-angular/router";

@Component({
    selector: "busca-pacientes",
    moduleId: module.id,
    templateUrl: "./busca-pacientes.component.html",
    styleUrls: ["./busca-pacientes.component.css"]
})
export class BuscaPacientesComponent {
    private _items: ObservableArray<TokenModel>;
    private countries = ["Australia", "Albania", "Austria", "Argentina", "Maldives", "Bulgaria", "Belgium", "Cyprus", "Italy", "Japan",
        "Denmark", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland",
        "Latvia", "Luxembourg", "Macedonia", "Moldova", "Monaco", "Netherlands", "Norway",
        "Poland", "Romania", "Russia", "Sweden", "Slovenia", "Slovakia", "Turkey", "Ukraine",
        "Vatican City", "Chad", "China", "Chile"];

    constructor(private routerExtensions: RouterExtensions) {
        this.initDataItems();
    }

    @ViewChild("autocomplete", { static: false }) autocomplete: RadAutoCompleteTextViewComponent;

    get dataItems(): ObservableArray<TokenModel> {
        return this._items;
    }

    private initDataItems() {
        this._items = new ObservableArray<TokenModel>();

        for (let i = 0; i < this.countries.length; i++) {
            this._items.push(new TokenModel(this.countries[i], undefined));
        }
    }

    novoAtendimento(){
        this.routerExtensions.navigate(["rastreamento"], { clearHistory: true });
    }
}
