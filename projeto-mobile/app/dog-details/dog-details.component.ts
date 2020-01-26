import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import 'rxjs/add/operator/switchMap';

import { DogService } from '../dog.service';

@Component({
    selector: 'my-dog-details',
    templateUrl: './dog-details/dog-details.component.html'
})
export class DogDetailsComponent implements OnInit{
  private dogId: number;
  public dog: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private dogService: DogService) {
  }

  ngOnInit() {
    // This approach allows us to navigate from dog-details to dog-details with a new dogId
    // forEach will be triggered every time new id is provided
    this.route.params
      .forEach(params => {
        this.dogId = +params['id'];
        this.dog = this.dogService.getDog(this.dogId);
      });

    // This approach picks the id only once.
    // When you navigate from dog-details to dog-details with a newId, that won't be recognised
    // this.dogId = +this.route.snapshot.params['id'];
    // this.dog = this.dogService.getDog(this.dogId);
  }

  public goBack() {
    this.router.navigate([
      '/home', { outlets: { dogoutlet: ['dogs'] } }
    ])
  }

  public goToPreviousDog() {
    const newDogId = (this.dogId + 9) % 10;

    this.router.navigate([
      '/home', { outlets: { dogoutlet: ['dogs', newDogId] } }
    ])
  }

  public goToNextDog() {
    const newDogId = (this.dogId + 1) % 10;
    this.router.navigate([
      '/home', { outlets: { dogoutlet: ['dogs', newDogId] } }
    ])
  }
}
