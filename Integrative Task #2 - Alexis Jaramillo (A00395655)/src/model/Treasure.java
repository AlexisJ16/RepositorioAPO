package model;

public class Treasure {

    private String name;
    private String url;
    private int score;
    private int positionX;
    private int positionY;
    private int numberTreasure;

    /**
     * @param name           String: It is the name of the treasure.
     * @param url            String: It is the url of the image allusive to the
     *                       treasure.
     * @param score          int: It is the score awarded to the player when it is
     *                       obtained.
     * @param positionX      int: Position x in the game resolution.
     * @param positionY      int: Position y in the game resolution.
     * @param numberTreasure int: It is the number of treasures registered in the
     *                       same level.
     */
    public Treasure(String name, String url, int score, int positionX, int positionY, int numberTreasure) {
        this.name = name;
        this.url = url;
        this.score = score;
        this.positionX = positionX;
        this.positionY = positionY;
        this.numberTreasure = numberTreasure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getNumberTreasure() {
        return numberTreasure;
    }

    public void setNumberTreasure(int numberTreasure) {
        this.numberTreasure = numberTreasure;
    }

    public String toString() {
        return "Treasure [name=" + name + ", url=" + url + ", score=" + score + ", positionX=" + positionX
                + ", positionY="
                + positionY + ", numberTreasure=" + numberTreasure + "]";
    }

}