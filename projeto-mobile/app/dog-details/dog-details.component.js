"use strict";
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
require("rxjs/add/operator/switchMap");
var dog_service_1 = require("../dog.service");
var DogDetailsComponent = (function () {
    function DogDetailsComponent(route, router, dogService) {
        this.route = route;
        this.router = router;
        this.dogService = dogService;
    }
    DogDetailsComponent.prototype.ngOnInit = function () {
        var _this = this;
        // This approach allows us to navigate from dog-details to dog-details with a new dogId
        // forEach will be triggered every time new id is provided
        this.route.params
            .forEach(function (params) {
            _this.dogId = +params['id'];
            _this.dog = _this.dogService.getDog(_this.dogId);
        });
        // This approach picks the id only once.
        // When you navigate from dog-details to dog-details with a newId, that won't be recognised
        // this.dogId = +this.route.snapshot.params['id'];
        // this.dog = this.dogService.getDog(this.dogId);
    };
    DogDetailsComponent.prototype.goBack = function () {
        this.router.navigate([
            '/home', { outlets: { dogoutlet: ['dogs'] } }
        ]);
    };
    DogDetailsComponent.prototype.goToPreviousDog = function () {
        var newDogId = (this.dogId + 9) % 10;
        this.router.navigate([
            '/home', { outlets: { dogoutlet: ['dogs', newDogId] } }
        ]);
    };
    DogDetailsComponent.prototype.goToNextDog = function () {
        var newDogId = (this.dogId + 1) % 10;
        this.router.navigate([
            '/home', { outlets: { dogoutlet: ['dogs', newDogId] } }
        ]);
    };
    return DogDetailsComponent;
}());
DogDetailsComponent = __decorate([
    core_1.Component({
        selector: 'my-dog-details',
        templateUrl: './dog-details/dog-details.component.html'
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute,
        router_1.Router,
        dog_service_1.DogService])
], DogDetailsComponent);
exports.DogDetailsComponent = DogDetailsComponent;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiZG9nLWRldGFpbHMuY29tcG9uZW50LmpzIiwic291cmNlUm9vdCI6IiIsInNvdXJjZXMiOlsiZG9nLWRldGFpbHMuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFBQSxzQ0FBa0Q7QUFDbEQsMENBQXlEO0FBQ3pELHVDQUFxQztBQUVyQyw4Q0FBNEM7QUFNNUMsSUFBYSxtQkFBbUI7SUFJOUIsNkJBQ1UsS0FBcUIsRUFDckIsTUFBYyxFQUNkLFVBQXNCO1FBRnRCLFVBQUssR0FBTCxLQUFLLENBQWdCO1FBQ3JCLFdBQU0sR0FBTixNQUFNLENBQVE7UUFDZCxlQUFVLEdBQVYsVUFBVSxDQUFZO0lBQ2hDLENBQUM7SUFFRCxzQ0FBUSxHQUFSO1FBQUEsaUJBYUM7UUFaQyx1RkFBdUY7UUFDdkYsMERBQTBEO1FBQzFELElBQUksQ0FBQyxLQUFLLENBQUMsTUFBTTthQUNkLE9BQU8sQ0FBQyxVQUFBLE1BQU07WUFDYixLQUFJLENBQUMsS0FBSyxHQUFHLENBQUMsTUFBTSxDQUFDLElBQUksQ0FBQyxDQUFDO1lBQzNCLEtBQUksQ0FBQyxHQUFHLEdBQUcsS0FBSSxDQUFDLFVBQVUsQ0FBQyxNQUFNLENBQUMsS0FBSSxDQUFDLEtBQUssQ0FBQyxDQUFDO1FBQ2hELENBQUMsQ0FBQyxDQUFDO1FBRUwsd0NBQXdDO1FBQ3hDLDJGQUEyRjtRQUMzRixrREFBa0Q7UUFDbEQsaURBQWlEO0lBQ25ELENBQUM7SUFFTSxvQ0FBTSxHQUFiO1FBQ0UsSUFBSSxDQUFDLE1BQU0sQ0FBQyxRQUFRLENBQUM7WUFDbkIsT0FBTyxFQUFFLEVBQUUsT0FBTyxFQUFFLEVBQUUsU0FBUyxFQUFFLENBQUMsTUFBTSxDQUFDLEVBQUUsRUFBRTtTQUM5QyxDQUFDLENBQUE7SUFDSixDQUFDO0lBRU0sNkNBQWUsR0FBdEI7UUFDRSxJQUFNLFFBQVEsR0FBRyxDQUFDLElBQUksQ0FBQyxLQUFLLEdBQUcsQ0FBQyxDQUFDLEdBQUcsRUFBRSxDQUFDO1FBRXZDLElBQUksQ0FBQyxNQUFNLENBQUMsUUFBUSxDQUFDO1lBQ25CLE9BQU8sRUFBRSxFQUFFLE9BQU8sRUFBRSxFQUFFLFNBQVMsRUFBRSxDQUFDLE1BQU0sRUFBRSxRQUFRLENBQUMsRUFBRSxFQUFFO1NBQ3hELENBQUMsQ0FBQTtJQUNKLENBQUM7SUFFTSx5Q0FBVyxHQUFsQjtRQUNFLElBQU0sUUFBUSxHQUFHLENBQUMsSUFBSSxDQUFDLEtBQUssR0FBRyxDQUFDLENBQUMsR0FBRyxFQUFFLENBQUM7UUFDdkMsSUFBSSxDQUFDLE1BQU0sQ0FBQyxRQUFRLENBQUM7WUFDbkIsT0FBTyxFQUFFLEVBQUUsT0FBTyxFQUFFLEVBQUUsU0FBUyxFQUFFLENBQUMsTUFBTSxFQUFFLFFBQVEsQ0FBQyxFQUFFLEVBQUU7U0FDeEQsQ0FBQyxDQUFBO0lBQ0osQ0FBQztJQUNILDBCQUFDO0FBQUQsQ0FBQyxBQTdDRCxJQTZDQztBQTdDWSxtQkFBbUI7SUFKL0IsZ0JBQVMsQ0FBQztRQUNQLFFBQVEsRUFBRSxnQkFBZ0I7UUFDMUIsV0FBVyxFQUFFLDBDQUEwQztLQUMxRCxDQUFDO3FDQU1pQix1QkFBYztRQUNiLGVBQU07UUFDRix3QkFBVTtHQVByQixtQkFBbUIsQ0E2Qy9CO0FBN0NZLGtEQUFtQiIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IENvbXBvbmVudCwgT25Jbml0IH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQgeyBBY3RpdmF0ZWRSb3V0ZSwgUm91dGVyIH0gZnJvbSAnQGFuZ3VsYXIvcm91dGVyJztcbmltcG9ydCAncnhqcy9hZGQvb3BlcmF0b3Ivc3dpdGNoTWFwJztcblxuaW1wb3J0IHsgRG9nU2VydmljZSB9IGZyb20gJy4uL2RvZy5zZXJ2aWNlJztcblxuQENvbXBvbmVudCh7XG4gICAgc2VsZWN0b3I6ICdteS1kb2ctZGV0YWlscycsXG4gICAgdGVtcGxhdGVVcmw6ICcuL2RvZy1kZXRhaWxzL2RvZy1kZXRhaWxzLmNvbXBvbmVudC5odG1sJ1xufSlcbmV4cG9ydCBjbGFzcyBEb2dEZXRhaWxzQ29tcG9uZW50IGltcGxlbWVudHMgT25Jbml0e1xuICBwcml2YXRlIGRvZ0lkOiBudW1iZXI7XG4gIHB1YmxpYyBkb2c6IGFueTtcblxuICBjb25zdHJ1Y3RvcihcbiAgICBwcml2YXRlIHJvdXRlOiBBY3RpdmF0ZWRSb3V0ZSxcbiAgICBwcml2YXRlIHJvdXRlcjogUm91dGVyLFxuICAgIHByaXZhdGUgZG9nU2VydmljZTogRG9nU2VydmljZSkge1xuICB9XG5cbiAgbmdPbkluaXQoKSB7XG4gICAgLy8gVGhpcyBhcHByb2FjaCBhbGxvd3MgdXMgdG8gbmF2aWdhdGUgZnJvbSBkb2ctZGV0YWlscyB0byBkb2ctZGV0YWlscyB3aXRoIGEgbmV3IGRvZ0lkXG4gICAgLy8gZm9yRWFjaCB3aWxsIGJlIHRyaWdnZXJlZCBldmVyeSB0aW1lIG5ldyBpZCBpcyBwcm92aWRlZFxuICAgIHRoaXMucm91dGUucGFyYW1zXG4gICAgICAuZm9yRWFjaChwYXJhbXMgPT4ge1xuICAgICAgICB0aGlzLmRvZ0lkID0gK3BhcmFtc1snaWQnXTtcbiAgICAgICAgdGhpcy5kb2cgPSB0aGlzLmRvZ1NlcnZpY2UuZ2V0RG9nKHRoaXMuZG9nSWQpO1xuICAgICAgfSk7XG5cbiAgICAvLyBUaGlzIGFwcHJvYWNoIHBpY2tzIHRoZSBpZCBvbmx5IG9uY2UuXG4gICAgLy8gV2hlbiB5b3UgbmF2aWdhdGUgZnJvbSBkb2ctZGV0YWlscyB0byBkb2ctZGV0YWlscyB3aXRoIGEgbmV3SWQsIHRoYXQgd29uJ3QgYmUgcmVjb2duaXNlZFxuICAgIC8vIHRoaXMuZG9nSWQgPSArdGhpcy5yb3V0ZS5zbmFwc2hvdC5wYXJhbXNbJ2lkJ107XG4gICAgLy8gdGhpcy5kb2cgPSB0aGlzLmRvZ1NlcnZpY2UuZ2V0RG9nKHRoaXMuZG9nSWQpO1xuICB9XG5cbiAgcHVibGljIGdvQmFjaygpIHtcbiAgICB0aGlzLnJvdXRlci5uYXZpZ2F0ZShbXG4gICAgICAnL2hvbWUnLCB7IG91dGxldHM6IHsgZG9nb3V0bGV0OiBbJ2RvZ3MnXSB9IH1cbiAgICBdKVxuICB9XG5cbiAgcHVibGljIGdvVG9QcmV2aW91c0RvZygpIHtcbiAgICBjb25zdCBuZXdEb2dJZCA9ICh0aGlzLmRvZ0lkICsgOSkgJSAxMDtcblxuICAgIHRoaXMucm91dGVyLm5hdmlnYXRlKFtcbiAgICAgICcvaG9tZScsIHsgb3V0bGV0czogeyBkb2dvdXRsZXQ6IFsnZG9ncycsIG5ld0RvZ0lkXSB9IH1cbiAgICBdKVxuICB9XG5cbiAgcHVibGljIGdvVG9OZXh0RG9nKCkge1xuICAgIGNvbnN0IG5ld0RvZ0lkID0gKHRoaXMuZG9nSWQgKyAxKSAlIDEwO1xuICAgIHRoaXMucm91dGVyLm5hdmlnYXRlKFtcbiAgICAgICcvaG9tZScsIHsgb3V0bGV0czogeyBkb2dvdXRsZXQ6IFsnZG9ncycsIG5ld0RvZ0lkXSB9IH1cbiAgICBdKVxuICB9XG59XG4iXX0=