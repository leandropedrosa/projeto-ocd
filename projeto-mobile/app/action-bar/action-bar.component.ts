import { Component, Input } from '@angular/core';
import { RouterExtensions } from 'nativescript-angular/router/router-extensions';

@Component({
    selector: 'my-action-bar',
    templateUrl: './action-bar/action-bar.component.html'
})
export class ActionBarComponent {

  private _title: string = '';

  @Input()
  public get title(): string {
    return this._title;
  }
  public set title(val: string) {
    this._title = val;
  }

  private _showBack: boolean = false;

  @Input()
  public get showBack(): boolean {
    return this._showBack;
  }
  public set showBack(val: boolean) {
    this._showBack = val;
  }


  public get canGoBack(): boolean {
    return this.showBack && this.router.canGoBack();
  }

  constructor(private router: RouterExtensions) {

  }

  public navigateBack() {
    this.router.back();
  }
}
