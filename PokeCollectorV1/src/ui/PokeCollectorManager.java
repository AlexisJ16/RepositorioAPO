/*
 * The program specializes in the collection of pokemon from a player, so it allows 
 * you to register, view and add pokedexes, pokemon, equipment and movements to your 
 * preference, through an interactive menu with the user.
 * 
 * @Author: Alexis Jaramillo Martinez (A00395655)
 */

package ui;

import model.PokeCollectorController;
import java.util.Scanner;

public class PokeCollectorManager {

	/**
	 * Declaration of the scanner acting as program reader (sc)
	 */
	public static Scanner sc = new Scanner(System.in);

	/**
	 * Calling of the controller class to the interface.
	 */
	public static PokeCollectorController pokeController = new PokeCollectorController();

	public static void main(String[] args) {
		menu();
	}

	/**
	 * Executable menu that interacts with the user.
	 */
	public static void menu() {

		boolean exit = false;
		while (!exit) {

			System.out.println("\nBienvenido al PokeCollector, Ash");
			System.out.println("Porfavor, selecciona la opcion que deseas realizar dentro del PokeCollector");

			System.out.println("\n**Menu de opciones**");
			System.out.println("Escoge la opcion que deseas realizar:");

			System.out.println("\nPara hacer el registro de cualquier objeto, ingresa: (a)");
			System.out.println("Para visualizar los objetos registrados, ingresa: (b)");
			System.out.println("Para ver las estadisticas de los equipos registrados, ingresa: (c)");
			System.out.println("Para realizar las asociaciones disponibles, ingresa: (d)");
			System.out.println("");
			String selection = sc.nextLine();
			System.out.println("");

			// Section for registration of objects in the program by the user.
			if ("a".equals(selection)) {
				System.out.println("\n- Para registrar una pokedex, ingresa (a)");
				System.out.println("\n- Registrar un pokemon, ingresa (b)");
				System.out.println("\n- Registrar un movimiento, ingresa (c)");
				System.out.println("\n- Registrar un equipos, ingresa (d)");
				System.out.println("");
				String register = sc.nextLine();

				switch (register) {
					// Pokedex registration.
					case "a":
						registerPokedex();
						break;

					// Pokemon registration.
					case "b":
						registerPokemon();
						break;

					// Move registration.
					case "c":
						registerMove();
						break;

					// Team registration.
					case "d":
						registerTeam();
						break;

					default:
						exit = true;
						break;

				}
			}

			// Section of visualization of objects in the program by the user.
			if ("b".equals(selection)) {
				System.out.println("\n- Para mostrar las pokedexes registradas, ingresa (a)");
				System.out.println("\n- Para mostrar los pokemones registrados, ingresa (b)");
				System.out.println("\n- Para mostrar los movimientos registrados, ingresa (c)");
				System.out.println("\n- Para mostrar los equipos registrados, ingresa (d)");
				System.out.println("");
				String view = sc.nextLine();

				switch (view) {
					// Pokedexes visualization.
					case "a":
						System.out.println(pokeController.showPokedexes());
						break;

					// Pokemons visualization.
					case "b":
						System.out.println(pokeController.showPokemons());
						break;

					// Moves visualization.
					case "c":
						System.out.println(pokeController.showMoves());
						break;

					// Teams visualization.
					case "d":
						System.out.println(pokeController.showTeams());
						break;

					default:
						exit = true;
						break;
				}
			}

			//
			if ("c".equals(selection)) {
				System.out.println("Hola");
			}

			// Section for adding objects to the program by the user.
			if ("d".equals(selection)) {
				System.out.println("\n- Para asociar un Pokemon a una Pokedex, ingresa (a)");
				System.out.println("\n- Para asociar un Pokemon a un Equipo, ingresa (b)");
				System.out.println("\n- Para asociar un movimiento a un Pokemon, ingresa (c)");
				String join = sc.nextLine();

				switch (join) {
					// Pokemon addiction to Pokedex.
					case "a":
						System.out.println(pokeController.addPokemonToPokedex());
						break;

					// Pokemon addiction to Team.
					case "b":
						System.out.println(pokeController.addPokemonstoTeams());
						break;

					// Move addiction to Pokemon.
					case "c":
						System.out.println(pokeController.addMovesToPokemons());
						break;

					default:
						exit = true;
						break;
				}
			}

		}
	}

