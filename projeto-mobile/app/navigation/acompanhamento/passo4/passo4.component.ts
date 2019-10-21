import {Component, Input, OnInit} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {RastreamentoService} from "../../../shared/rastreamento.service";
import {Rastreamento} from "../../../shared/rastreamento.model";

@Component({
    selector: "passo4",
    moduleId: module.id,
    templateUrl: "./passo4.component.html",
    styleUrls: ['./passo4.component.css']
})
export class Passo4Component implements OnInit {
    public acao: string;
    submitted: boolean;
    public fatores: string;
    public lesoes: string;
    public rastreamento: Rastreamento;

    constructor(private rastreamentoService: RastreamentoService, private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe(params => {
            this.rastreamento =  JSON.parse(params['matriciamento']);
        });

        console.log(this.rastreamento);
        this.acao = "PASSO4";
        for (let i = 0; i < this.rastreamento.listFatoresRisco.length; i++) {

            if (i == 0) {
                this.fatores += this.rastreamento.listFatoresRisco[0].nome += ", ";
            }
            if (i < 0 && this.rastreamento.listFatoresRisco.length - 1) {
                this.fatores += this.rastreamento.listFatoresRisco[0].nome;
                if (this.rastreamento.listFatoresRisco.length != i)
                    this.fatores += ", ";
            }
        }

        for (let j = 0; j < this.rastreamento.listFatoresRisco.length; j++) {
            if (j == 0) {
                this.lesoes += this.rastreamento.listPresencaLesao[0].nome += ", ";
            }
            if (j < 0 && this.rastreamento.listPresencaLesao.length - 1) {
                this.lesoes += this.rastreamento.listPresencaLesao[0].nome;
                if (this.rastreamento.listPresencaLesao.length != j)
                    this.lesoes += ", ";
            }
        }
    }

    continuarFluxo(opcao: string) {
        this.acao = opcao;
    }

    finalizar() {
        this.rastreamentoService.finalizar(this.rastreamento).subscribe(
            response => {
                alert("Rastreamento Salvo com Sucesso!!");
            }, err => {
                alert("Infelizmente, ocorreu um erro ao tentar salvar o Rastreamento.");
            });
    }

}


