import java.util.concurrent.TimeUnit;

public class AbstractClasses {
    public static void main(String[] args) throws InterruptedException {
        int tact = 500;

        Piano piano = new Piano();
        piano.play("A5");
        TimeUnit.MILLISECONDS.sleep(tact * 2);
        piano.play("E6");
        TimeUnit.MILLISECONDS.sleep(tact);
        piano.play("A5");
        TimeUnit.MILLISECONDS.sleep(tact);
        piano.play("F6");

        Hawk hawk = new Hawk(20);  // meters per second
        hawk.fly();
        System.out.println("Скорость ястреба - " + hawk.getFlySpeed());
    }
}

abstract class Instrument {

    public abstract void play(String note);

    public abstract void tune();
}

class Guitar extends Instrument {

    @Override
    public void play(String note) {
        System.out.println("Гитара играет ноту " + note);
    }

    @Override
    public void tune() {
        System.out.println("Происходит тюнинг гитары...");  // Не понял, что такое tune
    }
}

class Piano extends Instrument {

    @Override
    public void play(String note) {
        System.out.println("Пианино играет ноту " + note);
    }

    @Override
    public void tune() {
        System.out.println("Происходит тюнинг пианино...");
    }
}

abstract class Bird {
    private final double flySpeed;

    public Bird(double flySpeed) {
        this.flySpeed = flySpeed;
    }

    public abstract void fly();

    public abstract void makeSound();

    public double getFlySpeed() {
        return flySpeed;
    }
}

class Eagle extends Bird {

    public Eagle(double flySpeed) {
        super(flySpeed);
    }

    @Override
    public void fly() {
        System.out.println("Я - орёл, и я лечу!");
    }

    @Override
    public void makeSound() {
        System.out.println("RuntimeException: Звук eagle_sound не найдён");
    }
}

class Hawk extends Bird {

    public Hawk(double flySpeed) {
        super(flySpeed);
    }

    @Override
    public void fly() {
        System.out.println("Я - ястреб, и я лечу");
    }

    @Override
    public void makeSound() {
        System.out.println("ХИЯЯЯ (пикируем)");
    }
}