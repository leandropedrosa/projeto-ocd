import {Injectable} from "@angular/core";
import {environment} from "../../../environments/environment";
import {ScriptsMobileModel} from "~/shared/model/scriptsMobile.model";

var Sqlite = require("nativescript-sqlite");

@Injectable()
export class DatabaseService {

    private static getdbConnection() {

        if (Sqlite === null) {
            Sqlite = new Sqlite(environment.DB_NAME);
        }
        return Sqlite
    }

    private static closedbConnection() {
        new Sqlite(environment.DB_NAME)
            .then((db) => {
                db.close();
            });
    }

    public static executeScript(scripts: Array<ScriptsMobileModel>) {
        this.getdbConnection()
            .then(db => {
                for (let i = 0; i < scripts.length; i++) {
                    db.execSQL(scripts[i].script).then(() => {
                    }, error => {
                        console.log("ERROR SCRIPT TABLE " + scripts[i].tabela + " ERROR", error);
                    });
                }
                db.closedbConnection();
            }, error => {
                console.log("OPEN DB ERROR", error);
                this.closedbConnection();
            });
    }

    public static getVersaoDoBanco() {
        this.getdbConnection()
            .then(db => {
                    db.execSQL("SELECT * FROM versao_banco");
                }, error => {
                    console.log("ERROR SCRIPT TABLE VERSAO_BANCO ERROR", error);
                }
            ), error => {
            console.log("OPEN DB ERROR", error);
            this.closedbConnection();
        }
    }
}