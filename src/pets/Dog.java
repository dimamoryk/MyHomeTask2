package pets;

import animals.Animal;

public class Dog extends Animal {
    public Dog(String name, int age, double weight, String color) {
        super(name, age, (int) weight, color);

    }

    @Override
    public void say() {
        System.out.println("Гав");
    }
}

