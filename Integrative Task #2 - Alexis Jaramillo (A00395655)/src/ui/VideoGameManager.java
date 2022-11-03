package ui;

import model.VideoGameController;
import java.util.Scanner;

public class VideoGameManager {

  public static Scanner sc = new Scanner(System.in);
  private VideoGameController videoGame;

  /**
   * The screen resolution method of the game is executed.
   */
  public VideoGameManager() {
    chooseResolution();
  }

  /**
   * Menu that allows interaction with the user, allowing to choose one of the
   * functionalities of the program for its later execution.
   * 
   * @param args String: argument of the main class.
   */
  public static void main(String[] args) {
    VideoGameManager controller = new VideoGameManager();

    boolean exit = false;

    while (!exit) {
      System.out.println("1. Registar un jugador. ");
      System.out.println("2. Registrar un enemigo a un nivel.");
      System.out.println("3. Registrar un tesoro a un nivel");
      System.out.println("4. Modificar el puntaje de un jugador");
      System.out.println("5. Incrementar el nivel de un jugador");
      System.out.println("6. Ver los tesoros y los enemigos de un nivel");
      System.out.println("7. Ver la cantidad de un tesoro en todos los niveles");
      System.out.println("8. Ver la cantidad de un tipo de enemigo en todos los niveles");
      System.out.println("9. Ver el tesoro mas repetido en todos los niveles");
      System.out.println("10. Ver el enemigo que mas puntos otorga y su ubicacion");
      System.out.println("11. Ver la cantidad de consonantes en los nombres de los enemigos del juego");
      System.out.println("12. Top 5 de jugadores con mas puntaje ");
      System.out.println("0. Salir del VideoJuego");
      // User's choice.
      int option;
      option = sc.nextInt();
      sc.nextLine();

      switch (option) {
        case 1:
          // Register a player in the system.
          controller.registerPlayer();
          break;

        case 2:
          // Register an enemy at one level.
          controller.registerEnemyToLevel();
          break;

        case 3:
          // Register a treasure at one level.
          controller.registerTreasureToLevel();
          break;

        case 4:
          // modify a player's score.
          controller.changePlayerPoints();
          break;

        case 5:
          // increase the level of a player.
          controller.increasePlayerLevel();
          break;

        case 6:
          // Report the number of treasures and enemies in a level.
          controller.treasuresAndEnemiesPerLevel();
          break;

        case 7:
          // Report of the amount of treasures at all levels.
          controller.NumberTreasuresAtAllLevels();
          break;

        case 8:
          // Report the number of enemies in all levels.
          controller.NumberEnemiesAtAllLevels();
          break;

        case 9:
          // Most repeated treasure report in the game.
          controller.mostRepeatedTreasure();
          break;

        case 10:
          // Report of the enemy with the highest score.
          controller.highestScoringEnemy();
          break;

        case 11:
          // Report the number of consonants in enemy names.
          controller.consonantsInEnemies();
          break;

        case 12:
          // List of top scoring players.
          controller.topPlayers();
          break;

        case 0:
          // System output.
          exit = true;
          break;

        default:
          // Control condition.
          System.out.println("Ingresa una opcion valida en el sistema...");
          break;
      }
    }
  }

  /**
   * Allows the user to choose the resolution of the game.
   */
  public void chooseResolution() {
    System.out.println("Bienvenido al juego, jugador");
    System.out.println("Ingresa la resolucion con la que deseas crear el juego");
    System.out.println("1.SD  2.QHD  3.HD  4.FHD  5.QHDD  6.UHD  7.UHD8\n");
    int resolution = sc.nextInt();

    int x = 0;
    int y = 0;

    switch (resolution) {

      case 1:
        x = 640;
        y = 480;
        break;

      case 2:
        x = 960;
        y = 540;
        break;

      case 3:
        x = 1280;
        y = 720;
        break;

      case 4:
        x = 1920;
        y = 1080;
        break;

      case 5:
        x = 2560;
        y = 1440;
        break;

      case 6:
        x = 3840;
        y = 2160;
        break;

      case 7:
        x = 7680;
        y = 4320;
        break;

    }
    videoGame = new VideoGameController(x, y);
    System.out.println("Inicializando juego...");
    System.out.println("El juego fue creado de manera exitosa\n");

  }

  /**
   * Allows the registration of a player in the system.
   */
  public void registerPlayer() {

    System.out.println("Ingresa el nickname del jugador");
    String nickname = sc.nextLine();
    System.out.println("Ingresa el nombre del jugador");
    String name = sc.nextLine();
    System.out.println(videoGame.registerPlayer(nickname, name));

  }

