package model;

public abstract class Species implements Growable {

  private String name;
  private String scientificName;

  /**
   * Class constructor method. These attributes are overwritten in the child
   * classes as they are inheritance attributes.
   * 
   * @param name           String: It is the registered species name of the
   *                       species.
   * @param scientificName String: It is the scientific name of the registered
   *                       species of the species.
   */
  public Species(String name, String scientificName) {
    super();
    this.name = name;
    this.scientificName = scientificName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScientificName() {
    return scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  @Override
  public String toString() {
    return "Species:\n"
        + "Name: " + name
        + "Scientific Name: " + scientificName;
  }
}