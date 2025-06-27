package factory;

import animals.Animal;
import birds.Duck;
import pets.Cat;
import pets.Dog;


public class AnimalFactory {

    private static String name = "";
    private static int age = 0;
    private static double weight = 0;
    private static String color = "";
    private static String type = "";

    public AnimalFactory(String type, String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public Animal createAnimal() throws Exception {
        if (type.equalsIgnoreCase("cat")) {
            return new Cat(name, age, weight, color);
        } else if (type.equalsIgnoreCase("dog")) {
            return new Dog(name, age, weight, color);
        } else if (type.equalsIgnoreCase("duck")) {
            return new Duck(name, age, weight, color);
        } else {
            throw new Exception("Неподдерживаемый тип животного: '" + type + "'");
        }
    }
}

