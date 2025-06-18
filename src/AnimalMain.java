import animals.Animal;
import birds.Duck;
import data.Command;
import pets.Cat;
import pets.Dog;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalMain {
    private static String[] args;

    public static void main(String... args) {
        AnimalMain.args = args;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.print("\nadd / list / exit : ");
            String input = scanner.nextLine().trim().toLowerCase(); // Регистронезависимый ввод команд

            try {
                Command command = Command.valueOf(input.toUpperCase());

                switch (command) {
                    case ADD:
                        handleAdd(animals, scanner);
                        break;

                    case LIST:
                        printAnimals(animals);
                        break;

                    case EXIT:
                        System.out.println("Выход из программы.");
                        return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильно введена команда!");
            }
        }
    }

    // Обработка добавления нового животного
    private static void handleAdd(ArrayList<Animal> animals, Scanner scanner) {
        System.out.print("Введите вид животного (cat/dog/duck): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Имя: ");
        String name = scanner.nextLine().trim();

        System.out.print("Возраст: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Вес: ");
        double weight = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Цвет: ");
        String color = scanner.nextLine().trim();

        Animal animal;
        switch (type) {
            case "cat":
                animal = new Cat(name, age, weight, color);
                break;
            case "dog":
                animal = new Dog(name, age, weight, color);
                break;
            case "duck":
                animal = new Duck(name, age, weight, color);
                break;
            default:
                throw new IllegalStateException("Ожидалось cat, dog или duck");
        }

        animals.add(animal);
        animal.say();
    }

    // Печать списка животных
    private static void printAnimals(ArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("Нет животных.");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal.toString());
            }
        }
    }
}



