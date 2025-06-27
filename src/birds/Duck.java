package birds;

import animals.Animal;

public class Duck extends Animal implements Flying {
    public Duck(String name, int age, double weight, String color) {
        super(name, age, (int) weight, color);
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}

