import {Component, EventEmitter, Input, OnInit, Output, ViewContainerRef} from '@angular/core';
import {ModalDialogOptions, ModalDialogService} from "nativescript-angular";
import {SearchAirportComponent} from "../search-airport/search-airport.component";
import {action} from "tns-core-modules/ui/dialogs";
import {Page} from "tns-core-modules/ui/page";
import {GridLayout} from "tns-core-modules/ui/layouts/grid-layout";

@Component({
	selector: 'cadastro-paciente',
	templateUrl: './cadastro-paciente.component.html',
	styleUrls: ['./cadastro-paciente.component.css'],
	moduleId: module.id,
	providers: [ModalDialogService],
})
export class CadastroPacienteComponent implements OnInit {
	public showReturn: boolean = false;
	public fromAirport: string = '';
	public toAirport: string = '';
	public typeOfService: string = '';
	public departureDate = new Date();
	public returnDate = new Date();

	private _overlayGridLayout: GridLayout;
	@Output() openSelectDate = new EventEmitter();
	@Input() isOnOpenDepartureDate;

	constructor(private _modalService: ModalDialogService,
		private _vcRef: ViewContainerRef,
		private page: Page) {
		this._overlayGridLayout = this.page.getViewById('overlayGridLayout');
	}

	ngOnInit() {
		this.returnDate.setDate(this.departureDate.getDate() + 2);
	}

	@Input()
	set selectedDate(selectedDate: Date) {
		if (selectedDate) {
			if (this.isOnOpenDepartureDate) {
				this.departureDate = selectedDate;
			} else {
				this.returnDate = selectedDate;
			}
		}
	}

	toggleReturn() {
		this.showReturn = !this.showReturn;
	}

	onOpenSearchAirportTap(isFrom: boolean): void {
		const options: ModalDialogOptions = {
			viewContainerRef: this._vcRef,
			context: { isFrom },
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

	onTypeServiceTap(): void {
		let options = {
			title: "Selecione o sexo",
			message: "Escolha o seu sexo",
			cancelButtonText: "Cancelar",
			actions: ["Masculino", "Feminino"]
		};

		action(options).then((result) => {
			this.typeOfService = (result == 'Cancel') ? this.typeOfService : result;
		});
	}

	onOpenSelectDate(isOnOpenDepartureDate: boolean): void {
		this.openSelectDate.emit(isOnOpenDepartureDate);
	}

}
