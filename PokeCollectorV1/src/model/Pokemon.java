package model;

public class Pokemon {

    private String name;
    private int id;
    private String type1;
    private String types2;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private Date captureDate;
    private Move[] moves;

    /**
     * @param name        String: It is the name of the pokemon.
     * @param id          int: Unique Pokemon identifier.
     * @param type1       String: It is the first type the pokemon can have.
     * @param types2      String: It is the second type that the pokemon can have.
     * @param health      int: It is the health of the pokemon.
     * @param attack      int: It is the attack that the pokemon has.
     * @param defense     int: It is the pokemon's defense.
     * @param speed       int: It is the speed of the pokemon.
     * @param captureDate Date: It is the date of capture of the pokemon.
     */
    public Pokemon(String name, int id, String type1, String types2, int health, int attack, int defense, int speed,
            Date captureDate) {
        this.name = name;
        this.id = id;
        this.type1 = type1;
        this.types2 = types2;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.captureDate = captureDate;
        moves = new Move[4];
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType1() {
        return this.type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getTypes2() {
        return this.types2;
    }

    public void setTypes2(String types2) {
        this.types2 = types2;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Date getCaptureDate() {
        return this.captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public Move[] getMoves() {
        return this.moves;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {

        return "\nPokemon info:"
                + "\nName: " + this.name
                + "\nPokemon ID: " + this.id
                + "\nPokemon type 1: " + this.type1
                + "\nPokemon type 2: " + this.types2
                + "\nHealth: " + this.health
                + "\nAttack power: " + this.attack
                + "\nDefense power: " + this.defense
                + "\nSpeed: " + this.speed
                + "\nDate of capture: " + this.captureDate;
    }

    /**
     * Scroll through the Move array to assign it to a space.
     * 
     * @param idMove int: Unique Move identifier.
     * @param id     int: Unique Pokemon identifier.
     * @return false boolean: Depending on the conditions satisfactorily fulfilled
     *         in the method.
     */
    public boolean addMoveToPokemon(int idMove, int id) {
        Move mv = null;
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] == null) {
                moves[i] = mv;
                return true;
            }
        }
        return false;
    }

}