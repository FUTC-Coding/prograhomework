package masterplan;

public interface Lehrveranstaltung {
	/**
	 * @return Die Anzahl der Credit Points, welche diese Lehrveranstaltung
	 *         einbringt.
	 */
	int getCreditPoints();

	/**
	 * @return Eine Beschreibung dieser Lehrveranstaltung.
	 */
	String getDescription();
}
