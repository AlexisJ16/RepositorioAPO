package model;

public class Player {

    private String nickname;
    private String name;
    private int score;
    private int numberOfLives;
    private Level playerLevel;

    /**
     * @param nickname    String:It is the player's unique identifier.
     * @param name        String: It is the player's name.
     * @param playerLevel Level: It is the level to which the player belongs.
     */
    public Player(String nickname, String name, Level playerLevel) {
        this.nickname = nickname;
        this.name = name;
        this.score = 10;
        this.numberOfLives = 5;
        this.playerLevel = playerLevel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getNumberLifes() {
        return numberOfLives;
    }

    public void setNumberLifes(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public Level getplayerLevel() {
        return playerLevel;
    }

    public void setplayerLevel(Level playerLevel) {
        this.playerLevel = playerLevel;
    }

    @Override
    public String toString() {
        return "Player [nickname=" + nickname + ", name=" + name + ", score=" + score + ", numberOfLives="
                + numberOfLives + ", playerLevel=" + playerLevel + "]";
    }

}