import {Component, EventEmitter, Input, OnInit, Output, ViewContainerRef} from '@angular/core';
import {ModalDialogOptions, ModalDialogService} from "@nativescript/angular";
import {GridLayout, Page} from "@nativescript/core";
import {SearchAirportComponent} from "~/app/components/home/atendimento/rastreamento/search-airport/search-airport.component";

@Component({
    selector: 'conduta',
    templateUrl: './conduta.component.html',
    styleUrls: ['./conduta.component.css'],
    moduleId: module.id,
    providers: [ModalDialogService],
})
export class CondutaComponent implements OnInit {
    public fromAirport: string = 'Unidade de saúde';
    public toAirport: string = '';
    public acompanhamentoDate = new Date();
    public tratamentoDate = new Date();
    private _overlayGridLayout: GridLayout;
    @Input() isOnOpenDepartureDate;

    constructor(private _modalService: ModalDialogService,
                private _vcRef: ViewContainerRef,
                private page: Page) {
        this._overlayGridLayout = this.page.getViewById('overlayGridLayout');
    }

    @Output() openSelectDate = new EventEmitter();

    ngOnInit() {
    }

    onOpenSearchAirportTap(isFrom: boolean): void {
        const options: ModalDialogOptions = {
            viewContainerRef: this._vcRef,
            context: {isFrom},
            fullscreen: true
        };

        this._modalService.showModal(SearchAirportComponent, options)
            .then((result: any) => {
                if (result.isFrom) {
                    this.fromAirport = result.airport.name;
                } else {
                    this.toAirport = result.airport.name;
                }
            });
    }

    @Input()
    set selectedDate(selectedDate: Date) {
        this.acompanhamentoDate = selectedDate;
        this.tratamentoDate = selectedDate;
    }

    onOpenSelectDate(isOnOpenDepartureDate: boolean): void {
        this.openSelectDate.emit(isOnOpenDepartureDate);
    }
}
