"use strict";
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var CatDetailsComponent = (function () {
    function CatDetailsComponent(route) {
        this.route = route;
    }
    CatDetailsComponent.prototype.ngOnInit = function () {
        this.name = this.route.snapshot.params['name'];
    };
    return CatDetailsComponent;
}());
CatDetailsComponent = __decorate([
    core_1.Component({
        selector: 'my-cat-details',
        templateUrl: './cat-details/cat-details.component.html'
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute])
], CatDetailsComponent);
exports.CatDetailsComponent = CatDetailsComponent;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiY2F0LWRldGFpbHMuY29tcG9uZW50LmpzIiwic291cmNlUm9vdCI6IiIsInNvdXJjZXMiOlsiY2F0LWRldGFpbHMuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFBQSxzQ0FBa0Q7QUFDbEQsMENBQWlEO0FBTWpELElBQWEsbUJBQW1CO0lBRzlCLDZCQUFvQixLQUFxQjtRQUFyQixVQUFLLEdBQUwsS0FBSyxDQUFnQjtJQUFJLENBQUM7SUFFOUMsc0NBQVEsR0FBUjtRQUNFLElBQUksQ0FBQyxJQUFJLEdBQUcsSUFBSSxDQUFDLEtBQUssQ0FBQyxRQUFRLENBQUMsTUFBTSxDQUFDLE1BQU0sQ0FBQyxDQUFDO0lBQ2pELENBQUM7SUFDSCwwQkFBQztBQUFELENBQUMsQUFSRCxJQVFDO0FBUlksbUJBQW1CO0lBSi9CLGdCQUFTLENBQUM7UUFDUCxRQUFRLEVBQUUsZ0JBQWdCO1FBQzFCLFdBQVcsRUFBRSwwQ0FBMEM7S0FDMUQsQ0FBQztxQ0FJMkIsdUJBQWM7R0FIOUIsbUJBQW1CLENBUS9CO0FBUlksa0RBQW1CIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgQ29tcG9uZW50LCBPbkluaXQgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IEFjdGl2YXRlZFJvdXRlIH0gZnJvbSAnQGFuZ3VsYXIvcm91dGVyJztcblxuQENvbXBvbmVudCh7XG4gICAgc2VsZWN0b3I6ICdteS1jYXQtZGV0YWlscycsXG4gICAgdGVtcGxhdGVVcmw6ICcuL2NhdC1kZXRhaWxzL2NhdC1kZXRhaWxzLmNvbXBvbmVudC5odG1sJ1xufSlcbmV4cG9ydCBjbGFzcyBDYXREZXRhaWxzQ29tcG9uZW50IGltcGxlbWVudHMgT25Jbml0e1xuICBwdWJsaWMgbmFtZTogc3RyaW5nO1xuXG4gIGNvbnN0cnVjdG9yKHByaXZhdGUgcm91dGU6IEFjdGl2YXRlZFJvdXRlKSB7IH1cblxuICBuZ09uSW5pdCgpIHtcbiAgICB0aGlzLm5hbWUgPSB0aGlzLnJvdXRlLnNuYXBzaG90LnBhcmFtc1snbmFtZSddO1xuICB9XG59XG4iXX0=