public class Sportsman {

    private final String name, team;
    private final int age;
    private int score = 0;

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
}

class Footballer extends Sportsman {

    private boolean ridingOnKnees = false;

    public Footballer(String name, String team, int age) {
        super(name, team, age);
    }

    public void rideOnKnees() {
        ridingOnKnees = true;
    }

    public void getOffKnees() {
        ridingOnKnees = false;
    }

    public boolean amRidingOnKnees() {
        return ridingOnKnees;
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
}