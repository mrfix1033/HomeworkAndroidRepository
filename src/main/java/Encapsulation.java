class Gamer {  // а можно сделать record
    private final String nickname;
    private final boolean isActive;

    public Gamer(String nickname, boolean isActive) {
        this.nickname = nickname;
        this.isActive = isActive;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Игрок " + nickname + " " + (isActive ? "" : "не ") + "в игре";
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Gamer[] gamers = new Gamer[] {
            new Gamer("mrfix1033", true),
                new Gamer("mrAlex", false),
                new Gamer("Kjosef", true),
                new Gamer("md5", true),
                new Gamer("Dinnerbone", false),
                new Gamer("Notch", false)
        };
        for (Gamer gamer : gamers) System.out.println(gamer);
    }
}
