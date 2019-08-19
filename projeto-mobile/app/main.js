"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// this import should be first in order to load some required settings (like globals and reflect-metadata)
var platform_1 = require("nativescript-angular/platform");
var core_1 = require("@angular/core");
var app_module_1 = require("./app.module");
core_1.enableProdMode();
platform_1.platformNativeScriptDynamic().bootstrapModule(app_module_1.AppModule);
