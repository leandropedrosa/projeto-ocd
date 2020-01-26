import { Injectable } from "@angular/core";

@Injectable()
export class DogService {
    private dogs = new Array<any>(
        { id: 1, name: "Labrador Retriever", maxWeight: 80, maxHeight: 25 },
        { id: 2, name: "German Shepherd", maxWeight: 95, maxHeight: 26 },
        { id: 3, name: "Golden Retriever", maxWeight: 75, maxHeight: 24 },
        { id: 4, name: "Bulldog", maxWeight: 55, maxHeight: 15 },
        { id: 5, name: "Beagle", maxWeight: 30, maxHeight: 15 },
        { id: 6, name: "Yorkshire Terrier", maxWeight: 6, maxHeight: 9 },
        { id: 7, name: "Poodle", maxWeight: 65, maxHeight: 21 },
        { id: 8, name: "Boxer", maxWeight: 80, maxHeight: 25 },
        { id: 9, name: "French Bulldog", maxWeight: 28, maxHeight: 13 },
        { id: 10, name: "Rottweiler", maxWeight: 135, maxHeight: 27 },
    );

    getDogs(): any[] {
        return this.dogs;
    }

    getDog(id: number): any {
        return this.dogs.filter(item => item.id === id)[0];
    }
}
