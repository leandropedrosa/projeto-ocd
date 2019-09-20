import { NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { NativeScriptCommonModule } from "nativescript-angular/common";
import { NativeScriptFormsModule } from "nativescript-angular/forms";

import { AcompanhamentoRoutingModule } from "./acompanhamento-routing.module";
import { Passo1Component } from "./passo1/passo1.component";
import { Passo2Component } from "./passo2/passo2.component";
import { Passo3Component } from "./passo3/passo3.component";
import { Passo4Component } from "./passo4/passo4.component";
import { DadosIniciaisService } from "../shared/dadosIniciais.service";
import { RastreamentoService } from "../shared/rastreamento.service";

@NgModule({
    imports: [
        NativeScriptCommonModule,
        NativeScriptFormsModule,
        AcompanhamentoRoutingModule
    ],
    declarations: [
        Passo1Component,
        Passo2Component,
        Passo3Component,
        Passo4Component,
    ],
    providers: [
        DadosIniciaisService,
        RastreamentoService,
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
})
export class AcompanhamentoModule { }
