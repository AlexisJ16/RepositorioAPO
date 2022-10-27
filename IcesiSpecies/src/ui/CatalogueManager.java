/*
 * Program description: The code consists of a menu that has the species 
 * of Flora and Fauna of the ICESI University, where the user is allowed 
 * to register, consult, edit and delete the species he/she wants within the program.

 *@Author: Alexis Jaramillo Martinez (A00395655)
 
 */

package ui;

import java.util.Scanner;
import model.CatalogueController;

public class CatalogueManager {

  private Scanner sc;
  private CatalogueController CatalogueController;

  /**
   * Menu where the user interacts and the resolutions to the problem are given by
   * means of several options.
   */
  public CatalogueManager() {

    this.sc = new Scanner(System.in);
    this.CatalogueController = new CatalogueController();

  }

  /**
   * Execution menu where the user interacts.
   */
  public void menu() {
    System.out.println("\nCatalogo de Flora y Fauna - Universidad Icesi\n");

    boolean exit = false;

    while (!exit) {

      System.out.println("**MENU**"
          + "\n1. Registrar Fauna"
          + "\n2. Registrar Flora"
          + "\n3. Mostrar todas las Especies"
          + "\n4. Editar Fauna"
          + "\n5. Editar Flora"
          + "\n6. Borrar Especie"
          + "\n0. Para salir del programa\n");
      // Saves the user's choice.
      int option = sc.nextInt();

      switch (option) {
        case 1:
          // Calling Fauna's registration method.
          registerFauna();
          break;

        case 2:
          // Calling Flora's registration method.
          registerFlora();
          break;

        // It shows all the species recorded so far.
        case 3:
          // control situation when the user wants to edit a species when nothing is
          // registered.
          if (!CatalogueController.verifyRegisteredFauna() && !CatalogueController.verifyRegisteredFlora()) {
            System.out.println("\nNo existe ninguna Especie registrada hasta el momento\n");
          } else {
            System.out.println("\n1. Mostrar todas las Especies registradas"
                + "\n2. Mostrar toda la Fauna registrada"
                + "\n3. Mostrar toda la Flora registrada \n");
            // Saves de user's choice.
            int show = sc.nextInt();
            // Method call to display the recorded species.
            System.out.println(CatalogueController.showSpecies(show));
          }
          break;

        case 4:
          // Call the method to edit the Fauna species.
          System.out.println("\nEspecies Fauna registradas: \n" + CatalogueController.showFauna());
          editFauna();
          break;

        case 5:
          // Call the method to edit the Flora species.
          System.out.println("Especies Flora registradas: \n" + CatalogueController.showFlora());
          editFlora();
          break;

        case 6:
          // Call the method to eliminate any species.
          System.out.println("Especies Flora registradas: \n" + CatalogueController.showFauna());
          System.out.println("Especies Fauna registradas: \n" + CatalogueController.showFlora());
          deleteSpecie();
          break;

        case 0:
          // Program output.
          System.out.println("\nGracias por usar el programa!\n");
          exit = true;
          break;
      }

    }
  }

  /**
   * Executable menu.
   * 
   * @param args String: main argument.
   */
  public static void main(String[] args) {
    CatalogueManager menu = new CatalogueManager();
    menu.menu();
  }

  /**
   * Method that allows the collection of data supplied by the user to make the
   * record of a Fauna species.
   */
  private void registerFauna() {

    System.out.println("\nVas a registrar una especie Fauna!");

    System.out.println("\nIngresa el nombre de la especie");
    sc.nextLine(); // Refresh buffer.
    String name = sc.nextLine();

    System.out.println("\nIngresa el nombre cientifico de la especie");
    String scientificName = sc.nextLine();

    System.out.println("\nIngresa el estado migratorio de la especie");
    System.out.println("\nSi es migratoria, ingresa (true)");
    System.out.println("De lo contrario, ingresa (false)");
    boolean isMigratory = sc.nextBoolean();

    System.out.println("\nIngresa el peso maximo que puede alcanzar la especie");
    double maximunWeigth = sc.nextDouble();

    // Control condition that warns if the action performed was completed
    // successfully.
    if (CatalogueController.registerFauna(name, scientificName, isMigratory, maximunWeigth)) {
      System.out.println("\nEspecie Fauna registrada exitosamente\n");
    } else {
      System.out.println("\nNo se pudo registrar la especie Fauna\n");
    }

  }

