import {AfterViewInit, Component, OnInit} from "@angular/core";
import {Button, Color, GridLayout, Label, Page, View} from "@nativescript/core";
import {topmost} from "@nativescript/core/ui/frame";
import {Visibility} from "@nativescript/core/ui/enums";
import {ModalDialogService} from "@nativescript/angular";
declare var UIImage: any;
declare var UIBarMetrics: any;

const DEFAULT_STEP = 'item-stepper';
const CURRENT_STEP = 'item-stepper current-step';
const SUCCESSFUL_STEP = 'item-stepper successful-step';
const BASE_COLOR = '#024184';

enum MoveTo {
    Left,
    Right
}

@Component({
    selector: "rastreamento",
    moduleId: module.id,
    templateUrl: "./rastreamento.component.html",
    styleUrls: ["./rastreamento.component.css"]
})
export class RastreamentoComponent implements OnInit, AfterViewInit {
    public selectedDate: Date;
    public isOnOpenDepartureDate: boolean = false;
    public departureDate = new Date();
    public returnDate = new Date();
    public dateSelector = new Date();
    public currentStep:number = 1;
    public rotateItemImageStepper1 = 0;
    public rotateItemImageStepper2 = 0;
    public rotateItemImageStepper3 = 0;
    private _translate = 104;
    private _animationDuration = 300;
    private _btnPrevious: Button;
    private _btnNext: Button;
    private _itemStepper1: Label;
    private _itemStepper2: Label;
    private _itemStepper3: Label;
    private _itemImageStepper1: View;
    private _itemImageStepper2: View;
    private _itemImageStepper3: View;
    private moveTo: MoveTo = MoveTo.Right;
    private previousMovesTo: MoveTo;
    private _selectDateGridLayout: GridLayout;
    private _overlayGridLayout: GridLayout;
    private isAndroid:boolean = true;
    private titulo:string;

    constructor(private _modalService: ModalDialogService, private page: Page) {
        var returnDate = new Date();
        returnDate.setDate(returnDate.getDate() + 2);
        this.returnDate = returnDate;
    }

    ngOnInit(): void {
        // Init your component properties here.
        this._btnPrevious = this.page.getViewById('btnPrevious');
        this._btnNext = this.page.getViewById('btnNext');
        this._itemImageStepper1 = this.page.getViewById('itemImageStepper1');
        this._itemImageStepper2 = this.page.getViewById('itemImageStepper2');
        this._itemImageStepper3 = this.page.getViewById('itemImageStepper3');
        this._itemStepper1 = this.page.getViewById('itemStepper1');
        this._itemStepper2 = this.page.getViewById('itemStepper2');
        this._itemStepper3 = this.page.getViewById('itemStepper3');
        this._selectDateGridLayout = this.page.getViewById('selectDateGridLayout');
        this._overlayGridLayout = this.page.getViewById('overlayGridLayout');
        this.titulo = "Dados Cadastrais";

        if (topmost().ios) {
            let navigationBar = topmost().ios.controller.navigationBar;
            navigationBar.translucent = false;
            navigationBar.setBackgroundImageForBarMetrics(UIImage.new(), UIBarMetrics.Default);
            navigationBar.shadowImage = UIImage.new();
        }

        if (this.isAndroid) {
            this.page.androidStatusBarBackground = new Color(BASE_COLOR);
        }
    }

    ngAfterViewInit(): void {
        setTimeout(() => {
            let target = this._itemImageStepper1;
            target.animate({ opacity: 1, duration: this._animationDuration })
                .then(() => {
                    console.log('Animation Finished!');
                })
                .catch((e) => {
                    console.log(e.message);
                });
        }, 3200)
    }

    itemImageStepper1GoForward() {
        let translate: number = this._translate;
        let duration = this._animationDuration;
        let target = this._itemImageStepper1;
        let targetNext = this._itemImageStepper2;
        target.animate({ translate: { x: translate, y: 0 }, duration: duration })
            .then(() => target.animate({ opacity: 0, duration: duration }))
            .then(() => target.animate({ translate: { x: 0, y: 0 }, duration: 0 }))
            .then(() => {
                this._itemStepper2.className = CURRENT_STEP;
                this._itemStepper1.className = SUCCESSFUL_STEP;
                targetNext.animate({ opacity: 1, duration: duration })
            })
            .then(() => {
                this.currentStep++;
                //this.selectReturn = true;
                this.enableButtons();
                console.log('Animation Finished!');
            })
            .catch((e) => {
                console.log(e.message);
            });
    }

