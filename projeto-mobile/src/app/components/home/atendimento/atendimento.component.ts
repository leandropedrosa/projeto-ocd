import {Component, OnInit, ViewChild} from "@angular/core";
import {RouterExtensions} from "nativescript-angular/router";
import {TokenModel} from "nativescript-ui-autocomplete";
import {RadAutoCompleteTextViewComponent} from "nativescript-ui-autocomplete/angular";
import {ObservableArray} from "@nativescript/core";
import {ModalDialogService} from "@nativescript/angular";
import {action} from "@nativescript/core/ui/dialogs";
@Component({
    selector: "atendimento",
    moduleId: module.id,
    templateUrl: "./atendimento.component.html",
    styleUrls: ["./atendimento.component.css"],
    providers: [ModalDialogService],
})
export class AtendimentoComponent implements OnInit {
    private _items: ObservableArray<TokenModel>;
    data = [];
    public typeOfService: string = '';
    private countries = ["Australia", "Albania", "Austria", "Argentina", "Maldives", "Bulgaria", "Belgium", "Cyprus", "Italy", "Japan",
        "Denmark", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland",
        "Latvia", "Luxembourg", "Macedonia", "Moldova", "Monaco", "Netherlands", "Norway",
        "Poland", "Romania", "Russia", "Sweden", "Slovenia", "Slovakia", "Turkey", "Ukraine",
        "Vatican City", "Chad", "China", "Chile"];
    ngOnInit(): void {
        this.data.push({ heading: "Retorno", content: "Squirtle’s shell is not merely used for protection.", icon:"&#xf007;", classe: "fa menu-icon" });
        this.data.push({ heading: "Retorno", content: "Its tail is large and covered with a rich, thick fur.", icon:"&#xf007;", classe: "fa menu-icon" });
        this.data.push({ heading: "Primeiro atendimento", content: "Blastoise has water spouts that protrude from its shell.", icon:"&#xf007;", classe: "fa menu-icon" });
    }
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

    onTypeServiceTap(): void {
        let options = {
            title: "Selecione o tipo de atendimento",
            message: "Escolha o atendimento",
            cancelButtonText: "Cancelar",
            actions: ["Acompanhamento", "Intervenção", "Resultados"]
        };

        action(options).then((result) => {
            if(result == 'Cancelar'){
                this.typeOfService
            }else{
                this.routerExtensions.navigate([this.retornaAtendimento(result)], { clearHistory: true });
            }
        });
    }
    retornaAtendimento(result){
        switch (result) {
            case "Acompanhamento": return "rastreamento";
            case "Intervenção": return "intervencao";
            case "Resultados": return "rastreamento";
            default: return "rastreamento";

        }
    }
}
