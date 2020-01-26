import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'my-cat-details',
    templateUrl: './cat-details/cat-details.component.html'
})
export class CatDetailsComponent implements OnInit{
  public name: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.name = this.route.snapshot.params['name'];
  }
}