	/**
	 * Menu for registering a Pokedex.
	 */
	private static void registerPokedex() {

		System.out.println("\nA continuacion, vas a registrar una pokedex!");

		System.out.println("\nIngresa el ID de la pokedex:");
		int idPokedex = sc.nextInt();

		System.out.println("\nDigite el nombre que corresponde a la region");
		String region = sc.nextLine();

		System.out.println("\nIngresa el numero de pokemones que pertecen a la pokedex:");
		int pokemonNumber = sc.nextInt();

		System.out.println("\nIngresa el numero de gimnasios que posee:");
		int gymNumber = sc.nextInt();

		System.out.println("\nIngresa la ciudad capital a la que pertenece:");
		String capitalCity = sc.nextLine();

		if (pokeController.registerPokedex(idPokedex, region, pokemonNumber, gymNumber, capitalCity)) {
			System.out.println("Pokedex registrada exitosamente");
		} else {
			System.out.println("Error no se pudo registrar la pokedex");
		}

	}

	/**
	 * Menu for registering a Pokemon.
	 */
	private static void registerPokemon() {

		System.out.println("\nA continuacion, vas a registrar un pokemon!");

		System.out.println("\nDigita el nombre del pokemon");
		String name = sc.nextLine();

		System.out.println("\nIngresa el ID que tendra el pokemon:");
		int id = sc.nextInt();

		System.out.println("\nIngresa el primer tipo del pokemon:");
		System.out.println("Tipos posibles: Water, Fire, Grass, Dark, Normal");
		String type1 = sc.nextLine();
		sc.nextLine();

		System.out.println("\nIngresa el segundo tipo del pokemon:");
		System.out.println("Tipos posibles: Water, Fire, Grass, Dark, Normal");
		String types2 = sc.nextLine();

		System.out.println("\nIngresa la salud que posee el pokemon:");
		int health = sc.nextInt();

		System.out.println("\nIngresa el ataque que posee el pokemon:");
		int attack = sc.nextInt();

		System.out.println("\nIngresa la defensa que posee el pokemon:");
		int defense = sc.nextInt();

		System.out.println("\nIngresa la velocidad que posee el pokemon:");
		int speed = sc.nextInt();

		System.out.println("\nIngresa la fecha de obtencion del pokemon:");
		System.out.println("\nDigita el dia");
		int day = sc.nextInt();

		System.out.println("\nDigita el mes");
		int month = sc.nextInt();

		System.out.println("\nDigita el año");
		int year = sc.nextInt();

		if (pokeController.registerPokemon(name, id, type1, types2, health, attack, defense, speed, day, month, year)) {
			System.out.println("Pokemon registrado exitosamente");
		} else {
			System.out.println("Error no se pudo registrar el pokemon");
		}

	}

	/**
	 * Menu for registering a Move.
	 */
	private static void registerMove() {

		System.out.println("\nA continuacion, vas a registrar el movimiento de un pokemon!");

		System.out.println("\nDigite el ID del movimiento");
		int idMove = sc.nextInt();

		System.out.println("\nDigite el nombre del movimiento");
		String name = sc.nextLine();

		System.out.println("\nIngresa el tipo de movimiento del pokemon:");
		System.out.println("Tipos posibles: Water, Fire, Grass, Dark, Normal");
		String type = sc.nextLine();

		System.out.println("\nIngresa el valor base del movimiento:");
		int basevalue = sc.nextInt();

		System.out.println("\nIngresa el valor maximo del movimiento:");
		int maximumvalue = sc.nextInt();

		System.out.println("\nIngresa el porcentaje de precision del movimiento:");
		int accuracypercentage = sc.nextInt();

		if (pokeController.registerMove(idMove, name, type, basevalue, maximumvalue, accuracypercentage)) {
			System.out.println("\nMovimiento registrado exitosamente");
		} else {
			System.out.println("\nError no se pudo registrar el movimiento");
		}

	}

	/**
	 * Menu for registering a Team.
	 */
	private static void registerTeam() {

		System.out.println("\nA continuacion, vas a registrar un equipo!");

		System.out.println("\nDigite el ID del equipo");
		int idTeam = sc.nextInt();

		System.out.println("\nDigite el nombre del equipo");
		String name = sc.nextLine();

		System.out.println("\nIngresa la fecha de creacion del equipo:");
		System.out.println("\nDigita el dia");
		int day = sc.nextInt();

		System.out.println("\nDigita el mes");
		int month = sc.nextInt();

		System.out.println("\nDigita el año");
		int year = sc.nextInt();

		if (pokeController.registerTeam(idTeam, name, day, month, year)) {
			System.out.println("Equipo registrado exitosamente");
		} else {
			System.out.println("Error no se pudo registrar el equipo");
		}

	}

}
