import animals.Animal;
import data.Command;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Arrays;
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

    // Метод вывода меню команд
    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("ADD - добавить животное");
        System.out.println("LIST - показать список животных");
        System.out.println("EXIT - завершить программу");
        System.out.print("Введите команду: ");
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

        // Обработка ошибок возраста
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
                    System.out.println("Возраст не может быть отрицательным! Пожалуйста, введите возраст снова.");
                    inputAge = scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверный формат возраста. Введите число:");
                inputAge = scanner.nextLine();
            }
        }
        System.out.println("Корректный возраст принят.");

        // Обработка ошибок веса
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

        // Обработка выбора цвета
        System.out.print("Цвет животного: ");
        String color = scanner.nextLine();

        // Список допустимых цветов
        String[] colors = {"чёрный", "белый", "серый"};

        while (true) {  // Бесконечный цикл для повторения попытки ввода
            System.out.println("Выберите цвет животного:");

            // Отображение вариантов цветов
            for (int i = 0; i < colors.length; i++) {
                System.out.printf("%d. %s\n", i + 1, colors[i]);
            }

            // Получаем выбор пользователя
            String choice = scanner.nextLine();
            try {
                int index = Integer.parseInt(choice) - 1;
                if (index >= 0 && index < colors.length) {
                    color = colors[index];
                    break; // Выходим из цикла, если выбран правильный вариант
                } else {
                    System.out.println("Выбран неверный номер цвета. Попробуйте ещё раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректный символ. Введите цифру от 1 до " + colors.length + ".");
            }
        }

        // Создаем объект животного используя фабрику
        Animal animal = AnimalFactory.createAnimal(name, age, weight, color, type);
        animals.add(animal);
        System.out.println("Животное успешно добавлено.");
    }

    // Показываем список всех животных
    private static void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            System.out.println("Список животных:");
            for (Animal animal : animals) {
                System.out.println(animal.toString());
            }
        }
    }
}





