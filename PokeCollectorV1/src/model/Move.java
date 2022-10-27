package model;

public class Move {

	private int idMove;
	private String name;
	private String type;
	private int basevalue;
	private int maximumvalue;
	private int accuracypercentage;

	/**
	 * @param idMove             int: Unique Move identifier.
	 * @param name               String: It is the name of the movement.
	 * @param type               String: It is the type of the movement.
	 * @param basevalue          int: It is the base value of the movement.
	 * @param maximumvalue       int: It is the maximum value of the movement.
	 * @param accuracypercentage int: It is the percentage of precision of the
	 *                           movement.
	 */
	public Move(int idMove, String name, String type, int basevalue, int maximumvalue, int accuracypercentage) {

		this.idMove = idMove;
		this.name = name;
		this.type = type;
		this.basevalue = basevalue;
		this.maximumvalue = maximumvalue;
		this.accuracypercentage = accuracypercentage;

	}

	public int getIdMove() {
		return this.idMove;
	}

	public void setId(int idMove) {
		this.idMove = idMove;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBaseValue() {
		return this.basevalue;
	}

	public void setBaseValue(int basevalue) {
		this.basevalue = basevalue;
	}

	public int getMaximunValue() {
		return this.maximumvalue;
	}

	public void setMaximunValue(int maximumvalue) {
		this.maximumvalue = maximumvalue;
	}

	public int getAccuracyPercentage() {
		return this.accuracypercentage;
	}

	public void setAccuracyPercentage(int accuracypercentage) {
		this.accuracypercentage = accuracypercentage;
	}

	@Override
	public String toString() {
		return "\nMovements information:"
				+ "\nId: " + this.idMove
				+ "\nName: " + this.name
				+ "\nType: " + this.type
				+ "\nBase value: " + this.basevalue
				+ "\nMaximun value: " + this.maximumvalue
				+ "\nAccuracy percentage: " + this.accuracypercentage;
	}

}
