import { Component, Input, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular/router";
import { SegmentedBarItem } from "ui/segmented-bar";
import { Rastreamento } from "../../shared/rastreamento.model";
import { ActivatedRoute } from '@angular/router';
import { RastreamentoService } from "../../shared/rastreamento.service";

@Component({
    selector: "passo4",
    moduleId: module.id,
    templateUrl: "./passo4.component.html",
    styleUrls: ['./passo4.component.css']
})
export class Passo4Component implements OnInit {
    @Input("rastreamento")
    public rastreamento: Rastreamento;
    acao: string;
    submitted: boolean;
    fatores: string;
    lesoes: string;

    constructor(private rastreamentoService: RastreamentoService, private route: ActivatedRoute, private routerExtensions: RouterExtensions) {
        this.route.params.subscribe(res => this.rastreamento = res.rastreamento);
    }

    ngOnInit(): void {
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

        finalizar() {
            this.rastreamentoService.finalizar(this.rastreamento).subscribe(
                response => {
                    alert("Rastreamento Salvo com Sucesso!!");
                }, err => { alert("Infelizmente, ocorreu um erro ao tentar salvar o Rastreamento."); });
        }

    }


