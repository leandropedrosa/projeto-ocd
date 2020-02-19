import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ModalDialogParams, RouterExtensions} from "nativescript-angular";
import {Page} from "tns-core-modules/ui/page";
import {SearchBar} from "tns-core-modules/ui/search-bar";
import {ObservableArray} from "tns-core-modules/data/observable-array";
import {isAndroid} from "tns-core-modules/platform";

class DataItem {
	constructor(public name: string) {
	}
}

@Component({
	selector: 'ns-search-airport',
	templateUrl: './search-airport.component.html',
	styleUrls: ['./search-airport.component.css'],
	moduleId: module.id,
})
export class SearchAirportComponent implements OnInit {
	private _searchedText: string = '';
	private arrayAirports: Array<DataItem> = [];
	public airports: ObservableArray<DataItem> = new ObservableArray<DataItem>();
	public isFrom: boolean = false;

	constructor(private _params: ModalDialogParams, private _page: Page, private router: RouterExtensions, private _activeRoute: ActivatedRoute) {
		this.arrayAirports.push(new DataItem("Rotterdam The Hague Airport"));
		this.arrayAirports.push(new DataItem("Chiclayo Capitán FAP José Quiñones G. Airport"));
		this.arrayAirports.push(new DataItem("Lima Jorge Chávez International Airport"));
		this.arrayAirports.push(new DataItem("Arequipa Rodríguez Ballón Airport"));
		this.arrayAirports.push(new DataItem("Cuzco Alejandro Velazco Astete Airport"));
		this.arrayAirports.push(new DataItem("Atlanta Hartsfield-Jackson International Airport"));
		this.arrayAirports.push(new DataItem("New York John F. Kennedy International Airport"));
		this.arrayAirports.push(new DataItem("New York LaGuardia Airport"));
		this.arrayAirports.push(new DataItem("San Diego International Airport"));

		this.airports = new ObservableArray<DataItem>(this.arrayAirports);

		this.isFrom = this._params.context.isFrom;
	}

	ngOnInit() {
	}

	onClose(): void {
		this._params.closeCallback("return value");
	}

	onSelectItem(args) {
		let airport = (this._searchedText !== "") ? this.airports.getItem(args.index) : this.arrayAirports[args.index];
		this._params.closeCallback({
			isFrom: this.isFrom,
			airport
		});
	}

	public onSubmit(args) {
		let searchBar = <SearchBar>args.object;
		let searchValue = searchBar.text.toLowerCase();
		this._searchedText = searchValue;

		this.airports = new ObservableArray<DataItem>();
		if (searchValue !== "") {
			for (let i = 0; i < this.arrayAirports.length; i++) {
				if (this.arrayAirports[i].name.toLowerCase().indexOf(searchValue) !== -1) {
					this.airports.push(this.arrayAirports[i]);
				}
			}
		}
	}

	public searchBarLoaded(args) {
		let searchBar = <SearchBar>args.object;
		searchBar.dismissSoftInput();

		if (isAndroid) {
			searchBar.android.clearFocus();
		}

		searchBar.text = "";
	}

	public onClear(args) {
		let searchBar = <SearchBar>args.object;
		searchBar.text = "";
		searchBar.hint = "Search for a airport";

		this.airports = new ObservableArray<DataItem>();
		this.arrayAirports.forEach(item => {
			this.airports.push(item);
		});
	}

	public onTextChanged(args) {
		this.onSubmit(args);
	}
}
