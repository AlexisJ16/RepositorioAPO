package model;

public class Level {

   private Enemy[] enemy;
   private Treasure[] treasure;
   private TypeLevel typeDifficult;

   private int id;
   private int pointsPerlevel;

   /**
    * @param id             int: It is the unique identification of the level.
    * @param pointsPerlevel int: These are the points required to pass to the next
    *                       level.
    */
   public Level(int id, int pointsPerlevel) {
      this.enemy = new Enemy[25];
      this.treasure = new Treasure[50];
      this.id = id;
      this.pointsPerlevel = pointsPerlevel;
      typeDifficult = null;

   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getpointsPerlevel() {
      return pointsPerlevel;
   }

   public void setpointsPerlevel(int pointsPerlevel) {
      this.pointsPerlevel = pointsPerlevel;
   }

   public TypeLevel getTypeDifficult() {
      return typeDifficult;
   }

   public void setTypeDifficult(TypeLevel typeDifficult) {
      this.typeDifficult = typeDifficult;
   }

   /**
    * Method that allows to add a treasure to a level.
    * 
    * @param name           String: It is the name of the treasure.
    * @param url            String: It is the url of the image allusive to the
    *                       treasure.
    * @param score          int: It is the score awarded to the player when it is
    *                       obtained.
    * @param positionX      int: Position x in the game resolution.
    * @param positionY      int: Position y in the game resolution.
    * @param numberTreasure int: It is the number of treasures registered in the
    *                       same level.
    * @return validation boolean: It is the condition that allows to evaluate if
    *         the method meets the requirements to be executed in a satisfactory
    *         way.
    */
   public boolean addTreasureToLevel(String name, String url, int score, int positionX, int positionY,
         int numberTreasure) {

      boolean validation = true;

      Treasure trs = new Treasure(name, url, score, positionX, positionY, numberTreasure);
      for (int j = 0; j < numberTreasure; j++) {
         validation = false;
         for (int i = 0; i < 50 && !validation; i++) {
            if (treasure[i] == null) {
               treasure[i] = trs;
               validation = true;
            }
         }
      }
      setTypeDifficult(estimateDifficulty());
      return validation;

   }

   /**
    * Allows you to add an enemy type to a level.
    * 
    * @param name      String: It is the name of the enemy.
    * @param option    int: This is the type of enemy chosen by the user.
    * @param damage    int: Damage caused by the enemy.
    * @param score     int: Is the score subtracted from the player when he
    *                  is defeated by the player.
    * @param positionX int: Position x in the game resolution.
    * @param positionY int: Position y in the game resolution.
    * @return validation boolean: Returns true if all conditions for adding an
    *         enemy to a level are met.
    */
   public boolean addEnemyToLevel(String name, int option, int damage, int score, int positionX, int positionY) {

      boolean validation = true;
      Enemy en = searchEnemy(name);
      boolean check = availableEnemy();

      if (check == true) {
         en = new Enemy(name, option, damage, score, positionX, positionY);
         check = false;
         for (int i = 0; i < 20 && !check; i++) {
            if (enemy[i] == null) {
               enemy[i] = en;
               check = true;
               setTypeDifficult(estimateDifficulty());
            }
         }
      }
      return validation;

   }

   /**
    * Allows the validity of use of an enemy.
    * 
    * @return validation boolean: Return with the validation that allows to use an
    *         enemy inside a method.
    */
   public boolean availableEnemy() {

      boolean validation = true;
      if (enemy[24] != null) {
         validation = false;
      }
      return validation;

   }

   /**
    * Searches for an enemy within the system for subsequent operation in another
    * method.
    * 
    * @param name String: It is the name of the enemy.
    * @return en Enemy: Return on the enemy object found inside the Enemies array.
    */
   public Enemy searchEnemy(String name) {
      Enemy en = null;
      boolean check = false;
      for (int i = 0; i < 25 && !check; i++) {
         if (enemy[i] != null && enemy[i].getName().equalsIgnoreCase(name)) {
            en = enemy[i];
            check = true;
         }
      }

      return en;
   }

   /**
    * Method that allows to calculate the difficulty of a level according to the
    * number of points awarded by enemies and treasures.
    * 
    * @return dificult TypeLevel: Returns the difficulty obtained according to the
    *         number of points entered.
    */
   public TypeLevel estimateDifficulty() {

      TypeLevel dificult = null;
      int pointEnemy = 0;
      int pointTreasure = 0;

      if (treasure[0] == null) {
         pointEnemy = 0;
      } else {
         for (int i = 0; i < 25; i++) {
            if (enemy[i] != null) {
               pointEnemy += enemy[i].getScore();
            }
         }
      }

      if (enemy[0] == null) {
         pointTreasure = 0;
      } else {
         for (int i = 0; i < 25; i++) {
            if (treasure[i] != null) {
               pointTreasure += treasure[i].getScore();
            }
         }
      }

      if (pointTreasure + pointEnemy == 0) {
         dificult = null;
      }
      if (pointTreasure > pointEnemy) {
         dificult = TypeLevel.EASY;
      }
      if (pointTreasure < pointEnemy) {
         dificult = TypeLevel.HARD;
      }
      if (pointTreasure == pointEnemy) {
         dificult = TypeLevel.MEDIUM;
      }

      return dificult;

   }

   /**
    * Method that allows to calculate the number of enemies in all registered
    * levels.
    * 
    * @return enemyReport String: Return in the report about the enemy.
    */
   public String[] calculateEnemy() {

      int amount = 0;
      String[] enemyReport;
      for (int i = 0; i < 25; i++) {
         if (enemy[i] != null) {
            amount++;
         }
      }

      enemyReport = new String[amount];
      for (int h = 0; h < amount; h++) {
         enemyReport[h] = enemy[h].getName();
      }

      return enemyReport;
   }

   /**
    * Method that allows to calculate all the treasures registered in the game.
    * 
    * @return treasureReport String: Return in the report about the treasure.
    */
   public String[] calculateTreasure() {

      String[] treasureReport;
      int amount = calculateMostRepeatedTreasure();

      treasureReport = new String[amount];
      for (int i = 0; i < 50; i++) {
         if (treasure[i] != null) {
            int name = 0;
            for (int h = 0; h < amount; h++) {
               if (treasure[i].getName().equalsIgnoreCase(treasureReport[h])) {
                  name++;
               }
               if (name == 0 && h == amount - 1) {
                  boolean validation = false;
                  for (int t = 0; t < amount && !validation; t++) {
                     if (treasureReport[t] == null) {
                        treasureReport[t] = treasure[i].getName();
                        validation = true;
                     }
                  }
               }
            }
         }
      }
      return treasureReport;
   }

   /**
    * Method that allows to calculate the most repeated treasure in all levels of
    * the game.
    * 
    * @return amount int: Returns the amount calculated by the method, in this case
    *         the most repeated treasure.
    */
   public int calculateMostRepeatedTreasure() {

      int amount = 0;
      for (int i = 0; i < 50; i++) {
         if (treasure[i] != null) {
            i += treasure[i].getNumberTreasure() - 1;
            amount++;
         }
      }

      return amount;

   }

   /**
    * Method that allows to calculate the total number of treasures in all levels.
    * 
    * @param treasureName String: It is the name of the treasure.
    * @return amount int: Returns the amount calculated by the method, in this case
    *         it is the number of treasures at all levels.
    */
   public int NumberTreasuresAtAllLevels(String treasureName) {

      int amount = 0;
      boolean validation = false;
      for (int i = 0; i < 50 && !validation; i++) {
         if (treasure[i] != null && treasure[i].getName().equalsIgnoreCase(treasureName)) {
            amount = treasure[i].getNumberTreasure() + amount;
            validation = true;
         }
      }

      return amount;

   }

   /**
    * @param enemySelection int: It is the user's choice as to the type of enemy.
    * @return amount int: Returns the amount calculated by the method.
    */
   public int calculateEnemyPerType(int enemySelection) {

      int amount = 0;

      for (int i = 0; i < 25; i++) {
         if (enemy[i] != null && enemy[i].enemySelection() == enemySelection) {
            amount++;
         }
      }
      return amount;

   }

   /**
    * Method that calculates the treasure that gives more points to the player for
    * being obtained.
    * 
    * @return treasurePoint int: Returns in the amount of points awarded by the
    *         treasury
    */
   public int[] treasureWithMorePoints() {

      int[] treasurePoint;
      String[] treasureName;
      int amount = calculateMostRepeatedTreasure();

      treasurePoint = new int[amount];
      treasureName = new String[amount];

      for (int i = 0; i < 50; i++) {
         if (treasure[i] != null) {
            int name = 0;
            for (int h = 0; h < amount; h++) {
               if (treasure[i].getName().equalsIgnoreCase(treasureName[h])) {
                  name++;
               }
               if (name == 0 && h == amount - 1) {
                  boolean validation = false;
                  for (int t = 0; t < amount && !validation; t++) {
                     if (treasureName[t] == null) {
                        treasureName[t] = treasure[i].getName();
                        treasurePoint[t] = treasure[i].getNumberTreasure();
                        validation = true;
                     }
                  }
               }
            }
         }
      }

      return treasurePoint;

   }

   /**
    * Method that allows to calculate the enemy that gives the most points for
    * being defeated.
    * 
    * @return calculateEnemyWithHighestScore String: Return on the points awarded
    *         by the enemy for his defeat.
    */
   public String calculateEnemyWithHighestScore() {

      String calculateEnemyWithHighestScore;
      int point = 0;
      int position = 0;

      for (int i = 0; i < 25; i++) {
         if (enemy[i] != null && point > enemy[i].getScore()) {
            point = enemy[i].getScore();
            position = i;
         }
      }
      calculateEnemyWithHighestScore = enemy[position].getName();

      return calculateEnemyWithHighestScore;

   }

   /**
    * Method that allows you to find the name of the enemy with the most points in
    * the whole game.
    * 
    * @param name String: It is the name of the enemy.
    * @return point: Represents the points of the enemy sought by name.
    */
   public int enemyNameWithScore(String name) {
      int point = 0;

      Enemy en = searchEnemy(name);
      if (en != null) {
         point = en.getScore();
      }
      return point;
   }

   /**
    * Method that allows to calculate the number of constants that the name of a
    * selected enemy has.
    * 
    * @return amount int: Returns the number of letters found in the names of
    *         enemies.
    */
   public int consonantsInEnemies() {

      int amount = 0;
      char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
            'x', 'y', 'z' };

      for (int i = 0; i < 25; i++) {
         if (enemy[i] != null) {
            for (int h = 0; h < enemy[i].getName().length(); h++) {
               for (int j = 0; j < consonants.length; j++) {
                  if (enemy[i].getName().charAt(h) == consonants[j]) {
                     amount++;
                  }
               }
            }
         }
      }
      return amount;

   }

}
