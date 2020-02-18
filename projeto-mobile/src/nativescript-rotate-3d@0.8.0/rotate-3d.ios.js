"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var rotate_3d_common_1 = require("./rotate-3d.common");
var platform_1 = require("tns-core-modules/platform");
var Rotate3D = (function (_super) {
    __extends(Rotate3D, _super);
    function Rotate3D() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Rotate3D.prototype.updateNativeTransform = function () {
        var scaleX = this.scaleX || 1e-6;
        var scaleY = this.scaleY || 1e-6;
        var rotate = this.rotate || 0;
        var rotateAxis = { x: 0, y: 0, z: 0 };
        switch (this.axis.toUpperCase()) {
            case 'X':
                rotateAxis.x = this.cameraDistance;
                break;
            case 'Y':
                rotateAxis.y = this.cameraDistance;
                break;
            case 'Z':
                rotateAxis.z = this.cameraDistance;
                break;
        }
        var scale = platform_1.screen.mainScreen.scale;
        var perspective = this.cameraDistance / (2 * scale);
        var transform = CATransform3DIdentity;
        transform.m34 = -1 / perspective;
        transform = CATransform3DTranslate(transform, this.translateX, this.translateY, 0);
        transform = CATransform3DRotate(transform, Rotate3D.degToRad(rotate), rotateAxis.x, rotateAxis.y, rotateAxis.z);
        transform = CATransform3DScale(transform, scaleX, scaleY, 1);
        this.ios.layer.transform = transform;
        if (!CATransform3DEqualToTransform(this.ios.layer.transform, transform)) {
            var updateSuspended = this._isPresentationLayerUpdateSuspeneded();
            if (!updateSuspended) {
                CATransaction.begin();
            }
            this.ios.layer.transform = transform;
            this._hasTransfrom = this.nativeViewProtected && !CATransform3DEqualToTransform(this.nativeViewProtected.layer.transform, CATransform3DIdentity);
            if (!updateSuspended) {
                CATransaction.commit();
            }
        }
    };
    Rotate3D.prototype._isPresentationLayerUpdateSuspeneded = function () {
        return this._suspendCATransaction || this._suspendNativeUpdatesCount;
    };
    Rotate3D.prototype[rotate_3d_common_1.axisProperty.setNative] = function (value) {
        if (value && this.ios) {
            this.axis = value;
            this.updateNativeTransform();
        }
    };
    Rotate3D.prototype[rotate_3d_common_1.cameraDistanceProperty.setNative] = function (value) {
        if (value && this.ios) {
            this.cameraDistance = Math.abs(value);
            this.updateNativeTransform();
        }
    };
    Rotate3D.prototype.animateRotation = function () {
    };
    return Rotate3D;
}(rotate_3d_common_1.Common));
exports.Rotate3D = Rotate3D;
//# sourceMappingURL=rotate-3d.ios.js.map