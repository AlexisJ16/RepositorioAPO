package model;

import java.util.Random;

public class VideoGameController {

  private int x;
  private int y;

  /**
   * Arrangement of players.
   */
  private Player[] player;

  /**
   * Arrangement of levels.
   */
  private Level[] level;

  /**
   * @param x int: Dimension x of the game resolution.
   * @param y int: Dimension y of the game resolution.
   */
  public VideoGameController(int x, int y) {
    this.x = x;
    this.y = y;

    player = new Player[20];
    level = new Level[10];

    // Establishment of an identifier, and the number of points belonging to each
    // level.
    level[0] = new Level(1, 50);
    level[1] = new Level(2, 100);
    level[2] = new Level(3, 200);
    level[3] = new Level(4, 300);
    level[4] = new Level(5, 400);
    level[5] = new Level(6, 500);
    level[6] = new Level(7, 600);
    level[7] = new Level(8, 700);
    level[8] = new Level(9, 800);
    level[9] = new Level(10, 1000);

  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  /**
   * Method that allows to register a player in the system.
   * 
   * @param nickname String:It is the player's unique identifier.
   * @param name     String: It is the player's name.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String registerPlayer(String nickname, String name) {

    String msg = "Jugador registrado exitosamente";

    Player py = searchPlayer(nickname);
    if (py != null) {
      msg = "El nickname del jugador ya existe";
    } else {
      boolean check = playerAvailable();
      if (check == true) {
        py = new Player(nickname, name, level[0]);
        check = false;
        for (int i = 0; i < 20 && !check; i++) {
          if (player[i] == null) {
            player[i] = py;
            check = true;
          }
        }
      }
    }
    return msg;

  }

  /**
   * Method that allows to register an enemy at a level in the system.
   * 
   * @param name       String: It is the name of the enemy.
   * @param option     int: This is the type of enemy selected by the user.
   * @param damage     int: Damage caused by the enemy.
   * @param score      int: Is the score subtracted from the player when he is
   *                   defeated by the player.
   * @param enemyLevel int: This is the level to which the enemy belongs.
   * @param positionX  int: Position x in the game resolution.
   * @param positionY  int: Position y in the game resolution.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String registerEnemyToLevel(String name, int option, int damage, int score, int enemyLevel, int positionX,
      int positionY) {

    String msg = "Enemigo(s) registrado(s) exitosamente";
    int variable = 0;
    for (int i = 1; i <= 10; i++) {
      if (i == enemyLevel) {
        level[variable].addEnemyToLevel(name, option, damage, score, positionX, positionY);
      }
      variable++;
    }
    return msg;

  }

  /**
   * @param name           String: It is the name of the treasure.
   * @param url            String: It is the url of the image allusive to the
   *                       treasure.
   * @param score          int: It is the score awarded to the player when it is
   *                       obtained.
   * @param treasuryLevel  int: This is the level to which the treasure belongs.
   * @param numberTreasure int: It is the number of treasures registered in the
   *                       same level.
   * @param positionX      int: Position x in the game resolution.
   * @param positionY      int: Position y in the game resolution.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String registerTreasureToLevel(String name, String url, int score, int treasuryLevel, int numberTreasure,
      int positionX, int positionY) {

    String msg = "Tesoro(s) registrado(s) exitosamente";
    boolean check = true;
    int variable = 0;
    for (int i = 1; i <= 10; i++) {
      if (i == treasuryLevel) {
        check = level[variable].addTreasureToLevel(name, url, score, numberTreasure, positionX, positionY);
        if (check == false) {
          msg = "No se permite registrar esa cantidad de tesoros... Por el momento";
        }
      }
      variable++;
    }
    return msg;
  }

  /**
   * Method that allows the change of a player's score.
   * 
   * @param nickname String: It is the player's unique identifier.
   * @param newScore int: This is the new score obtained by the player.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String changePlayerScore(String nickname, int newScore) {

    String msg = "Puntaje modificado exitosamente";
    Player py = searchPlayer(nickname);
    py.setScore(newScore);
    return msg;

  }

  /**
   * Method that allows the increase of a player's level.
   * 
   * @param nickname String: It is the player's unique identifier.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String increasePlayerLevel(String nickname) {

    Player py = searchPlayer(nickname);
    String msg = "Nivel incrementado exitosamente";
    int playerScore = py.getScore();
    Level playerLevel = py.getplayerLevel();

    if (playerScore < playerLevel.getpointsPerlevel()) {
      if (playerScore == 999) {
        msg = "¡¡Estas en el nivel maximo!!";
      } else {
        int amount = playerLevel.getpointsPerlevel() - playerScore;
        msg = "No puede avanzar al siguiente nivel, debes obtener: " + amount + "puntos";
      }
    } else {
      for (int i = 0; i < 10; i++) {
        if (playerLevel.getId() == level[i].getId()) {
          for (int variable = i; variable < 10; variable++) {
            if (variable == 9) {
              if (playerScore >= 800 && playerScore < 1000) {
                py.setplayerLevel(level[variable]);
              }
            }
            if ((playerScore == level[variable].getpointsPerlevel())
                || (playerScore > level[variable].getpointsPerlevel()
                    && playerScore < level[variable + 1].getpointsPerlevel())) {
              py.setplayerLevel(level[variable + 1]);
            }
          }
        }

      }
    }
    return msg;

  }

  /**
   * Method that reports the total amount of treasures at all levels.
   * 
   * @param enemyLevel int: This is the level to which the enemy belongs.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String allEnemiesPerLevel(int enemyLevel) {

    String msg = " ";
    String[] enemies = level[enemyLevel].calculateEnemy();
    for (int i = 0; i < level[enemyLevel].calculateEnemy().length; i++) {
      msg += enemies[i] + " ,";
    }
    return msg;

  }

  /**
   * Method that reports the total amount of enemies by type at all levels.
   * 
   * @param treasuryLevel int: This is the level to which the treasure belongs.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String allTreasuresPerLevel(int treasuryLevel) {

    String msg = " ";
    String[] treasures = level[treasuryLevel].calculateTreasure();
    for (int i = 0; i < level[treasuryLevel].calculateTreasure().length; i++) {
      if (treasures[i] != null) {
        msg += treasures[i];
      }
    }
    return msg;

  }

  /**
   * Method that informs the most repeated treasure at all levels.
   * 
   * @param treasureName String: It is the name of the treasure that allows the
   *                     total count to be made.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String numberOfTreasures(String treasureName) {

    int amount = 0;
    for (int i = 0; i < 10; i++) {
      amount = level[i].NumberTreasuresAtAllLevels(treasureName) + amount;
    }
    String msg = "La cantidad total es de: " + amount + " tesoros en todos los niveles";
    return msg;

  }

  /**
   * Method that reports the number of total enemies by type.
   * 
   * @param enemySelection int: It is the user's selection of the type of enemy.
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String numberOfEnemiesByType(int enemySelection) {
    int amount = 0;
    for (int i = 0; i < 10; i++) {
      amount = level[i].calculateEnemyPerType(enemySelection) + amount;
    }
    String msg = "La cantidad total de este tipo de enemigo es de: " + amount + " en todos los niveles";
    return msg;

  }

  /**
   * Method that allows to calculate the most repeated treasure in the whole game.
   * 
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String mostRepeatedTreasure() {

    String msg = "";
    String[] name;
    int[] repetitions;
    int amount = 0;

    for (int i = 0; i < 10; i++) {
      amount += level[i].treasureWithMorePoints().length;
    }

    name = new String[amount];
    repetitions = new int[amount];

    for (int variable = 0; variable < 10; variable++) {
      for (int i = 0; i < level[variable].treasureWithMorePoints().length; i++) {
        for (int j = 0; j < amount; j++) {
          if (name[j] != null && name[j].equalsIgnoreCase(level[variable].calculateTreasure()[i])) {
            repetitions[j] = repetitions[j] + level[variable].treasureWithMorePoints()[i];
          } else if (j == amount - 1) {
            boolean check = false;
            for (int k = 0; k < amount && !check; k++) {
              if (name[k] == null) {
                name[k] = level[variable].calculateTreasure()[i];
                repetitions[k] = level[variable].treasureWithMorePoints()[i];
                check = true;
              }
            }

          }
        }
      }
    }

    int points = 0;
    int position = 0;
    for (int i = 0; i < amount; i++) {
      if (points > repetitions[i]) {
        position = i;
        points = repetitions[i];
      }
    }
    msg = "El tesoro mas repetido en este nivel es: " + name[position];
    return msg;

  }

  /**
   * Method that allows to calculate the enemy with the highest score.
   * 
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String GreaterEnemyScore() {
    String msg = " ";
    int point = 0;
    int position = 0;

    for (int i = 0; i < 10; i++) {
      if (level[i].enemyNameWithScore(level[i].calculateEnemyWithHighestScore()) > point) {
        point = level[i].enemyNameWithScore(level[i].calculateEnemyWithHighestScore());
        position = i;
      }
    }
    msg = "El enemigo con mayor puntaje es: " + level[position].calculateEnemyWithHighestScore() + " En el nivel "
        + level[position].getId();
    return msg;

  }

  /**
   * Method for calculating the number of consonants in the names of enemies.
   * 
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String numberOfConsonantsInEnemy() {

    String msg = "";
    int amount = 0;
    for (int i = 0; i < 10; i++) {
      amount += level[i].consonantsInEnemies();
    }
    msg = "El numero de consonantes en el nombre del enemigo es de: " + amount + " letras";
    return msg;

  }

  /**
   * Method that allows to make the top 5 players with the highest scores.
   * 
   * @return msg String: This is the message that is printed on the screen with
   *         the result of the method.
   */
  public String topPlayers() {
    String msg = "";

    int top1 = 0;
    int top2 = 0;
    int top3 = 0;
    int top4 = 0;
    int top5 = 0;

    String name1 = "";
    String name2 = "";
    String name3 = "";
    String name4 = "";
    String name5 = "";

    for (int i = 0; i < 20; i++) {

      if (player[i] != null && player[i].getScore() > top1) {

        top1 = player[i].getScore();
        top1 = top2;
        top2 = top3;
        top3 = top4;
        top4 = top5;

        name1 = player[i].getNickname();
        name1 = name2;
        name2 = name3;
        name3 = name4;
        name4 = name5;

      } else if (player[i] != null && player[i].getScore() > top2) {

        top2 = player[i].getScore();
        top2 = top3;
        top3 = top4;
        top4 = top5;

        name2 = player[i].getNickname();
        name2 = name3;
        name3 = name4;
        name4 = name5;

      } else if (player[i] != null && player[i].getScore() > top3) {

        top3 = player[i].getScore();
        top3 = top4;
        top4 = top5;

        name3 = player[i].getNickname();
        name3 = name4;
        name4 = name5;

      } else if (player[i] != null && player[i].getScore() > top4) {

        top4 = player[i].getScore();
        top4 = top5;

        name4 = player[i].getNickname();
        name4 = name5;

      } else if (player[i] != null && player[i].getScore() > top5) {

        top5 = player[i].getScore();
        name5 = player[i].getNickname();

      }

      msg = "top 5 player \n" +
          "1." + name1 + ": " + top1 + "\n" +
          "2." + name2 + ": " + top2 + "\n" +
          "3." + name3 + ": " + top3 + "\n" +
          "4." + name4 + ": " + top4 + "\n" +
          "5." + name5 + ": " + top5 + "\n";
    }
    return msg;

  }

  /**
   * @param nickname String:It is the player's unique identifier.
   * @return py Player: Returns on creation of a player object, within the Players
   *         array.
   */
  public Player searchPlayer(String nickname) {

    Player py = null;
    boolean check = false;
    for (int i = 0; i < 20 && !check; i++) {
      if (player[i] != null && player[i].getNickname().equals(nickname)) {
        py = player[i];
        check = true;
      }
    }
    return py;

  }

  /**
   * Method that allows to verify if a player is optimal to perform an operation.
   * 
   * @return check boolean: Checks whether the evaluated condition meets the
   *         conditions or not.
   */
  public boolean playerAvailable() {

    boolean check = true;
    if (player[20] != null) {
      check = false;
    }
    return check;

  }

  /**
   * @param x int: Position x in the game resolution.
   * @return position int: Return to the respective position within the game
   *         resolution.
   */
  public int generatePositionX(int x) {

    int position = 0;
    Random random = new Random();
    position = (int) (random.nextInt() * x);
    return position;

  }

  /**
   * @param y int: Position y in the game resolution.
   * @return position int: Return to the respective position within the game
   *         resolution.
   */
  public int generatePositionY(int y) {

    int position = 0;
    Random random = new Random();
    position = (int) (random.nextInt() * y);
    return position;

  }

}
