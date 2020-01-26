"use strict";
var core_1 = require("@angular/core");
var nativescript_module_1 = require("nativescript-angular/nativescript.module");
var app_routing_1 = require("./app.routing");
var app_component_1 = require("./app.component");
var forms_1 = require("nativescript-angular/forms");
var action_bar_component_1 = require("./action-bar/action-bar.component");
var home_component_1 = require("./home/home.component");
var dog_tab_component_1 = require("./dog-tab/dog-tab.component");
var dogs_component_1 = require("./dogs/dogs.component");
var dog_details_component_1 = require("./dog-details/dog-details.component");
var cat_tab_component_1 = require("./cat-tab/cat-tab.component");
var cats_component_1 = require("./cats/cats.component");
var cat_details_component_1 = require("./cat-details/cat-details.component");
var dog_service_1 = require("./dog.service");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        bootstrap: [
            app_component_1.AppComponent
        ],
        imports: [
            nativescript_module_1.NativeScriptModule,
            app_routing_1.AppRoutingModule,
            forms_1.NativeScriptFormsModule
        ],
        declarations: [
            app_component_1.AppComponent,
            action_bar_component_1.ActionBarComponent,
            home_component_1.HomeComponent,
            dog_tab_component_1.DogTabComponent,
            cat_tab_component_1.CatTabComponent,
            dogs_component_1.DogsComponent,
            dog_details_component_1.DogDetailsComponent,
            cats_component_1.CatsComponent,
            cat_details_component_1.CatDetailsComponent
        ],
        providers: [
            dog_service_1.DogService
        ],
        schemas: [
            core_1.NO_ERRORS_SCHEMA
        ]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYXBwLm1vZHVsZS5qcyIsInNvdXJjZVJvb3QiOiIiLCJzb3VyY2VzIjpbImFwcC5tb2R1bGUudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUFBLHNDQUEyRDtBQUMzRCxnRkFBOEU7QUFDOUUsNkNBQWlEO0FBQ2pELGlEQUErQztBQUUvQyxvREFBcUU7QUFFckUsMEVBQXVFO0FBRXZFLHdEQUFzRDtBQUN0RCxpRUFBOEQ7QUFDOUQsd0RBQXNEO0FBQ3RELDZFQUEwRTtBQUMxRSxpRUFBOEQ7QUFDOUQsd0RBQXNEO0FBQ3RELDZFQUEwRTtBQUUxRSw2Q0FBMkM7QUE2QjNDLElBQWEsU0FBUztJQUF0QjtJQUF5QixDQUFDO0lBQUQsZ0JBQUM7QUFBRCxDQUFDLEFBQTFCLElBQTBCO0FBQWIsU0FBUztJQTNCckIsZUFBUSxDQUFDO1FBQ04sU0FBUyxFQUFFO1lBQ1AsNEJBQVk7U0FDZjtRQUNELE9BQU8sRUFBRTtZQUNMLHdDQUFrQjtZQUNsQiw4QkFBZ0I7WUFDaEIsK0JBQXVCO1NBQzFCO1FBQ0QsWUFBWSxFQUFFO1lBQ1YsNEJBQVk7WUFDWix5Q0FBa0I7WUFDbEIsOEJBQWE7WUFDYixtQ0FBZTtZQUNmLG1DQUFlO1lBQ2YsOEJBQWE7WUFDYiwyQ0FBbUI7WUFDbkIsOEJBQWE7WUFDYiwyQ0FBbUI7U0FDdEI7UUFDRCxTQUFTLEVBQUU7WUFDUCx3QkFBVTtTQUNiO1FBQ0QsT0FBTyxFQUFFO1lBQ0wsdUJBQWdCO1NBQ25CO0tBQ0osQ0FBQztHQUNXLFNBQVMsQ0FBSTtBQUFiLDhCQUFTIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgTmdNb2R1bGUsIE5PX0VSUk9SU19TQ0hFTUEgfSBmcm9tIFwiQGFuZ3VsYXIvY29yZVwiO1xuaW1wb3J0IHsgTmF0aXZlU2NyaXB0TW9kdWxlIH0gZnJvbSBcIm5hdGl2ZXNjcmlwdC1hbmd1bGFyL25hdGl2ZXNjcmlwdC5tb2R1bGVcIjtcbmltcG9ydCB7IEFwcFJvdXRpbmdNb2R1bGUgfSBmcm9tIFwiLi9hcHAucm91dGluZ1wiO1xuaW1wb3J0IHsgQXBwQ29tcG9uZW50IH0gZnJvbSBcIi4vYXBwLmNvbXBvbmVudFwiO1xuXG5pbXBvcnQgeyBOYXRpdmVTY3JpcHRGb3Jtc01vZHVsZSB9IGZyb20gXCJuYXRpdmVzY3JpcHQtYW5ndWxhci9mb3Jtc1wiO1xuXG5pbXBvcnQgeyBBY3Rpb25CYXJDb21wb25lbnQgfSBmcm9tICcuL2FjdGlvbi1iYXIvYWN0aW9uLWJhci5jb21wb25lbnQnO1xuXG5pbXBvcnQgeyBIb21lQ29tcG9uZW50IH0gZnJvbSAnLi9ob21lL2hvbWUuY29tcG9uZW50JztcbmltcG9ydCB7IERvZ1RhYkNvbXBvbmVudCB9IGZyb20gJy4vZG9nLXRhYi9kb2ctdGFiLmNvbXBvbmVudCc7XG5pbXBvcnQgeyBEb2dzQ29tcG9uZW50IH0gZnJvbSAnLi9kb2dzL2RvZ3MuY29tcG9uZW50JztcbmltcG9ydCB7IERvZ0RldGFpbHNDb21wb25lbnQgfSBmcm9tICcuL2RvZy1kZXRhaWxzL2RvZy1kZXRhaWxzLmNvbXBvbmVudCc7XG5pbXBvcnQgeyBDYXRUYWJDb21wb25lbnQgfSBmcm9tICcuL2NhdC10YWIvY2F0LXRhYi5jb21wb25lbnQnO1xuaW1wb3J0IHsgQ2F0c0NvbXBvbmVudCB9IGZyb20gJy4vY2F0cy9jYXRzLmNvbXBvbmVudCc7XG5pbXBvcnQgeyBDYXREZXRhaWxzQ29tcG9uZW50IH0gZnJvbSAnLi9jYXQtZGV0YWlscy9jYXQtZGV0YWlscy5jb21wb25lbnQnO1xuXG5pbXBvcnQgeyBEb2dTZXJ2aWNlIH0gZnJvbSAnLi9kb2cuc2VydmljZSc7XG5cbkBOZ01vZHVsZSh7XG4gICAgYm9vdHN0cmFwOiBbXG4gICAgICAgIEFwcENvbXBvbmVudFxuICAgIF0sXG4gICAgaW1wb3J0czogW1xuICAgICAgICBOYXRpdmVTY3JpcHRNb2R1bGUsXG4gICAgICAgIEFwcFJvdXRpbmdNb2R1bGUsXG4gICAgICAgIE5hdGl2ZVNjcmlwdEZvcm1zTW9kdWxlXG4gICAgXSxcbiAgICBkZWNsYXJhdGlvbnM6IFtcbiAgICAgICAgQXBwQ29tcG9uZW50LFxuICAgICAgICBBY3Rpb25CYXJDb21wb25lbnQsXG4gICAgICAgIEhvbWVDb21wb25lbnQsXG4gICAgICAgIERvZ1RhYkNvbXBvbmVudCxcbiAgICAgICAgQ2F0VGFiQ29tcG9uZW50LFxuICAgICAgICBEb2dzQ29tcG9uZW50LFxuICAgICAgICBEb2dEZXRhaWxzQ29tcG9uZW50LFxuICAgICAgICBDYXRzQ29tcG9uZW50LFxuICAgICAgICBDYXREZXRhaWxzQ29tcG9uZW50XG4gICAgXSxcbiAgICBwcm92aWRlcnM6IFtcbiAgICAgICAgRG9nU2VydmljZVxuICAgIF0sXG4gICAgc2NoZW1hczogW1xuICAgICAgICBOT19FUlJPUlNfU0NIRU1BXG4gICAgXVxufSlcbmV4cG9ydCBjbGFzcyBBcHBNb2R1bGUgeyB9XG4iXX0=