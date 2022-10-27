package model;

public class Fauna extends Species {

  private boolean isMigratory;
  private double maximunWeigth;

  /**
   * @param name           String: It is the registered species name of the
   *                       species.
   * @param scientificName String: It is the scientific name of the registered
   *                       species of the species.
   * @param isMigratory    boolean: It represents whether the species is migratory
   *                       or not
   * @param maximunWeigth  boolean: It is the maximum weight the species can reach
   * 
   */
  public Fauna(String name, String scientificName, boolean isMigratory, double maximunWeigth) {
    super(name, scientificName);
    this.isMigratory = isMigratory;
    this.maximunWeigth = maximunWeigth;
  }

  public boolean getIsMigratory() {
    return isMigratory;
  }

  public void setIsMigratory(boolean isMigratory) {
    this.isMigratory = isMigratory;
  }

  public double getmaximunWeigth() {
    return maximunWeigth;
  }

  public void setmaximunWeigth(double maximunWeigth) {
    this.maximunWeigth = maximunWeigth;
  }

  @Override
  public String toString() {
    return "Fauna: "
        + "Name: " + super.getName()
        + "Scientific name: " + super.getScientificName()
        + "Is Migratory: " + isMigratory
        + "Maximum Weigth: " + maximunWeigth;
  }

  @Override
  public void grow(int rate) {
    // Ejemplo para el uso de una interfaz
    double calculate = Growable.GROWTH * 4;

  }
}