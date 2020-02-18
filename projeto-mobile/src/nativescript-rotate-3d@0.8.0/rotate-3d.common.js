"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var stack_layout_1 = require("tns-core-modules/ui/layouts/stack-layout");
var properties_1 = require("tns-core-modules/ui/core/properties");
exports.axisProperty = new properties_1.Property({
    name: "rotateAxis"
});
exports.cameraDistanceProperty = new properties_1.Property({
    name: "cameraDistance"
});
var Common = (function (_super) {
    __extends(Common, _super);
    function Common() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.axis = 'Z';
        _this.cameraDistance = 2000;
        return _this;
    }
    Common.degToRad = function (deg) {
        return deg * Math.PI / 180;
    };
    Common.prototype.animate = function (options) {
        this.animateRotation();
        return _super.prototype.animate.call(this, options);
    };
    Common.prototype.animateRotation = function () {
    };
    return Common;
}(stack_layout_1.StackLayout));
exports.Common = Common;
exports.axisProperty.register(Common);
exports.cameraDistanceProperty.register(Common);
//# sourceMappingURL=rotate-3d.common.js.map