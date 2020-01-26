"use strict";
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var dog_service_1 = require("../dog.service");
var DogsComponent = (function () {
    function DogsComponent(router, dogService) {
        this.router = router;
        this.dogService = dogService;
    }
    DogsComponent.prototype.ngOnInit = function () {
        this.dogs = this.dogService.getDogs();
    };
    DogsComponent.prototype.navigateToDetails = function (id) {
        this.router.navigate([
            '/home', { outlets: { dogoutlet: ['dogs', id] } }
        ]);
    };
    return DogsComponent;
}());
DogsComponent = __decorate([
    core_1.Component({
        selector: 'my-dogs',
        templateUrl: './dogs/dogs.component.html'
    }),
    __metadata("design:paramtypes", [router_1.Router, dog_service_1.DogService])
], DogsComponent);
exports.DogsComponent = DogsComponent;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiZG9ncy5jb21wb25lbnQuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJkb2dzLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQUEsc0NBQWtEO0FBQ2xELDBDQUF5QztBQUN6Qyw4Q0FBNEM7QUFNNUMsSUFBYSxhQUFhO0lBR3hCLHVCQUFvQixNQUFjLEVBQVUsVUFBc0I7UUFBOUMsV0FBTSxHQUFOLE1BQU0sQ0FBUTtRQUFVLGVBQVUsR0FBVixVQUFVLENBQVk7SUFDbEUsQ0FBQztJQUVELGdDQUFRLEdBQVI7UUFDRSxJQUFJLENBQUMsSUFBSSxHQUFHLElBQUksQ0FBQyxVQUFVLENBQUMsT0FBTyxFQUFFLENBQUM7SUFDeEMsQ0FBQztJQUVELHlDQUFpQixHQUFqQixVQUFrQixFQUFVO1FBQzFCLElBQUksQ0FBQyxNQUFNLENBQUMsUUFBUSxDQUFDO1lBQ25CLE9BQU8sRUFBRSxFQUFFLE9BQU8sRUFBRSxFQUFFLFNBQVMsRUFBRSxDQUFDLE1BQU0sRUFBRSxFQUFFLENBQUMsRUFBRSxFQUFFO1NBQ2xELENBQUMsQ0FBQTtJQUNKLENBQUM7SUFDSCxvQkFBQztBQUFELENBQUMsQUFmRCxJQWVDO0FBZlksYUFBYTtJQUp6QixnQkFBUyxDQUFDO1FBQ1AsUUFBUSxFQUFFLFNBQVM7UUFDbkIsV0FBVyxFQUFFLDRCQUE0QjtLQUM1QyxDQUFDO3FDQUk0QixlQUFNLEVBQXNCLHdCQUFVO0dBSHZELGFBQWEsQ0FlekI7QUFmWSxzQ0FBYSIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IENvbXBvbmVudCwgT25Jbml0IH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQgeyBSb3V0ZXIgfSBmcm9tICdAYW5ndWxhci9yb3V0ZXInO1xuaW1wb3J0IHsgRG9nU2VydmljZSB9IGZyb20gJy4uL2RvZy5zZXJ2aWNlJztcblxuQENvbXBvbmVudCh7XG4gICAgc2VsZWN0b3I6ICdteS1kb2dzJyxcbiAgICB0ZW1wbGF0ZVVybDogJy4vZG9ncy9kb2dzLmNvbXBvbmVudC5odG1sJ1xufSlcbmV4cG9ydCBjbGFzcyBEb2dzQ29tcG9uZW50IHtcbiAgcHVibGljIGRvZ3M6IEFycmF5PGFueT47XG5cbiAgY29uc3RydWN0b3IocHJpdmF0ZSByb3V0ZXI6IFJvdXRlciwgcHJpdmF0ZSBkb2dTZXJ2aWNlOiBEb2dTZXJ2aWNlKSB7XG4gIH1cblxuICBuZ09uSW5pdCgpIHtcbiAgICB0aGlzLmRvZ3MgPSB0aGlzLmRvZ1NlcnZpY2UuZ2V0RG9ncygpO1xuICB9XG5cbiAgbmF2aWdhdGVUb0RldGFpbHMoaWQ6IG51bWJlcikge1xuICAgIHRoaXMucm91dGVyLm5hdmlnYXRlKFtcbiAgICAgICcvaG9tZScsIHsgb3V0bGV0czogeyBkb2dvdXRsZXQ6IFsnZG9ncycsIGlkXSB9IH1cbiAgICBdKVxuICB9XG59Il19