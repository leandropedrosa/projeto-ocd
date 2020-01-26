"use strict";
var core_1 = require("@angular/core");
var router_extensions_1 = require("nativescript-angular/router/router-extensions");
var ActionBarComponent = (function () {
    function ActionBarComponent(router) {
        this.router = router;
        this._title = '';
        this._showBack = false;
    }
    Object.defineProperty(ActionBarComponent.prototype, "title", {
        get: function () {
            return this._title;
        },
        set: function (val) {
            this._title = val;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ActionBarComponent.prototype, "showBack", {
        get: function () {
            return this._showBack;
        },
        set: function (val) {
            this._showBack = val;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ActionBarComponent.prototype, "canGoBack", {
        get: function () {
            return this.showBack && this.router.canGoBack();
        },
        enumerable: true,
        configurable: true
    });
    ActionBarComponent.prototype.navigateBack = function () {
        this.router.back();
    };
    return ActionBarComponent;
}());
__decorate([
    core_1.Input(),
    __metadata("design:type", String),
    __metadata("design:paramtypes", [String])
], ActionBarComponent.prototype, "title", null);
__decorate([
    core_1.Input(),
    __metadata("design:type", Boolean),
    __metadata("design:paramtypes", [Boolean])
], ActionBarComponent.prototype, "showBack", null);
ActionBarComponent = __decorate([
    core_1.Component({
        selector: 'my-action-bar',
        templateUrl: './action-bar/action-bar.component.html'
    }),
    __metadata("design:paramtypes", [router_extensions_1.RouterExtensions])
], ActionBarComponent);
exports.ActionBarComponent = ActionBarComponent;
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYWN0aW9uLWJhci5jb21wb25lbnQuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJhY3Rpb24tYmFyLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQUEsc0NBQWlEO0FBQ2pELG1GQUFpRjtBQU1qRixJQUFhLGtCQUFrQjtJQTJCN0IsNEJBQW9CLE1BQXdCO1FBQXhCLFdBQU0sR0FBTixNQUFNLENBQWtCO1FBekJwQyxXQUFNLEdBQVcsRUFBRSxDQUFDO1FBVXBCLGNBQVMsR0FBWSxLQUFLLENBQUM7SUFpQm5DLENBQUM7SUF4QkQsc0JBQVcscUNBQUs7YUFBaEI7WUFDRSxNQUFNLENBQUMsSUFBSSxDQUFDLE1BQU0sQ0FBQztRQUNyQixDQUFDO2FBQ0QsVUFBaUIsR0FBVztZQUMxQixJQUFJLENBQUMsTUFBTSxHQUFHLEdBQUcsQ0FBQztRQUNwQixDQUFDOzs7T0FIQTtJQVFELHNCQUFXLHdDQUFRO2FBQW5CO1lBQ0UsTUFBTSxDQUFDLElBQUksQ0FBQyxTQUFTLENBQUM7UUFDeEIsQ0FBQzthQUNELFVBQW9CLEdBQVk7WUFDOUIsSUFBSSxDQUFDLFNBQVMsR0FBRyxHQUFHLENBQUM7UUFDdkIsQ0FBQzs7O09BSEE7SUFNRCxzQkFBVyx5Q0FBUzthQUFwQjtZQUNFLE1BQU0sQ0FBQyxJQUFJLENBQUMsUUFBUSxJQUFJLElBQUksQ0FBQyxNQUFNLENBQUMsU0FBUyxFQUFFLENBQUM7UUFDbEQsQ0FBQzs7O09BQUE7SUFNTSx5Q0FBWSxHQUFuQjtRQUNFLElBQUksQ0FBQyxNQUFNLENBQUMsSUFBSSxFQUFFLENBQUM7SUFDckIsQ0FBQztJQUNILHlCQUFDO0FBQUQsQ0FBQyxBQWxDRCxJQWtDQztBQTdCQztJQURDLFlBQUssRUFBRTs7OytDQUdQO0FBUUQ7SUFEQyxZQUFLLEVBQUU7OztrREFHUDtBQWpCVSxrQkFBa0I7SUFKOUIsZ0JBQVMsQ0FBQztRQUNQLFFBQVEsRUFBRSxlQUFlO1FBQ3pCLFdBQVcsRUFBRSx3Q0FBd0M7S0FDeEQsQ0FBQztxQ0E0QjRCLG9DQUFnQjtHQTNCakMsa0JBQWtCLENBa0M5QjtBQWxDWSxnREFBa0IiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBDb21wb25lbnQsIElucHV0IH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQgeyBSb3V0ZXJFeHRlbnNpb25zIH0gZnJvbSAnbmF0aXZlc2NyaXB0LWFuZ3VsYXIvcm91dGVyL3JvdXRlci1leHRlbnNpb25zJztcblxuQENvbXBvbmVudCh7XG4gICAgc2VsZWN0b3I6ICdteS1hY3Rpb24tYmFyJyxcbiAgICB0ZW1wbGF0ZVVybDogJy4vYWN0aW9uLWJhci9hY3Rpb24tYmFyLmNvbXBvbmVudC5odG1sJ1xufSlcbmV4cG9ydCBjbGFzcyBBY3Rpb25CYXJDb21wb25lbnQge1xuXG4gIHByaXZhdGUgX3RpdGxlOiBzdHJpbmcgPSAnJztcblxuICBASW5wdXQoKVxuICBwdWJsaWMgZ2V0IHRpdGxlKCk6IHN0cmluZyB7XG4gICAgcmV0dXJuIHRoaXMuX3RpdGxlO1xuICB9XG4gIHB1YmxpYyBzZXQgdGl0bGUodmFsOiBzdHJpbmcpIHtcbiAgICB0aGlzLl90aXRsZSA9IHZhbDtcbiAgfVxuXG4gIHByaXZhdGUgX3Nob3dCYWNrOiBib29sZWFuID0gZmFsc2U7XG5cbiAgQElucHV0KClcbiAgcHVibGljIGdldCBzaG93QmFjaygpOiBib29sZWFuIHtcbiAgICByZXR1cm4gdGhpcy5fc2hvd0JhY2s7XG4gIH1cbiAgcHVibGljIHNldCBzaG93QmFjayh2YWw6IGJvb2xlYW4pIHtcbiAgICB0aGlzLl9zaG93QmFjayA9IHZhbDtcbiAgfVxuXG5cbiAgcHVibGljIGdldCBjYW5Hb0JhY2soKTogYm9vbGVhbiB7XG4gICAgcmV0dXJuIHRoaXMuc2hvd0JhY2sgJiYgdGhpcy5yb3V0ZXIuY2FuR29CYWNrKCk7XG4gIH1cblxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIHJvdXRlcjogUm91dGVyRXh0ZW5zaW9ucykge1xuXG4gIH1cblxuICBwdWJsaWMgbmF2aWdhdGVCYWNrKCkge1xuICAgIHRoaXMucm91dGVyLmJhY2soKTtcbiAgfVxufVxuIl19