  /**
   * Method that allows the collection of data supplied by the user to make the
   * record of a Flora species.
   */
  private void registerFlora() {

    System.out.println("\nVas a registrar una especie Flora!");

    System.out.println("\nIngresa el nombre de la especie");
    sc.nextLine(); // Refresh buffer.
    String name = sc.nextLine();

    System.out.println("\nIngresa el nombre cientifico de la especie");
    String scientificName = sc.nextLine();

    System.out.println("\nIngresa el estado floral de la especie");
    System.out.println("\nSi tiene flores, ingresa (true)");
    System.out.println("De lo contrario, ingresa (false)");
    boolean hasFlowers = sc.nextBoolean();

    System.out.println("\nIngresa el estado frutal de la especie");
    System.out.println("\nSi tiene frutas, ingresa (true)");
    System.out.println("De lo contrario, ingresa (false)");
    boolean hasFruits = sc.nextBoolean();

    System.out.println("\nIngresa la altura maxima que puede alcanzar la especie");
    double maximumHeigth = sc.nextDouble();

    // Control condition that warns if the action performed was completed
    // successfully.
    if (CatalogueController.registerFlora(name, scientificName, hasFlowers, hasFruits, maximumHeigth)) {
      System.out.println("\nEspecie Flora registrada exitosamente\n");
    } else {
      System.out.println("\nNo se pudo registrar la especie Flora\n");
    }

  }

  /**
   * Method that allows the editing of the recorded data of a species Fauna.
   */
  private void editFauna() {

    // control situation when the user wants to edit a species when nothing is
    // registered.
    if (!CatalogueController.verifyRegisteredFauna()) {
      System.out.println("\nNo existe ninguna Especie Fauna registrada\n");
    } else {

      System.out.println("\nIngresa el nombre de la especie que deseas editar");
      sc.nextLine();
      String specieName = sc.nextLine();

      System.out.println("\nEscoge la opcion de acuerdo con el dato que deseas editar"
          + "\n1. Nombre"
          + "\n2. Nombre cientifico"
          + "\n3. Estado de migracion (true) o (false)"
          + "\n4. Peso maximo\n");
      int characteristicEdit = sc.nextInt();

      // Saves the new information assigned to the species.
      System.out.println("\nIngresa la nueva informacion para actualizar\n");
      sc.nextLine();
      String newInformation = sc.nextLine();

      // Control condition that warns if the action performed was completed
      // successfully.
      if (CatalogueController.editFauna(specieName, characteristicEdit, newInformation)) {
        System.out.println("\nDatos editados correctamente\n");
      } else {
        System.out.println("\nNo se lograron realizar los cambios\n");
      }

    }

  }

  /**
   * Method that allows the editing of the recorded data of a species Flora.
   */
  private void editFlora() {

    // control situation when the user wants to edit a species when nothing is
    // registered.
    if (!CatalogueController.verifyRegisteredFlora()) {
      System.out.println("\nNo existe ninguna Especie Flora registrada\n");
    } else {
      System.out.println("\nIngresa el nombre de la especie que deseas editar\n");
      sc.nextLine();
      String specieName = sc.nextLine();

      System.out.println("\nEscoge la opcion de acuerdo con el dato que deseas editar"
          + "\n1. Nombre"
          + "\n2. Nombre cientifico"
          + "\n3. Estado floral (true) o (false)"
          + "\n4. Estado frutal (true) o (false)"
          + "\n5. Altura maxima");
      int characteristicEdit = sc.nextInt();

      // Control condition that warns if the action performed was completed
      // successfully.
      System.out.println("\nIngresa la nueva informacion para actualizar");
      sc.nextLine();
      String newInformation = sc.nextLine();

      // Control condition that warns if the action performed was completed
      // successfully.
      if (CatalogueController.editFauna(specieName, characteristicEdit, newInformation)) {
        System.out.println("\nDatos editados correctamente\n");
      } else {
        System.out.println("\nNo se lograron realizar los cambios\n");
      }

    }

  }

  /**
   * Method that allows the elimination of any species registered by the user.
   */
  private void deleteSpecie() {

    // control situation when the user wants to edit a species when nothing is
    // registered.
    if (!CatalogueController.verifyRegisteredFauna() && !CatalogueController.verifyRegisteredFlora()) {
      System.out.println("\nNo existe ninguna Especie registrada hasta el momento\n");
    } else {

      System.out.println("\nIngresa el nombre de la especie que deseas borrar\n");
      sc.nextLine();
      String name = sc.nextLine();

      if (CatalogueController.deleteSpecies(name)) {
        System.out.println("\nEspecie eliminada exitosamente\n");
      } else {
        System.out.println("\nNo se pudo eliminar la especie\n");
      }

    }

  }

}