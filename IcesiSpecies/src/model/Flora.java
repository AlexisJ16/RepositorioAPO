package model;

public class Flora extends Species {

    private boolean hasFlowers;
    private boolean hasFruits;
    private double maximunHeigth;

    /**
     * @param name           String: It is the registered species name of the
     *                       species.
     * @param scientificName String: It is the scientific name of the registered
     *                       species of the species.
     * @param hasFlowers     boolean: Represents whether the species has flowers or
     *                       not.
     * @param hasFruits      boolean: Represents whether the species has fruits or
     *                       not.
     * 
     * @param maximunHeigth  boolean: It is the maximum height that the species can
     *                       reach.
     */
    public Flora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maximunHeigth) {

        super(name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maximunHeigth = maximunHeigth;
    }

    public boolean ishasFlowers() {
        return hasFlowers;
    }

    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    public boolean isHasFruits() {
        return hasFruits;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public double getmaximunHeigth() {
        return maximunHeigth;
    }

    public void setmaximunHeigth(double maximunHeigth) {
        this.maximunHeigth = maximunHeigth;
    }

    @Override
    public String toString() {
        return "Flora: "
                + "Name: " + super.getName()
                + "Scientific name: " + super.getScientificName()
                + "Has Flowers: " + hasFlowers
                + "Has Fruits: " + hasFruits
                + "Maximum Height: " + maximunHeigth;
    }

    @Override
    public void grow(int rate) {
        // TODO Auto-generated method stub

    }
}