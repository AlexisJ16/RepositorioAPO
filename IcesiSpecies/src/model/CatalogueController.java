package model;

public class CatalogueController {

  /**
   * Species array declaration that stores all the records entered by the user.
   */
  private Species[] collection;

  /**
   * Starting the class and assigning the array size.
   */
  public CatalogueController() {
    this.collection = new Species[80];

  }

  /**
   * Allows the registration of a new Fauna Species, giving the possibility to
   * edit or delete it.
   * 
   * @param name           String : It is the name of the Fauna Species.
   * @param scientificName String : It is the scientific name of the Fauna
   *                       species.
   * @param isMigratory    boolean : It is the migration state of the plant.
   * @param maximunWeigth  double : It is the weight that the Species can reach
   *                       Flora.
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean registerFauna(String name, String scientificName, boolean isMigratory, double maximunWeigth) {

    // A new species (Fauna) is created.
    Fauna newFauna = new Fauna(name, scientificName, isMigratory, maximunWeigth);
    for (int i = 0; i < collection.length; i++) {
      if (collection[i] == null) {
        collection[i] = newFauna;
        return true;
      }
    }
    return false;
  }

  /**
   * Allows the registration of a new Flora Species, giving the possibility to
   * edit or delete it.
   * 
   * @param name           String : It is the name of the Flora species
   * @param scientificName String :It is the scientific name of the Flora species.
   * @param hasFlowers     boolean : It is the state of flowers that has the Flora
   *                       Species.
   * @param hasFruits      boolean :It is the fruit stage of the Flora species.
   * @param maximumHeigth  double : It is the maximum height that the Plant
   *                       Species can reach.
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean registerFlora(String name, String scientificName, boolean hasFlowers, boolean hasFruits,
      double maximumHeigth) {

    // A new species (Flora) is created.
    Flora newFlora = new Flora(name, scientificName, hasFlowers, hasFruits, maximumHeigth);

    for (int i = 0; i < collection.length; i++) {
      if (collection[i] == null) {
        collection[i] = newFlora;
        return true;
      }
    }
    return false;
  }

  /**
   * This method allows to display all the Species registered so far. It shows the
   * name and the position of the object in the form of a list.
   * 
   * @param show int : It is the decision made by the user for the type of species
   *             to be displayed.
   * @return msg boolean : In the message printed on the screen with the operation
   *         the user needed.
   */
  public String showSpecies(int show) {
    String msg = "";

    for (int i = 0; i < collection.length; i++) {
      if (collection[i] != null) {

        switch (show) {
          // To visualize all species.
          case 1:
            msg += "\n" + (i + 1) + ". " + collection[i].toString() + "\n";
            break;

          // To view all species Fauna.
          case 2:
            if (collection[i] instanceof Fauna) {
              msg += "\n" + (i + 1) + ". " + collection[i].toString() + "\n";
            }
            break;

          // To view all species Flora.
          case 3:
            if (collection[i] instanceof Flora) {
              msg += "\n" + (i + 1) + ". " + collection[i].toString() + "\n";
            }
            break;

          default:
            msg = "Opcion no permitida, escoge una eleccion del 1 al 3";
            break;
        }
      }
    }
    return msg;
  }

