import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'my-cat-tab',
    templateUrl: './cat-tab/cat-tab.component.html'
})
export class CatTabComponent implements OnInit{

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  navigateToRoot() {
    this.router.navigate([
      '/home',
      { outlets: { catoutlet: ['cats'] } }
    ]);
  }
  
  navigateToDetails(id) {
    this.router.navigate([
      '/home',
      { outlets: { catoutlet: ['cats', id] } }
    ]);
  }
}
