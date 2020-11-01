package Yannick;

public class Player {
    String name;
    int score;

    public Player(String name) {
        this.name = name;
        this.score = 1000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
