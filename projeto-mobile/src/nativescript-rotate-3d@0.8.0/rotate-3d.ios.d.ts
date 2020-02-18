import { Common } from './rotate-3d.common';
export declare class Rotate3D extends Common {
    _hasTransfrom: any;
    _suspendCATransaction: any;
    _suspendNativeUpdatesCount: any;
    updateNativeTransform(): void;
    _isPresentationLayerUpdateSuspeneded(): any;
    animateRotation(): void;
}
