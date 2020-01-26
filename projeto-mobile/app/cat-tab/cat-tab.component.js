"use strict";
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var CatTabComponent = (function () {
    function CatTabComponent(router) {
        this.router = router;
    }
    CatTabComponent.prototype.ngOnInit = function () {
    };
    CatTabComponent.prototype.navigateToRoot = function () {
        this.router.navigate([
            '/home',
            { outlets: { catoutlet: ['cats'] } }
        ]);
    };
    CatTabComponent.prototype.navigateToDetails = function (id) {
        this.router.navigate([
            '/home',
            { outlets: { catoutlet: ['cats', id] } }
        ]);
    };
    return CatTabComponent;
}());
CatTabComponent = __decorate([
    core_1.Component({
        selector: 'my-cat-tab',
        templateUrl: './cat-tab/cat-tab.component.html'
    }),
    __metadata("design:paramtypes", [router_1.Router])
], CatTabComponent);
exports.CatTabComponent = CatTabComponent;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiY2F0LXRhYi5jb21wb25lbnQuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJjYXQtdGFiLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQUEsc0NBQWtEO0FBQ2xELDBDQUF5QztBQU16QyxJQUFhLGVBQWU7SUFFMUIseUJBQW9CLE1BQWM7UUFBZCxXQUFNLEdBQU4sTUFBTSxDQUFRO0lBQ2xDLENBQUM7SUFFRCxrQ0FBUSxHQUFSO0lBQ0EsQ0FBQztJQUVELHdDQUFjLEdBQWQ7UUFDRSxJQUFJLENBQUMsTUFBTSxDQUFDLFFBQVEsQ0FBQztZQUNuQixPQUFPO1lBQ1AsRUFBRSxPQUFPLEVBQUUsRUFBRSxTQUFTLEVBQUUsQ0FBQyxNQUFNLENBQUMsRUFBRSxFQUFFO1NBQ3JDLENBQUMsQ0FBQztJQUNMLENBQUM7SUFFRCwyQ0FBaUIsR0FBakIsVUFBa0IsRUFBRTtRQUNsQixJQUFJLENBQUMsTUFBTSxDQUFDLFFBQVEsQ0FBQztZQUNuQixPQUFPO1lBQ1AsRUFBRSxPQUFPLEVBQUUsRUFBRSxTQUFTLEVBQUUsQ0FBQyxNQUFNLEVBQUUsRUFBRSxDQUFDLEVBQUUsRUFBRTtTQUN6QyxDQUFDLENBQUM7SUFDTCxDQUFDO0lBQ0gsc0JBQUM7QUFBRCxDQUFDLEFBckJELElBcUJDO0FBckJZLGVBQWU7SUFKM0IsZ0JBQVMsQ0FBQztRQUNQLFFBQVEsRUFBRSxZQUFZO1FBQ3RCLFdBQVcsRUFBRSxrQ0FBa0M7S0FDbEQsQ0FBQztxQ0FHNEIsZUFBTTtHQUZ2QixlQUFlLENBcUIzQjtBQXJCWSwwQ0FBZSIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IENvbXBvbmVudCwgT25Jbml0IH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQgeyBSb3V0ZXIgfSBmcm9tICdAYW5ndWxhci9yb3V0ZXInO1xuXG5AQ29tcG9uZW50KHtcbiAgICBzZWxlY3RvcjogJ215LWNhdC10YWInLFxuICAgIHRlbXBsYXRlVXJsOiAnLi9jYXQtdGFiL2NhdC10YWIuY29tcG9uZW50Lmh0bWwnXG59KVxuZXhwb3J0IGNsYXNzIENhdFRhYkNvbXBvbmVudCBpbXBsZW1lbnRzIE9uSW5pdHtcblxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIHJvdXRlcjogUm91dGVyKSB7XG4gIH1cblxuICBuZ09uSW5pdCgpIHtcbiAgfVxuXG4gIG5hdmlnYXRlVG9Sb290KCkge1xuICAgIHRoaXMucm91dGVyLm5hdmlnYXRlKFtcbiAgICAgICcvaG9tZScsXG4gICAgICB7IG91dGxldHM6IHsgY2F0b3V0bGV0OiBbJ2NhdHMnXSB9IH1cbiAgICBdKTtcbiAgfVxuICBcbiAgbmF2aWdhdGVUb0RldGFpbHMoaWQpIHtcbiAgICB0aGlzLnJvdXRlci5uYXZpZ2F0ZShbXG4gICAgICAnL2hvbWUnLFxuICAgICAgeyBvdXRsZXRzOiB7IGNhdG91dGxldDogWydjYXRzJywgaWRdIH0gfVxuICAgIF0pO1xuICB9XG59XG4iXX0=