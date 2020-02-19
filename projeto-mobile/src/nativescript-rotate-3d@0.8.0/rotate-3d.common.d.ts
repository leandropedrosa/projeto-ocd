import { StackLayout } from "tns-core-modules/ui/layouts/stack-layout";
import { Property } from 'tns-core-modules/ui/core/properties';
import { AnimationDefinition, AnimationPromise } from 'tns-core-modules/ui/animation';
export declare const axisProperty: Property<Common, string>;
export declare const cameraDistanceProperty: Property<Common, number>;
export declare class Common extends StackLayout {
    axis: string;
    cameraDistance: number;
    static degToRad(deg: any): number;
    animate(options: AnimationDefinition): AnimationPromise;
    animateRotation(): void;
}
