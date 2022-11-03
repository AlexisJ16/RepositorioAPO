package model;

public class Enemy {

    private String name;
    private TypeEnemy enemySelection;
    private int damage;
    private int score;
    private int positionX;
    private int positionY;

    /**
     * @param name            String: It is the name of the enemy.
     * @param typeEnemynumber int: It is the player's choice on the type of enemy
     *                        selected.
     * @param damage          int: Damage caused by the enemy.
     * @param score           int: Is the score subtracted from the player when he
     *                        is defeated by the player.
     * @param positionX       int: Position x in the game resolution.
     * @param positionY       int: Position y in the game resolution.
     */
    public Enemy(String name, int typeEnemynumber, int damage, int score, int positionX, int positionY) {

        this.name = name;
        this.damage = damage;
        this.score = score;
        this.positionX = positionX;
        this.positionY = positionY;

        switch (typeEnemynumber) {

            case 1:
                enemySelection = TypeEnemy.OGRES;
                break;

            case 2:
                enemySelection = TypeEnemy.ABSTRACT;
                break;

            case 3:
                enemySelection = TypeEnemy.BOSS;
                break;

            case 4:
                enemySelection = TypeEnemy.MAGIC;
                break;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public TypeEnemy getTypeEnemy() {
        return enemySelection;
    }

    public void setTypeEnemy(TypeEnemy enemySelection) {
        this.enemySelection = enemySelection;
    }

    @Override
    public String toString() {
        return "Enemy [name=" + name + ", enemySelection=" + enemySelection + ", damage=" + damage + ", score="
                + score + ", positionX=" + positionX + ", positionY=" + positionY + "]";
    }

    /**
     * @return enemySelection int: Returns on the player's choice of enemy type.
     */
    public int enemySelection() {

        switch (enemySelection) {

            case OGRES:
                return 1;

            case ABSTRACT:
                return 2;

            case BOSS:
                return 3;

            case MAGIC:
                return 4;
        }
        return 0;

    }

}