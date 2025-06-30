package animals;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private String color;
    private String type;

    public Animal( String name, int age, double weight, String color, String type) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String setType(String type){
            this.type = type;

            return type;
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
        String yearsForm = getYearsForm(age);
        return "Привет! Меня зовут " + name +
                ", мне " + age + " " + yearsForm +
                ", я вешу - " + weight + " кг, мой цвет - " + color;
    }


    // Выбор правильной формы слова "лет"
    private static String getYearsForm(int number) {
        if (number % 10 == 1 && number != 11) return "год";
        else if ((number % 10 >= 2 && number % 10 <= 4) &&
                !(number > 10 && number < 15)) return "года";
        else return "лет";
    }
}


