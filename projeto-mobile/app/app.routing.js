"use strict";
var core_1 = require("@angular/core");
var router_1 = require("nativescript-angular/router");
var home_component_1 = require("./home/home.component");
var dogs_component_1 = require("./dogs/dogs.component");
var dog_details_component_1 = require("./dog-details/dog-details.component");
var cats_component_1 = require("./cats/cats.component");
var cat_details_component_1 = require("./cat-details/cat-details.component");
var routes = [
    { path: '', redirectTo: '/home/(catoutlet:cats//dogoutlet:dogs)', pathMatch: 'full' },
    { path: 'home', component: home_component_1.HomeComponent, children: [
            { path: 'cats', component: cats_component_1.CatsComponent, outlet: 'catoutlet' },
            { path: 'cats/:name', component: cat_details_component_1.CatDetailsComponent, outlet: 'catoutlet' },
            { path: 'dogs', component: dogs_component_1.DogsComponent, outlet: 'dogoutlet' },
            { path: 'dogs/:id', component: dog_details_component_1.DogDetailsComponent, outlet: 'dogoutlet' }
        ] }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    return AppRoutingModule;
}());
AppRoutingModule = __decorate([
    core_1.NgModule({
        imports: [router_1.NativeScriptRouterModule.forRoot(routes)],
        exports: [router_1.NativeScriptRouterModule]
    })
], AppRoutingModule);
exports.AppRoutingModule = AppRoutingModule;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYXBwLnJvdXRpbmcuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJhcHAucm91dGluZy50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQUEsc0NBQXlDO0FBQ3pDLHNEQUF1RTtBQUd2RSx3REFBc0Q7QUFDdEQsd0RBQXNEO0FBQ3RELDZFQUEwRTtBQUMxRSx3REFBc0Q7QUFDdEQsNkVBQTBFO0FBRTFFLElBQU0sTUFBTSxHQUFXO0lBQ3JCLEVBQUUsSUFBSSxFQUFFLEVBQUUsRUFBRSxVQUFVLEVBQUUsd0NBQXdDLEVBQUUsU0FBUyxFQUFFLE1BQU0sRUFBRTtJQUNyRixFQUFFLElBQUksRUFBRSxNQUFNLEVBQUUsU0FBUyxFQUFFLDhCQUFhLEVBQUUsUUFBUSxFQUFFO1lBQ2xELEVBQUUsSUFBSSxFQUFFLE1BQU0sRUFBRSxTQUFTLEVBQUUsOEJBQWEsRUFBRSxNQUFNLEVBQUUsV0FBVyxFQUFDO1lBQzlELEVBQUUsSUFBSSxFQUFFLFlBQVksRUFBRSxTQUFTLEVBQUUsMkNBQW1CLEVBQUUsTUFBTSxFQUFFLFdBQVcsRUFBQztZQUMxRSxFQUFFLElBQUksRUFBRSxNQUFNLEVBQUUsU0FBUyxFQUFFLDhCQUFhLEVBQUUsTUFBTSxFQUFFLFdBQVcsRUFBQztZQUM5RCxFQUFFLElBQUksRUFBRSxVQUFVLEVBQUUsU0FBUyxFQUFFLDJDQUFtQixFQUFFLE1BQU0sRUFBRSxXQUFXLEVBQUM7U0FDekUsRUFBQztDQUNILENBQUM7QUFNRixJQUFhLGdCQUFnQjtJQUE3QjtJQUFnQyxDQUFDO0lBQUQsdUJBQUM7QUFBRCxDQUFDLEFBQWpDLElBQWlDO0FBQXBCLGdCQUFnQjtJQUo1QixlQUFRLENBQUM7UUFDUixPQUFPLEVBQUUsQ0FBQyxpQ0FBd0IsQ0FBQyxPQUFPLENBQUMsTUFBTSxDQUFDLENBQUM7UUFDbkQsT0FBTyxFQUFFLENBQUMsaUNBQXdCLENBQUM7S0FDcEMsQ0FBQztHQUNXLGdCQUFnQixDQUFJO0FBQXBCLDRDQUFnQiIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IE5nTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQgeyBOYXRpdmVTY3JpcHRSb3V0ZXJNb2R1bGUgfSBmcm9tICduYXRpdmVzY3JpcHQtYW5ndWxhci9yb3V0ZXInO1xuaW1wb3J0IHsgUm91dGVzIH0gZnJvbSAnQGFuZ3VsYXIvcm91dGVyJztcblxuaW1wb3J0IHsgSG9tZUNvbXBvbmVudCB9IGZyb20gJy4vaG9tZS9ob21lLmNvbXBvbmVudCc7XG5pbXBvcnQgeyBEb2dzQ29tcG9uZW50IH0gZnJvbSAnLi9kb2dzL2RvZ3MuY29tcG9uZW50JztcbmltcG9ydCB7IERvZ0RldGFpbHNDb21wb25lbnQgfSBmcm9tICcuL2RvZy1kZXRhaWxzL2RvZy1kZXRhaWxzLmNvbXBvbmVudCc7XG5pbXBvcnQgeyBDYXRzQ29tcG9uZW50IH0gZnJvbSAnLi9jYXRzL2NhdHMuY29tcG9uZW50JztcbmltcG9ydCB7IENhdERldGFpbHNDb21wb25lbnQgfSBmcm9tICcuL2NhdC1kZXRhaWxzL2NhdC1kZXRhaWxzLmNvbXBvbmVudCc7XG5cbmNvbnN0IHJvdXRlczogUm91dGVzID0gW1xuICB7IHBhdGg6ICcnLCByZWRpcmVjdFRvOiAnL2hvbWUvKGNhdG91dGxldDpjYXRzLy9kb2dvdXRsZXQ6ZG9ncyknLCBwYXRoTWF0Y2g6ICdmdWxsJyB9LFxuICB7IHBhdGg6ICdob21lJywgY29tcG9uZW50OiBIb21lQ29tcG9uZW50LCBjaGlsZHJlbjogW1xuICAgIHsgcGF0aDogJ2NhdHMnLCBjb21wb25lbnQ6IENhdHNDb21wb25lbnQsIG91dGxldDogJ2NhdG91dGxldCd9LFxuICAgIHsgcGF0aDogJ2NhdHMvOm5hbWUnLCBjb21wb25lbnQ6IENhdERldGFpbHNDb21wb25lbnQsIG91dGxldDogJ2NhdG91dGxldCd9LFxuICAgIHsgcGF0aDogJ2RvZ3MnLCBjb21wb25lbnQ6IERvZ3NDb21wb25lbnQsIG91dGxldDogJ2RvZ291dGxldCd9LFxuICAgIHsgcGF0aDogJ2RvZ3MvOmlkJywgY29tcG9uZW50OiBEb2dEZXRhaWxzQ29tcG9uZW50LCBvdXRsZXQ6ICdkb2dvdXRsZXQnfVxuICBdfVxuXTtcblxuQE5nTW9kdWxlKHtcbiAgaW1wb3J0czogW05hdGl2ZVNjcmlwdFJvdXRlck1vZHVsZS5mb3JSb290KHJvdXRlcyldLFxuICBleHBvcnRzOiBbTmF0aXZlU2NyaXB0Um91dGVyTW9kdWxlXVxufSlcbmV4cG9ydCBjbGFzcyBBcHBSb3V0aW5nTW9kdWxlIHsgfSJdfQ==