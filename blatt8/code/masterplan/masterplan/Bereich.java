package masterplan;

/**
 * In der Informatik werden einige, aber nicht alle, Lehrveranstaltungen den
 * hier aufgefuehrten Bereichen zugeordnet.
 */
public enum Bereich {
	THEORETISCHE_INFORMATIK("Theoretische Informatik"),
	SOFTWARE_UND_KOMMUNIKATION("Software und Kommunikation"),
	DATEN_UND_INFORMATIONSMANAGEMENT("Daten- und Informationsmanagement"),
	ANGEWANDTE_INFORMATIK("Angewandte Informatik");

	private final String description;

	private Bereich(String description) {
		this.description = description;
	}

	/**
	 * @return Eine String-Repraesentation dieses Bereichs.
	 */
	public String getDescription() {
		return description;
	}
}
