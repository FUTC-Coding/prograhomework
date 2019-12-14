package masterplan;

/**
 * Dieses Interface beschreibt, auf welche Art und Weise ein Semester gebaut
 * werden kann.
 */
public interface SemesterBuilder {
	/**
	 * Fuegt dem aktuellen Semester ein Anwendungsfach hinzu.
	 */
	SemesterBuilder anwendungsfach(int creditPoints, String title)
			throws InvalidMasterplanException;

	/**
	 * Fuegt dem aktuellen Semester eine Masterarbeit hinzu.
	 */
	SemesterBuilder masterarbeit(String title)
			throws InvalidMasterplanException;

	/**
	 * Fuegt dem aktuellen Semester ein Praktikum hinzu.
	 */
	SemesterBuilder praktikum(String title)
			throws InvalidMasterplanException;

	/**
	 * Fuegt dem aktuellen Semester ein Schwerpunktkolloquium hinzu.
	 */
	SemesterBuilder schwerpunktkolloquium(String title)
			throws InvalidMasterplanException;

	/**
	 * Fuegt dem aktuellen Semester ein Seminar hinzu.
	 */
	SemesterBuilder seminar(String title, Bereich bereich)
			throws InvalidMasterplanException;

	/**
	 * Fuegt dem aktuellen Semester eine Wahlpflichtvorlesung hinzu.
	 */
	SemesterBuilder wahlpflichtvorlesung(int creditPoints, String title,
			Bereich bereich) throws InvalidMasterplanException;

	/**
	 * Schliesst dieses Semester ab.
	 */
	MasterplanBuilder endSemester() throws InvalidMasterplanException;
}
