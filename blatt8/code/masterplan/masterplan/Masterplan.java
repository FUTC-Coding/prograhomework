package masterplan;

/**
 * Dieses Interface bietet die Moeglichkeit, einen validierten Masterplan zu
 * erstellen.
 */
public interface Masterplan {
	/**
	 * Startet das Erstellen eines neuen Masterplans.
	 */
	public static MasterplanBuilder newBuilder() {
		return new BuilderImpl();
	}

	/**
	 * @return Die Anzahl der Semester im Masterplan.
	 */
	int getNumberOfSemesters();

	/**
	 * @param semester Das Semester, siehe {@link #getNumberOfSemesters()}.
	 * @return Die Anzahl der Lehrveranstaltungen im gegebenen Semester.
	 * @throws IllegalArgumentException Falls der uebergebene Index negativ ist
	 *                                  oder der Semester-Index
	 *                                  ({@link #getNumberOfSemesters()})
	 *                                  erreicht oder uebersteigt.
	 */
	int getNumberOfLehrveranstaltungen(int semester);

	/**
	 * @param semester          Das Semester, siehe
	 *                          {@link #getNumberOfSemesters()}.
	 * @param lehrveranstaltung Der Index der Lehrveranstaltung im Semester,
	 *                          siehe
	 *                          {@link #getNumberOfLehrveranstaltungen(int)}.
	 * @return Die entsprechende Lehrveranstaltung im gegebenen Semester.
	 * @throws IllegalArgumentException Falls die uebergebenen Indizes negativ
	 *                                  sind oder der Semester-Index
	 *                                  ({@link #getNumberOfSemesters()}) bzw.
	 *                                  der Lehrveranstaltungs-Index in diesem
	 *                                  Semester
	 *                                  ({@link #getNumberOfLehrveranstaltungen(int)})
	 *                                  erreicht oder uebersteigt.
	 */
	Lehrveranstaltung getLehrveranstaltung(int semester, int lehrveranstaltung);
}
