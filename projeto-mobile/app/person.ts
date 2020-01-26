export class Person {
    public name: string;
    public age: number;
    public email: string;
    public city: string;
    public street: string;
    public streetNumber: number;

    constructor(name, age, email, city, street, streetNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
}