  /**
   * Method that allows the editing of any information recorded on the Fauna
   * species.
   * 
   * @param specieName         String: This is the variable where the edit on the
   *                           name and the scientific name of the species is
   *                           stored for later editing.
   * @param characteristicEdit int: It is the user's choice of the data to be
   *                           modified.
   * @param newInformation     String: It is the updated information that was
   *                           modified by the user.
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean editFauna(String specieName, int characteristicEdit, String newInformation) {

    switch (characteristicEdit) {

      // Edit the species name.
      case 1:
        for (int i = 0; i < collection.length; i++) {
          if (collection[i].getName().equalsIgnoreCase(specieName)) {
            collection[i].setName(newInformation);
            return true;
          }
        }
        break;

      // Edit the scientific name of the species.
      case 2:
        for (int i = 0; i < collection.length; i++) {
          if (collection[i] != null) {
            if (collection[i].getScientificName().equalsIgnoreCase(specieName)) {
              collection[i].setScientificName(newInformation);
              return true;
            }
          }
        }
        break;

      // Edit the migration status of the species.
      case 3:
        if (newInformation.equalsIgnoreCase("Yes")) {
          for (int i = 0; i < collection.length; i++) {
            if (collection[i].getName().equalsIgnoreCase(specieName)) {
              if (collection[i] instanceof Fauna) {
                ((Fauna) collection[i]).setIsMigratory(true);
              } else if (newInformation.equalsIgnoreCase("No")) {
                ((Fauna) collection[i]).setIsMigratory(false);

              }
            }

          }
        }
        break;

      // Edit the weight of the species.
      case 4:
        for (int i = 0; i < collection.length; i++) {
          if (collection[i].getName().equalsIgnoreCase(specieName)) {
            if (collection[i] instanceof Fauna) {
              ((Fauna) collection[i]).setmaximunWeigth(Double.parseDouble(newInformation));
            }
          }
        }
        break;
    }
    return false;
  }

  /**
   * Method that allows the edition of any information registered on the species
   * Flora.
   * 
   * @param specieName         String: This is the variable where the edit on the
   *                           name and the scientific name of the species is
   *                           stored for later editing.
   * @param characteristicEdit int: It is the user's choice of the data to be
   *                           modified.
   * @param newInformation     String: It is the updated information that was
   *                           modified by the user.
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean editFlora(String specieName, int characteristicEdit,
      String newInformation) {

    switch (characteristicEdit) {

      // Edit the species name Flora.
      case 1:
        for (int i = 0; i < collection.length; i++) {
          if (collection[i].getName().equalsIgnoreCase(specieName)) {
            collection[i].setName(newInformation);
            return true;
          }
        }
        break;

      // Edit the scientific name.
      case 2:
        for (int i = 0; i < collection.length; i++) {
          if (collection[i].getScientificName().equalsIgnoreCase(specieName)) {
            collection[i].setScientificName(newInformation);
            return true;
          }
        }
        break;

      // Edit the state of flowers.
      case 3:
        if (newInformation.equalsIgnoreCase("Yes")) {
          for (int i = 0; i < collection.length; i++) {
            if (collection[i].getName().equalsIgnoreCase(specieName)) {
              if (collection[i] instanceof Flora) {
                ((Flora) collection[i]).setHasFlowers(true);
              } else if (newInformation.equalsIgnoreCase("No")) {
                ((Flora) collection[i]).setHasFlowers(false);
              }
            }
          }
        }
        break;

      // Edit the fruit status.
      case 4:
        if (newInformation.equalsIgnoreCase("Yes")) {
          for (int i = 0; i < collection.length; i++) {
            if (collection[i].getName().equalsIgnoreCase(specieName)) {
              if (collection[i] instanceof Flora) {
                ((Flora) collection[i]).setHasFruits(true);
              } else if (newInformation.equalsIgnoreCase("No")) {
                ((Flora) collection[i]).setHasFruits(false);
              }
            }
          }
        }
        break;

      // Edit height.
      case 5:
        for (int i = 0; i < collection.length; i++) {
          if (collection[i].getName().equalsIgnoreCase(specieName)) {
            if (collection[i] instanceof Flora) {
              ((Flora) collection[i]).setmaximunHeigth(Double.parseDouble(newInformation));
            }
          }
        }
        break;
    }
    return false;
  }

  /**
   * Method that allows the elimination of any species by name.
   * 
   * @param name String: It is the name of the species to be eliminated.
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean deleteSpecies(String name) {
    for (int i = 0; i < collection.length; i++) {
      if (collection[i] != null) {
        if (collection[i].getName().equals(name)) {
          collection[i] = null;
          return true;
        }
      }
    }
    return false;

  }

  /**
   * Method showing the Flora species recorded.
   * 
   * @return msg String: This is the message that shows the Flora species recorded
   *         on the screen.
   */
  public String showFlora() {
    String msg = "";
    for (int i = 0; i < collection.length; i++) {
      if (collection[i] != null) {
        msg += i + " Nombre Flora: " + collection[i].getName()
            + "\nNombre cientifico Flora : " + collection[i].getScientificName() + "\n";
      }
    }
    return msg;
  }

  /**
   * Method showing recorded Fauna species.
   * 
   * @return msg String: This is the message that shows the Fauna species recorded
   *         on the screen.
   */
  public String showFauna() {
    String msg = "";
    for (int i = 0; i < collection.length; i++) {
      if (collection[i] != null) {
        msg += i + "Nombre Fauna: " + collection[i].getName()
            + "\nNombre cientifico Fauna: " + collection[i].getScientificName() + "\n";
      }
    }
    return msg;
  }

  /**
   * Method that verifies if there is at least one Fauna species registered.
   * 
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean verifyRegisteredFauna() {
    for (int i = 0; i < collection.length; i++) {
      if (collection[i] instanceof Fauna) {
        return true;
      }
    }
    return false;
  }

  /**
   * Method that verifies if there is at least one Flora species recorded.
   * 
   * @return false boolean: When the method is not required to be used, or when
   *         the conditions to fulfill the action performed by the method end.
   */
  public boolean verifyRegisteredFlora() {
    for (int i = 0; i < collection.length; i++) {
      if (collection[i] instanceof Flora) {
        return true;
      }
    }
    return false;
  }

}