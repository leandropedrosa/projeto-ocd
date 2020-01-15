import {Injectable} from "@angular/core";

var Sqlite = require("nativescript-sqlite");

@Injectable()
export class DatabaseService {
    private DB_NAME: String = 'SobreVida';

    public getdbConnection() {

        if(Sqlite === null){
            Sqlite = new Sqlite(this.DB_NAME);
        }
        return Sqlite
    }

    public closedbConnection() {
        new Sqlite(this.DB_NAME)
            .then((db) => {
                db.close();
            });
    }
}