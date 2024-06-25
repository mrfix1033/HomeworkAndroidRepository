class Sportsman {

    protected final String name, team;
    protected final int age;
    protected int score = 0;

    public Sportsman(String name, String team, int age) {
        this.name = name;
        this.team = team;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int toAdd) {
        score += toAdd;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", команда: " + team + ", возраст: " + age + ", очки: " + score;
    }
}

class Footballer extends Sportsman {

    private boolean isOnKnees = false;

    public Footballer(String name, String team, int age) {
        super(name, team, age);
    }

    public void getOnKnees() {
        isOnKnees = true;
    }

    public void getOffKnees() {
        isOnKnees = false;
    }

    public boolean isOnKnees() {
        return isOnKnees;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", команда: " + team + ", возраст: " + age + ", очки: " + score +
                ", он на коленях?: " + Utils.booleanToYesOrNo(isOnKnees);
    }
}

class HockeyPlayer extends Sportsman {

    private boolean shoelacesTied = false;

    public HockeyPlayer(String name, String team, int age) {
        super(name, team, age);
    }

    public void tieShoelaces() {
        shoelacesTied = true;
    }

    public void untieShoelaces() {
        shoelacesTied = false;
    }

    public boolean isShoelacesTied() {
        return shoelacesTied;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", команда: " + team + ", возраст: " + age + ", очки: " + score +
                ", шнурки завязаны?: " + Utils.booleanToYesOrNo(shoelacesTied);
    }
}

class Skier extends Sportsman {

    private boolean areSkisDressed = false;

    public Skier(String name, String team, int age) {
        super(name, team, age);
    }

    public void dressSkis() {
        areSkisDressed = true;
    }

    public void takeOffSkis() {
        areSkisDressed = true;
    }

    public boolean isAreSkisDressed() {
        return areSkisDressed;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", команда: " + team + ", возраст: " + age + ", очки: " + score +
                ", лыжи надеты?: " + Utils.booleanToYesOrNo(areSkisDressed);
    }
}

class Utils {
    public static String booleanToYesOrNo(boolean b) {
        return b ? "да" : "нет";
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Sportsman sportsman1 = new Sportsman("Andrey", "Red", 12);
        Sportsman sportsman2 = new Sportsman("Nikita", "Blue", 11);
        System.out.println(sportsman1);
        System.out.println(sportsman2);
        Sportsman footballer1 = new Footballer("Egor", "Green", 14);
        Sportsman footballer2 = new Footballer("Danil", "Orange", 15);
        System.out.println(footballer1);
        System.out.println(footballer2);
        Sportsman hockeyPlayer1 = new HockeyPlayer("Artem", "Purple", 18);
        Sportsman hockeyPlayer2 = new HockeyPlayer("Kirill", "Gold", 17);
        System.out.println(hockeyPlayer1);
        System.out.println(hockeyPlayer2);
        Sportsman skier1 = new Skier("Jonny", "Violet", 21);
        Sportsman skier2 = new Skier("John", "Pink", 24);
        System.out.println(skier1);
        System.out.println(skier2);
    }
}