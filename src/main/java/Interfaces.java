public class Interfaces {
    public static void main(String[] args) {
        Human human = new Human("Andrey", 19);
        BirdImplementation bird = new BirdImplementation(10);
        Fish fish = new Fish(5);
        System.out.println("У птицы скорость: " + bird.getFlyingSpeed());
        bird.fly();
        bird.swim();
        human.swim();
        fish.swim();
    }
}

class Human implements Swimmable {
    private final String name;
    private final int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void swim() {
        System.out.println("Плаваем ручками и ножками");
    }
}

class Fish implements Swimmable {
    private final double swimSpeed;

    Fish(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void swim() {
        System.out.println("Плаваем со скоростью " + swimSpeed + " м/c");
    }

    public double getSwimSpeed() {
        return swimSpeed;
    }
}

class BirdImplementation implements Swimmable, Flyable {
    private final double flyingSpeed;

    BirdImplementation(double flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
    }

    @Override
    public void fly() {
        System.out.println("Летим со скоростью " + flyingSpeed + " м/с махая крылышками");
    }

    @Override
    public void swim() {
        System.out.println("Плаваем на поверхности передвигая ножками");
    }

    public double getFlyingSpeed() {
        return flyingSpeed;
    }
}

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}