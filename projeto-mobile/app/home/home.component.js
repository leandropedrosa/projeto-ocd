"use strict";
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var HomeComponent = (function () {
    function HomeComponent(router) {
        this.router = router;
        this.selectedIndex = 0;
    }
    HomeComponent.prototype.navigateToDogsRoot = function () {
        this.router.navigate([
            '/home',
            { outlets: { dogoutlet: ['dogs'] } }
        ]);
    };
    HomeComponent.prototype.navigateToCatsRoot = function () {
        this.router.navigate([
            '/home',
            { outlets: { catoutlet: ['cats'] } }
        ]);
    };
    HomeComponent.prototype.tabViewIndexChange = function (index) {
        switch (index) {
            case 0:
                this.navigateToDogsRoot();
                break;
            case 1:
                this.navigateToCatsRoot();
                break;
        }
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    core_1.Component({
        selector: 'my-home',
        templateUrl: './home/home.component.html'
    }),
    __metadata("design:paramtypes", [router_1.Router])
], HomeComponent);
exports.HomeComponent = HomeComponent;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiaG9tZS5jb21wb25lbnQuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJob21lLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQUEsc0NBQTBDO0FBRTFDLDBDQUF5QztBQU16QyxJQUFhLGFBQWE7SUFHeEIsdUJBQW9CLE1BQWM7UUFBZCxXQUFNLEdBQU4sTUFBTSxDQUFRO1FBRjNCLGtCQUFhLEdBQVcsQ0FBQyxDQUFDO0lBR2pDLENBQUM7SUFFRCwwQ0FBa0IsR0FBbEI7UUFDRSxJQUFJLENBQUMsTUFBTSxDQUFDLFFBQVEsQ0FBQztZQUNuQixPQUFPO1lBQ1AsRUFBRSxPQUFPLEVBQUUsRUFBRSxTQUFTLEVBQUUsQ0FBQyxNQUFNLENBQUMsRUFBRSxFQUFFO1NBQ3JDLENBQUMsQ0FBQztJQUNMLENBQUM7SUFDRCwwQ0FBa0IsR0FBbEI7UUFDRSxJQUFJLENBQUMsTUFBTSxDQUFDLFFBQVEsQ0FBQztZQUNuQixPQUFPO1lBQ1AsRUFBRSxPQUFPLEVBQUUsRUFBRSxTQUFTLEVBQUUsQ0FBQyxNQUFNLENBQUMsRUFBRSxFQUFFO1NBQ3JDLENBQUMsQ0FBQztJQUNMLENBQUM7SUFFRCwwQ0FBa0IsR0FBbEIsVUFBbUIsS0FBYTtRQUM5QixNQUFNLENBQUEsQ0FBQyxLQUFLLENBQUMsQ0FBQyxDQUFDO1lBQ2IsS0FBSyxDQUFDO2dCQUNKLElBQUksQ0FBQyxrQkFBa0IsRUFBRSxDQUFDO2dCQUMxQixLQUFLLENBQUM7WUFDUixLQUFLLENBQUM7Z0JBQ0osSUFBSSxDQUFDLGtCQUFrQixFQUFFLENBQUM7Z0JBQzFCLEtBQUssQ0FBQztRQUNWLENBQUM7SUFDSCxDQUFDO0lBQ0gsb0JBQUM7QUFBRCxDQUFDLEFBN0JELElBNkJDO0FBN0JZLGFBQWE7SUFKekIsZ0JBQVMsQ0FBQztRQUNQLFFBQVEsRUFBRSxTQUFTO1FBQ25CLFdBQVcsRUFBRSw0QkFBNEI7S0FDNUMsQ0FBQztxQ0FJNEIsZUFBTTtHQUh2QixhQUFhLENBNkJ6QjtBQTdCWSxzQ0FBYSIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IENvbXBvbmVudCB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuXG5pbXBvcnQgeyBSb3V0ZXIgfSBmcm9tICdAYW5ndWxhci9yb3V0ZXInO1xuXG5AQ29tcG9uZW50KHtcbiAgICBzZWxlY3RvcjogJ215LWhvbWUnLFxuICAgIHRlbXBsYXRlVXJsOiAnLi9ob21lL2hvbWUuY29tcG9uZW50Lmh0bWwnXG59KVxuZXhwb3J0IGNsYXNzIEhvbWVDb21wb25lbnQge1xuICBwdWJsaWMgc2VsZWN0ZWRJbmRleDogbnVtYmVyID0gMDtcbiAgXG4gIGNvbnN0cnVjdG9yKHByaXZhdGUgcm91dGVyOiBSb3V0ZXIpIHtcbiAgfVxuXG4gIG5hdmlnYXRlVG9Eb2dzUm9vdCgpIHtcbiAgICB0aGlzLnJvdXRlci5uYXZpZ2F0ZShbXG4gICAgICAnL2hvbWUnLFxuICAgICAgeyBvdXRsZXRzOiB7IGRvZ291dGxldDogWydkb2dzJ10gfSB9XG4gICAgXSk7XG4gIH1cbiAgbmF2aWdhdGVUb0NhdHNSb290KCkge1xuICAgIHRoaXMucm91dGVyLm5hdmlnYXRlKFtcbiAgICAgICcvaG9tZScsXG4gICAgICB7IG91dGxldHM6IHsgY2F0b3V0bGV0OiBbJ2NhdHMnXSB9IH1cbiAgICBdKTtcbiAgfVxuXG4gIHRhYlZpZXdJbmRleENoYW5nZShpbmRleDogbnVtYmVyKSB7XG4gICAgc3dpdGNoKGluZGV4KSB7XG4gICAgICBjYXNlIDA6IFxuICAgICAgICB0aGlzLm5hdmlnYXRlVG9Eb2dzUm9vdCgpO1xuICAgICAgICBicmVhaztcbiAgICAgIGNhc2UgMTpcbiAgICAgICAgdGhpcy5uYXZpZ2F0ZVRvQ2F0c1Jvb3QoKTtcbiAgICAgICAgYnJlYWs7ICAgIFxuICAgIH1cbiAgfVxufVxuIl19