import { Component } from '@angular/core';

import { Router } from '@angular/router';

@Component({
    selector: 'my-home',
    templateUrl: './home/home.component.html'
})
export class HomeComponent {
  public selectedIndex: number = 0;
  
  constructor(private router: Router) {
  }

  navigateToDogsRoot() {
    this.router.navigate([
      '/home',
      { outlets: { dogoutlet: ['dogs'] } }
    ]);
  }
  navigateToCatsRoot() {
    this.router.navigate([
      '/home',
      { outlets: { catoutlet: ['cats'] } }
    ]);
  }

  tabViewIndexChange(index: number) {
    switch(index) {
      case 0: 
        this.navigateToDogsRoot();
        break;
      case 1:
        this.navigateToCatsRoot();
        break;    
    }
  }
}