    itemImageStepper2GoForward() {
        let translate: number = this._translate;
        let duration = this._animationDuration;
        let target = this._itemImageStepper2;
        let targetNext = this._itemImageStepper3;
        target.animate({ translate: { x: translate, y: 0 }, duration: duration })
            .then(() => target.animate({ opacity: 0, duration: duration }))
            .then(() => target.animate({ translate: { x: 0, y: 0 }, duration: 0 }))
            .then(() => {
                this._itemStepper3.className = CURRENT_STEP;
                this._itemStepper2.className = SUCCESSFUL_STEP;
                targetNext.animate({ opacity: 1, duration: duration })
            })
            .then(() => {
                this.currentStep++;
                this.enableButtons();
                console.log("Animation finished");
            })
            .catch((e) => {
                console.log(e.message);
            });
    }

    itemImageStepper2GoForwardPreviousStepLeft() {
        let translate: number = this._translate;
        let target = this._itemImageStepper2;
        let duration = this._animationDuration;
        let targetNext = this._itemImageStepper3;
        target.animate({ rotate: 360, duration: this._animationDuration })
            .then(() => {
                target.rotate = 0;
                this.rotateItemImageStepper2 = 0;
            })
            .then(() => target.animate({ translate: { x: translate, y: 0 }, duration: duration }))
            .then(() => target.animate({ opacity: 0, duration: duration }))
            .then(() => target.animate({ translate: { x: 0, y: 0 }, duration: 0 }))
            .then(() => {
                this._itemStepper2.className = SUCCESSFUL_STEP;
                this._itemStepper3.className = CURRENT_STEP;
                targetNext.animate({ opacity: 1, duration: duration })
            })
            .then(() => {
                this.currentStep++;
                this.enableButtons();
                console.log("Animation finished");
            })
            .catch((e) => {
                console.log(e.message);
            });
    }

    itemImageStepper2BackwardPreviousStepRight() {
        let translate: number = this._translate;
        let duration = this._animationDuration;
        let target = this._itemImageStepper2;
        let targetPrevious = this._itemImageStepper1;

        target.animate({ rotate: 360, duration: this._animationDuration })
            .then(() => {
                target.rotate = 0;
                this.rotateItemImageStepper2 = 180;
            })
            .then(() => target.animate({ translate: { x: -translate, y: 0 }, duration: duration }))
            .then(() => target.animate({ opacity: 0, duration: duration }))
            .then(() => target.animate({ translate: { x: 0, y: 0 }, duration: 0 }))
            .then(() => {
                this.rotateItemImageStepper2 = 0;
                this._itemStepper2.className = DEFAULT_STEP;
                this._itemStepper1.className = CURRENT_STEP;
                this.currentStep--;
            })
            .then(() => targetPrevious.animate({ opacity: 1 }))
            .then(() => {
                this.enableButtons();
                console.log("Animation finished");
            })
            .catch((e) => {
                console.log(e.message);
            });
    }

    itemImageStepper2BackwardPreviousStepLeft() {
        let translate: number = this._translate;
        let duration = this._animationDuration;
        let target = this._itemImageStepper2;
        let targetPrevious = this._itemImageStepper1;
        target.animate({ translate: { x: -translate, y: 0 }, duration: duration })
            .then(() => target.animate({ opacity: 0, duration: duration }))
            .then(() => target.animate({ translate: { x: 0, y: 0 }, duration: 0 }))
            .then(() => {
                this.rotateItemImageStepper2 = 0;
                this._itemStepper2.className = DEFAULT_STEP;
                this._itemStepper1.className = CURRENT_STEP;
                this.currentStep--;
            })
            .then(() => targetPrevious.animate({ opacity: 1 }))
            .then(() => {
                this.enableButtons();
                console.log("Animation finished");
            })
            .catch((e) => {
                console.log(e.message);
            });
    }

