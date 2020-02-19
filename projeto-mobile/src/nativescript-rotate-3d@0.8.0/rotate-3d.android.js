"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var rotate_3d_common_1 = require("./rotate-3d.common");
var style_properties_1 = require("tns-core-modules/ui/styling/style-properties");
var platform_1 = require("tns-core-modules/platform");
var Rotate3D = (function (_super) {
    __extends(Rotate3D, _super);
    function Rotate3D() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Rotate3D.prototype[style_properties_1.rotateProperty.setNative] = function (value) {
        if (this.android) {
            this.applyRotation(value);
        }
    };
    Rotate3D.prototype[rotate_3d_common_1.axisProperty.setNative] = function (value) {
        if (value && this.android) {
            this.axis = value;
            this.applyRotation(this.rotate);
        }
    };
    Rotate3D.prototype[rotate_3d_common_1.cameraDistanceProperty.setNative] = function (value) {
        if (value && this.android) {
            this.cameraDistance = value;
            this.applyRotation(this.rotate);
        }
    };
    Rotate3D.prototype.applyRotation = function (value) {
        switch (this.axis.toUpperCase()) {
            case 'X':
                this.nativeViewProtected.setRotationX(float(value));
                break;
            case 'Y':
                this.nativeViewProtected.setRotationY(float(value));
                break;
            case 'Z':
                this.nativeViewProtected.setRotation(float(value));
                break;
        }
        this.applyCameraDistance();
    };
    Rotate3D.prototype.applyCameraDistance = function () {
        var scale = platform_1.screen.mainScreen.scale;
        this.nativeViewProtected.setCameraDistance(this.cameraDistance * scale);
    };
    Rotate3D.prototype.animateRotation = function () {
    };
    return Rotate3D;
}(rotate_3d_common_1.Common));
exports.Rotate3D = Rotate3D;
//# sourceMappingURL=rotate-3d.android.js.map