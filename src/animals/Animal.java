package animals;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private String color;

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = (int) weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + this.name +
                ", мне " + formatAge(this.age) +
                ", я вешу - " + this.weight + " кг," +
                " мой цвет - " + this.color;
    }

    private String formatAge(int age) {
        if (age % 10 == 1 && age != 11) {
            return age + " год";
        } else if ((age % 10 >= 2 && age % 10 <= 4) && !(age > 10 && age < 15)) {
            return age + " года";
        } else {
            return age + " лет";
        }
    }
}
