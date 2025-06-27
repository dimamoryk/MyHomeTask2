package pets;

import animals.Animal;

public class Cat extends Animal {
    public Cat(String name, int age, double weight, String color) {
        super(name, age, (int) weight, color);

    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}

