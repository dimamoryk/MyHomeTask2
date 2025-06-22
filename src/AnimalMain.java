import animals.Animal;
import birds.Duck;
import data.Command;
import factory.AnimalFactory;
import pets.Cat;
import pets.Dog;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Animal> animals = new ArrayList<>();


    public static void main(String... args) {
        while (true) {
            printMenu(); // выводим меню

            try {
                Command command = Command.valueOf(scanner.nextLine().toUpperCase());

                switch (command) {
                    case ADD:
                        addAnimal(); // добавляем животное
                        break;
                    case LIST:
                        listAnimals(); // показываем список всех животных
                        break;
                    case EXIT:
                        System.exit(0); // завершение программы
                        break;
                    default:
                        System.out.println("Неверная команда!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода команды.");

            }
        }
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("ADD — добавить животное");
        System.out.println("LIST — показать список животных");
        System.out.println("EXIT — выйти из программы");
        System.out.print("Введите команду: ");

    }


    // Добавляем новое животное
    private static void addAnimal() {
        String inputType;
        do {
            System.out.print("Введите вид животного (cat/dog/duck): ");
            inputType = scanner.nextLine();
        } while (!inputType.equalsIgnoreCase("cat") && !inputType.equalsIgnoreCase("dog") && !inputType.equalsIgnoreCase("duck"));

//  используем inputType для создания животного


        System.out.print("Имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Возраст животного: ");
        int age = Integer.parseInt(scanner.nextLine());

        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 0) break;
                else System.out.println("Возраст не может быть отрицательным!");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат возраста.");
            }
        }


        System.out.print("Вес животного: ");
        double weight = Double.parseDouble(scanner.nextLine());
        while (true) {
            try {
                weight = Double.parseDouble(scanner.nextLine());
                if (weight >= 0) break;
                else System.out.println("Вес не может быть отрицательным!");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат веса.");
            }
        }

        System.out.print("Цвет животного: ");
        String color = scanner.nextLine();

        // Выбираем вид животного
        System.out.println("Выберите тип животного:\n1. Кошка\n2. Собака\n3. Утка");
        int choice = Integer.parseInt(scanner.nextLine());


        Animal animal = new AnimalFactory(name, age, weight, color).createAnimal(inputType);

        animals.add(animal);// добавляем объект в коллекцию
        animal.say();
        System.out.println("Животное успешно добавлено!");
    }


    // Показываем список всех животных
    private static void listAnimals() {
        for (Animal a : animals) {
            System.out.println(a.toString());
        }
    }
}



