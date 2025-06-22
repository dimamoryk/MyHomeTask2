package factory;

import animals.Animal;
import birds.Duck;
import pets.Cat;
import pets.Dog;


public class AnimalFactory {

    private String name = "";
    private int age = 0;
    private double weight = 0;
    private String color = "";

    public AnimalFactory(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal createAnimal(String type) {


        switch (type) {
            case "cat":
                return new Cat(name, age, weight, color);

            case "dog":
                return new Dog(name, age, weight, color);
            case "duck":
                return new Duck(name, age, weight, color);

            default:
                throw new IllegalStateException("Ожидалось cat, dog или duck");


        }
    }
}