  /**
   * Allows the registration of an enemy at one level in the system.
   */
  public void registerEnemyToLevel() {

    System.out.println("Ingresa el nombre del enemigo\n");
    String name = sc.nextLine();
    System.out.println("Escoge el tipo de enemigo que deseas crear:\n");
    System.out.println("1. Ogre");
    System.out.println("2. Abstract");
    System.out.println("3. Boss");
    System.out.println("4. Magic\n");
    int option = sc.nextInt();
    System.out.println("Ingresa el daño que produce este enemigo\n");
    int damage = sc.nextInt();
    System.out.println("Ingresa la puntuacion que otorga este enemigo al ser derrotado");
    System.out.println("***Esta puntuacion debe ser mayor a 0***\n");
    int score = sc.nextInt();

    System.out.println("Ingresa el nivel al que ingresa el enemigo");
    System.out.println("Debe ser un nivel entre el 1 y el 10\n");
    int enemyLevel = sc.nextInt();

    // Generates random enemy positions on the screen.
    int positionX = videoGame.generatePositionX(videoGame.getX());
    int positionY = videoGame.generatePositionY(videoGame.getY());

    System.out.println(videoGame.registerEnemyToLevel(name, option, damage, score, enemyLevel, positionX, positionY));

  }

  /**
   * Allows the registration of a treasure at one level in the system.
   */
  public void registerTreasureToLevel() {

    System.out.println("Ingresa el nombre de tesoro");
    String name = sc.nextLine();
    System.out.println("Ingresa la URL de la imagen del tesoro");
    String url = sc.nextLine();
    System.out.println("Ingresa el puntaje que otorga el tesoro");
    int score = sc.nextInt();
    System.out.println("Ingresa el nivel al que ingresa el enemigo");
    System.out.println("Debe ser un nivel entre el 1 y el 10\n");
    int level = sc.nextInt();

    System.out.println("Ingresa la cantidad de veces que se repite este tesoro en este nivel");
    System.out.println("Este numero debe ser mayor a 0\n");
    int numberTreasure = sc.nextInt();

    // Generates random enemy positions on the screen.
    int positionX = videoGame.generatePositionX(videoGame.getX());
    int positionY = videoGame.generatePositionY(videoGame.getY());

    System.out
        .println(videoGame.registerTreasureToLevel(name, url, score, level, numberTreasure, positionX, positionY));

  }

  /**
   * Allows the change of a player's score.
   */
  public void changePlayerPoints() {

    System.out.println("Ingresa el nickname del usuario al que deseas cambiar el puntaje\n");
    String nickname = sc.nextLine();
    System.out.println("Ingresa el nuevo puntaje del jugador\n");
    System.out.println("Recuerde que esta modificacion debe cumplir con ciertas condiciones:");
    System.out.println("Debe ser mayor a 10 puntos");
    System.out.println("Debe ser mayor a la puntuacion actual");
    System.out.println("Debe ser menor a 999\n");
    int newScore = sc.nextInt();
    System.out.println(videoGame.changePlayerScore(nickname, newScore));

  }

  /**
   * Allows to increase the level of a player.
   */
  public void increasePlayerLevel() {

    System.out.println("Ingresa el nickname del usuario al que deseas incrementar el nivel\n");
    String nickname = sc.nextLine();
    System.out.println(videoGame.increasePlayerLevel(nickname));

  }

  /**
   * Allows the reporting of level information, the number of enemies and
   * treasures contained in the level.
   */
  public void treasuresAndEnemiesPerLevel() {

    System.out.println("Ingresa el nivel al que deseas ver la informacion");
    System.out.println("Debe ser un nivel entre el 1 y el 10\n");
    int level = sc.nextInt();

    System.out.println(videoGame.allEnemiesPerLevel(level));
    System.out.println(videoGame.allTreasuresPerLevel(level));

  }

  /**
   * Allows you to see the amount of a specific treasure at all levels.
   */
  public void NumberTreasuresAtAllLevels() {

    System.out.println("Ingresa el nombre del tesoro\n");
    String name = sc.nextLine();
    System.out.println(videoGame.numberOfTreasures(name));

  }

  /**
   * Allows you to see the amount of a specific type of enemy at all levels.
   */
  public void NumberEnemiesAtAllLevels() {

    System.out.println("Escoge el tipo de enemigo que deseas contar:\n");
    System.out.println("1. Ogre");
    System.out.println("2. Abstract");
    System.out.println("3. Boss");
    System.out.println("4. Magic\n");
    int type = sc.nextInt();

    System.out.println(videoGame.numberOfEnemiesByType(type));

  }

  /**
   * Displays the most repeated treasure in the game.
   */
  public void mostRepeatedTreasure() {

    System.out.println(videoGame.mostRepeatedTreasure());

  }

  /**
   * Displays the enemy that gives the highest score in the game.
   */
  public void highestScoringEnemy() {

    System.out.println(videoGame.GreaterEnemyScore());

  }

  /**
   * Displays the number of consonants in the names of enemies in the game.
   */
  public void consonantsInEnemies() {

    System.out.println(videoGame.numberOfConsonantsInEnemy());

  }

  /**
   * Displays the top 5 highest scoring players.
   */
  public void topPlayers() {

    System.out.println(videoGame.topPlayers());

  }

}