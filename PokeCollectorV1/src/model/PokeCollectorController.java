package model;

//Controller es donde se realizan todas las operaciones y hace el papel de memoria de todo el codigo
//Realizar todos los arreglos del programa para almacenar la informacion registrada por el usuario

public class PokeCollectorController {

	/**
	 * Collection of Pokedexes in the program.
	 */
	private Pokedex[] pokedexes;

	/**
	 * Collection of Pokemon in the program.
	 */
	private Pokemon[] pokemons;

	/**
	 * Collection of Moves in the program.
	 */
	private Move[] moves;

	/**
	 * Collection of Teams in the program.
	 */
	private Team[] teams;

	/**
	 * Start of the controller class
	 */
	public PokeCollectorController() {
		this.pokedexes = new Pokedex[3];
		this.pokemons = new Pokemon[1000];
		this.moves = new Move[50];
		this.teams = new Team[5];
	}

	/**
	 * Method for registering a Pokedex.
	 * 
	 * @param idPokedex     int: Unique Pokedex identifier.
	 * @param region        String: Is the region to which the Pokedex belongs.
	 * @param pokemonNumber int: This is the number of Pokemon in the Pokedex.
	 * @param gymNumber     int: It is the amount of gyms in the Pokedex.
	 * @param capitalCity   String: It is the capital city of the Pokedex.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean registerPokedex(int idPokedex, String region, int pokemonNumber, int gymNumber, String capitalCity) {
		Pokedex newPokedex = new Pokedex(idPokedex, region, pokemonNumber, gymNumber, capitalCity);
		for (int i = 0; i < pokedexes.length; i++) {
			if (pokedexes[i] == null) {
				pokedexes[i] = newPokedex;
				return true;
			}
		}
		return false;
	}

	/**
	 * This is the method for displaying the registered Pokedexes.
	 * 
	 * @return msg String: This is the message that is printed on the screen showing
	 *         the met operation.
	 */
	public String showPokedexes() {
		String msg = "";
		for (int i = 0; i < pokedexes.length; i++) {
			if (pokedexes[i] != null) {
				msg += pokedexes[i].toString();
			}
		}
		return msg;
	}

	/**
	 * Method for the registration of a Pokemon.
	 * 
	 * @param name    String: It is the name of the pokemon.
	 * @param id      int: Unique Pokemon identifier.
	 * @param type1   String: It is the first type the pokemon can have.
	 * @param types2  String: It is the second type that the pokemon can have.
	 * @param health  int: It is the health of the pokemon.
	 * @param attack  int: It is the attack that the pokemon has.
	 * @param defense int: It is the pokemon's defense.
	 * @param speed   int: It is the speed of the pokemon.
	 * @param day     int: It is the day of obtaining the pokemon.
	 * @param month   int: It is the month of obtaining the pokemon.
	 * @param year    int: It is the year the pokemon was obtained.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean registerPokemon(String name, int id, String type1, String types2, int health, int attack,
			int defense, int speed, int day, int month, int year) {
		Pokemon newPokemon = new Pokemon(name, id, type1, types2, health, attack, defense, speed,
				new Date(day, month, year));
		for (int i = 0; i < pokemons.length; i++) {
			if (pokemons[i] == null) {
				pokemons[i] = newPokemon;
				return true;
			}
		}
		return false;
	}

	/**
	 * It is the method to display the registered Pokemon.
	 * 
	 * @return msg String: This is the message that is printed on the screen showing
	 *         the met operation.
	 */
	public String showPokemons() {
		String msg = "";
		for (int i = 0; i < pokemons.length; i++) {
			if (pokemons[i] != null) {
				msg += pokemons[i].toString();
			}
		}
		return msg;
	}

	/**
	 * Method for the registration of a Movement.
	 * 
	 * @param idMove             int: Unique Move identifier.
	 * @param name               String: It is the name of the movement.
	 * @param type               String: It is the type of the movement.
	 * @param basevalue          int: It is the base value of the movement.
	 * @param maximumvalue       int: It is the maximum value of the movement.
	 * @param accuracypercentage int: It is the percentage of precision of the
	 *                           movement.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean registerMove(int idMove, String name, String type, int basevalue, int maximumvalue,
			int accuracypercentage) {
		Move newMove = new Move(idMove, name, type, basevalue, maximumvalue, accuracypercentage);
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] == null) {
				moves[i] = newMove;
				return true;
			}
		}
		return false;
	}

	/**
	 * It is the method to show the registered Moves.
	 * 
	 * @return msg String: This is the message that is printed on the screen showing
	 *         the met operation.
	 */
	public String showMoves() {
		String msg = "";
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != null) {
				msg += moves[i].toString();
			}
		}
		return msg;
	}

	/**
	 * Method for the registration of a Team.
	 * 
	 * @param idTeam int: Unique Team identifier.
	 * @param name   String: It is the name of the Team.
	 * @param day    int: It is the day of obtaining the Team.
	 * @param month  int: It is the month of obtaining the Team.
	 * @param year   int: It is the year the Team was obtained.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean registerTeam(int idTeam, String name, int day, int month, int year) {
		Date newDate = new Date(day, month, year);
		Team newTeam = new Team(idTeam, name, newDate);
		for (int i = 0; i < teams.length; i++) {
			if (teams[i] == null) {
				teams[i] = newTeam;
				return true;
			}
		}
		return false;
	}

	/**
	 * It is the method to show the registered Teams.
	 * 
	 * @return msg String: This is the message that is printed on the screen showing
	 *         the met operation.
	 */
	public String showTeams() {
		String msg = "";
		for (int i = 0; i < teams.length; i++) {
			if (teams[i] != null) {
				msg += teams[i].toString();
			}
		}
		return msg;
	}

	/**
	 * A method that allows the addiction of a Pokemon to a Pokedex.
	 * 
	 * @param id        int: Unique Pokemon identifier.
	 * @param idPokedex int: Unique Pokedex identifier.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean addPokemonToPokedex(int id, int idPokedex) {
		for (int index = 0; index < pokemons.length; index++) {
			if (pokemons != null) {
				if (pokemons[index].getId() == id) {
					return pokedexes[id].addPokemonToPokedex(id, idPokedex);
				}
			}

		}
		return false;
	}

	/**
	 * Method that allows the addiction of a Pokemon to a Team.
	 * 
	 * @param id     int: Unique Pokemon identifier.
	 * @param idTeam int: Unique Team identifier.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean addPokemonToTeam(int id, int idTeam) {
		for (int index = 0; index < pokemons.length; index++) {
			if (pokemons != null) {
				if (pokemons[index].getId() == id) {
					return teams[id].addPokemonToTeam(id, idTeam);
				}
			}

		}
		return false;
	}

	/**
	 * Method that allows the addiction of a Movement to a Pokemon.
	 * 
	 * @param id     int: Unique Pokemon identifier.
	 * @param idMove int: Unique Move identifier.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean addMovesToPokemons(int id, int idMove) {
		for (int index = 0; index < moves.length; index++) {
			if (moves != null) {
				if (moves[index].getIdMove() == id) {
					return pokemons[id].addMoveToPokemon(id, idMove);
				}
			}

		}
		return false;
	}

	public char[] addPokemonToPokedex() {
		return null;
	}

	public char[] addPokemonstoTeams() {
		return null;
	}

	public char[] addMovesToPokemons() {
		return null;
	}

}