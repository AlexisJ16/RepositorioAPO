package model;

public class Pokedex {

	private int idPokedex;
	private String region;
	private int pokemonNumber;
	private int gymNumber;
	private String capitalCity;
	private Pokemon[] pokemons;

	/**
	 * @param idPokedex     int: Unique Pokedex identifier.
	 * @param region        String: Is the region to which the Pokedex belongs.
	 * @param pokemonNumber int: This is the number of Pokemon in the Pokedex.
	 * @param gymNumber     int: It is the amount of gyms in the Pokedex.
	 * @param capitalCity   String: It is the capital city of the Pokedex.
	 */
	public Pokedex(int idPokedex, String region, int pokemonNumber, int gymNumber, String capitalCity) {

		this.idPokedex = idPokedex;
		this.region = region;
		this.pokemonNumber = pokemonNumber;
		this.gymNumber = gymNumber;
		this.capitalCity = capitalCity;
		this.pokemons = new Pokemon[pokemonNumber];
	}

	public int getIdPokedex() {
		return this.idPokedex;
	}

	public void setIdPokedex(int idPokedex) {
		this.idPokedex = idPokedex;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getPokemonNumber() {
		return pokemonNumber;
	}

	public void setPokemonNumber(int pokemonNumber) {
		this.pokemonNumber = pokemonNumber;
	}

	public int getGymNumber() {
		return gymNumber;
	}

	public void setGymNumber(int gymNumber) {
		this.gymNumber = gymNumber;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public Pokemon[] getPokemons() {
		return pokemons;
	}

	public void setPokemons(Pokemon[] pokemons) {
		this.pokemons = pokemons;
	}

	@Override
	public String toString() {
		return "\nPokedex info:"
				+ "\nId: " + this.idPokedex
				+ "\nRegion: " + this.region
				+ "\nPokemon number: " + this.pokemonNumber
				+ "\nGym number: " + this.gymNumber
				+ "\nCapital city: " + this.capitalCity;

	}

	/**
	 * Scroll through the Pokemon array to assign it to a space.
	 * 
	 * @param id        int: Unique Pokemon identifier.
	 * @param idPokedex int: Unique Pokedex identifier.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean addPokemonToPokedex(int id, int idPokedex) {
		Pokemon pk = null;
		for (int i = 0; i < pokemons.length; i++) {
			if (pokemons[i] == null) {
				pokemons[i] = pk;
				return true;
			}
		}
		return false;
	}

}
