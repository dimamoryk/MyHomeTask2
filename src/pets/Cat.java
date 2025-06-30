package pets;

import animals.Animal;

public class Cat extends Animal {
    public Cat( String name, int age, double weight, String color, String type) {
        super(name, age, weight, color, type);

    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}