    itemImageStepper3Backward() {
        let translate: number = this._translate;
        let duration = this._animationDuration;
        let target = this._itemImageStepper3;
        let targetPrevious = this._itemImageStepper2;
        target.animate({ rotate: 360, duration: duration })
            .then(() => {
                target.rotate = 0;
                this.rotateItemImageStepper3 = 180;
            })
            .then(() => target.animate({ translate: { x: -translate, y: 0 }, duration: duration }))
            .then(() => target.animate({ opacity: 0, duration: duration }))
            .then(() => target.animate({ translate: { x: 0, y: 0 }, duration: 0 }))
            .then(() => {
                this.rotateItemImageStepper3 = 0;
                this.rotateItemImageStepper2 = 180;
                this._itemStepper3.className = DEFAULT_STEP;
                this._itemStepper2.className = CURRENT_STEP;
                this.currentStep--;
            })
            .then(() => targetPrevious.animate({ opacity: 1, duration: duration }))
            .then(() => {
                // this.dataList = this.flightData.flightDepart;
                this.enableButtons();
                console.log("Animation finished");
            })
            .catch((e) => {
                console.log(e.message);
            });

    }

    animateGoForward() {
        this.disableButtons();
        this.previousMovesTo = this.moveTo;
        this.moveTo = MoveTo.Right;
        switch (this.currentStep) {
            case 1: {
                this.itemImageStepper1GoForward();
                break;
            }
            case 2: {
                if (this.previousMovesTo === MoveTo.Left) {
                    this.itemImageStepper2GoForwardPreviousStepLeft();
                } else {
                    this.itemImageStepper2GoForward();
                }
                break;
            }
            default: {
                this.enableButtons();
                break;
            }
        }
    }

    animateBackward() {
        this.disableButtons();
        this.previousMovesTo = this.moveTo;
        this.moveTo = MoveTo.Left;
        switch (this.currentStep) {
            case 2: {
                if (this.previousMovesTo === MoveTo.Left && this.moveTo === MoveTo.Left) {
                    this.itemImageStepper2BackwardPreviousStepLeft();
                } else {
                    this.itemImageStepper2BackwardPreviousStepRight();
                }
                break;
            }
            case 3: {
                this.itemImageStepper3Backward();
                break;
            }
            default: {
                this.enableButtons();
                break;
            }
        }
    }

    enableButtons() {
        this._btnPrevious.isEnabled = true;
        this._btnNext.isEnabled = true;
    }

    disableButtons() {
        this._btnPrevious.isEnabled = false;
        this._btnNext.isEnabled = false;
    }

    // Select Date
    onOpenSelectDate(event) {
        this.isOnOpenDepartureDate = event;

        if (this.isOnOpenDepartureDate) {
            this.dateSelector = this.departureDate;
        } else {
            this.dateSelector = this.returnDate;
        }

        this._selectDateGridLayout.visibility = <any>Visibility.visible;
        this._selectDateGridLayout.className = 'select-date animate-bounceInUp-delay-0ms';
        this._overlayGridLayout.animate({ opacity: 0.5, duration: 300 });
    }

    onCloseSelectDate(isCancel: boolean) {
        if (!isCancel) {
            this.selectedDate = this.dateSelector;
            if (this.isOnOpenDepartureDate) {
                this.departureDate = this.dateSelector;
            } else {
                this.returnDate = this.dateSelector;
            }
        }

        this._selectDateGridLayout.className = 'select-date';
        this._overlayGridLayout.animate({ opacity: 0, duration: 300 })
            .then(() => {
                this._selectDateGridLayout.visibility = <any>Visibility.collapse;
            })
            .catch(() => {
            });
    }

    onDateChanged(args) {
        let date: Date = args.value;
        this.dateSelector = date;
    }

    adicionaTitulo(titulo:number){
        switch (titulo) {
            case 0: {
                this.titulo = "Dados Cadastrais";
                break;
            }
            case 1: {
                this.titulo = "Avaliação Clínica";
                break;
            }
            case 2: {
                this.titulo = "Conduta";
                break;
            }
            default: {
                this.titulo = "Dados Cadastrais";
                break;
            }
        }
    }
}
