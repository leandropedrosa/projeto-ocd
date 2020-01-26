import { Component, OnInit } from '@angular/core';
import {Person} from "../person";

@Component({
    selector: "test",
    templateUrl: "test.component.html",
})

export class TestComponent implements OnInit {

    private _client: Person;

    constructor(){

    }

    ngOnInit(){
        this._client = new Person("John", 23, "john@company.com", "New York", "5th Avenue", 11);
    }

    get TestClient(){
        console.log(JSON.stringify(this._client));
        return this._client;
    }

    public changeName(){
        this._client.name = "Michael";
    }
}