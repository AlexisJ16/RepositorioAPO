package model;

public class Team {

	private int idTeam;
	private String name;
	private Date creationDate;
	private Pokemon[] pokemonList;

	/**
	 * @param idTeam       int: Unique Team identifier.
	 * @param name         String: It is the name of the Team.
	 * @param creationDate Date: It is the date of capture of the pokemon.
	 */
	public Team(int idTeam, String name, Date creationDate) {

		this.idTeam = idTeam;
		this.name = name;
		this.creationDate = creationDate;
		this.pokemonList = new Pokemon[7];
	}

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Pokemon[] getPokemonList() {
		return pokemonList;
	}

	public void setPokemonList(Pokemon[] pokemonList) {
		this.pokemonList = pokemonList;
	}

	@Override
	public String toString() {
		return "Equipos registrados actualmente"
				+ "\nId:" + this.idTeam
				+ "\nNombre:" + this.name
				+ "\nFecha de creacion: " + creationDate;
	}

	/**
	 * Scroll through the Pokemon array to assign it to a space.
	 * 
	 * @param id     int: Unique Pokemon identifier.
	 * @param idTeam int: Unique Team identifier.
	 * @return false boolean: Depending on the conditions satisfactorily fulfilled
	 *         in the method.
	 */
	public boolean addPokemonToTeam(int id, int idTeam) {
		Pokemon pk = null;
		for (int i = 0; i < pokemonList.length; i++) {
			if (pokemonList[i] == null) {
				pokemonList[i] = pk;
				return true;
			}
		}
		return false;
	}

}
