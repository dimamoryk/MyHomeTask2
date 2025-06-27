import animals.Animal;
import birds.Duck;
import data.Command;
import factory.AnimalFactory;
import pets.Cat;
import pets.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AnimalMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Animal> animals = new ArrayList<>();


    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
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
                        System.out.println("Программа завершена");
                        System.exit(0); // Завершаем программу

                    default:
                        System.out.println("Неверная команда!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода команды.");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Добавляем новое животное
    private static void addAnimal() throws Exception {

        System.out.print("Тип животного (cat/dog/duck): ");
        String type = scanner.nextLine();

        if (!Arrays.asList("cat", "dog", "duck").contains(type)) {
            System.out.println("Неправильный тип животного. Выберите один из вариантов: cat, dog, duck.");
            return;
        }


        System.out.print("Имя животного: ");
        String name = scanner.nextLine();


        //Обработка ошибок возраста
        System.out.print("Возраст животного: ");
        String inputAge = scanner.nextLine();
        boolean validInput = false;
        int age = 0;
        while (!validInput) {
            try {
                age = Integer.parseInt(inputAge);
                if (age >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Возраст не может быть отрицательным! Пожалуйста, введите Возраст снова.");
                    inputAge = scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверный формат Возраста. Введите число:");
                inputAge = scanner.nextLine();
            }
        }
        System.out.println("Корректный Возраст принят.");


        //Обработка ошибок веса
        System.out.print("Вес животного: ");
        String inputWeight = scanner.nextLine();

        validInput = false;
        double weight = 0;
        while (!validInput) {
            try {
                weight = Double.parseDouble(inputWeight);

                if (weight >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Вес не может быть отрицательным! Пожалуйста, введите вес снова.");
                    inputWeight = scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверный формат веса. Введите число:");
                inputWeight = scanner.nextLine();
            }
        }

        System.out.println("Корректный вес принят.");


        //Обработка ошибок цвета
        System.out.print("Цвет животного: ");
        String color = scanner.nextLine();

        // Список допустимых цветов
        String[] colors = {"красный", "зеленый", "синий", "желтый"};

        while (true) {  // Бесконечный цикл для повторения попытки ввода
            System.out.println("Выберите цвет животного:");

            // Отображение вариантов цветов
            for (int i = 0; i < colors.length; i++) {
                System.out.printf("%d. %s\n", i + 1, colors[i]);
            }

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= colors.length) {
                    // Если выбран правильный индекс, выводим строку с цветом
                    System.out.println("Цвет животного: " + colors[choice - 1]);
                    break; // Выходим из цикла после успешного выбора
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Выберите номер из предложенных.");

            }
        }
        System.out.println("Корректный цвет принят.");

                //Фабрика
        Animal animal = new AnimalFactory(type, name, age, weight, color).createAnimal();

        animals.add(animal); // добавляем объект в коллекцию
        System.out.println("Животное успешно добавлено!");
    }

    //Список всех животных
    private static void listAnimals() {
        for (Animal a : animals) {
            System.out.println(a.toString()); //  toString для вывода полной информации
        }
    }

    // Меню выбора команд
    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("ADD — добавить животное");
        System.out.println("LIST — показать список животных");
        System.out.println("EXIT — выйти из программы");
        System.out.print("Введите команду: ");
    }
}






