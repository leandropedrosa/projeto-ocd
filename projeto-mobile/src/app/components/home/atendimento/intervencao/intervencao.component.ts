import {Component, OnInit} from "@angular/core";
class DataItem {
    constructor(public id: number,
                public description: string) {
    }
}
@Component({
    selector: "intervencao",
    moduleId: module.id,
    templateUrl: "./intervencao.component.html",
    styleUrls: ["./intervencao.component.css"]
})
export class IntervencaoComponent implements OnInit {

    public dataList = [];

    constructor() {
        this.dataList.push(new DataItem(1, 'Biopsia Incisional'));
        this.dataList.push(new DataItem(1, 'Biopsia Exisional'));
        this.dataList.push(new DataItem(1, 'Citologia'));
        this.dataList.push(new DataItem(1, 'Histopatológico'));
        this.dataList.push(new DataItem(1, 'Outros'));
    }

    ngOnInit(): void {

    }

    salvar() {
    }
}
