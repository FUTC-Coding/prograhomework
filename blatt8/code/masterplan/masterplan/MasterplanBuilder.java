package masterplan;

/**
 * Dieses Interface beschreibt, auf welche Art und Weise ein Masterplan gebaut
 * werden kann.
 */
public interface MasterplanBuilder {
	/**
	 * Startet das Erstellen eines neuen Semesters.
	 */
	SemesterBuilder beginSemester() throws InvalidMasterplanException;

	/**
	 * Schliesst das Erstellen des Masterplans ab, indem der gegebene Plan
	 * validiert und anschliessend zurueckgegeben wird.
	 * 
	 * @return Der valide (gueltige) Masterplan.
	 * @throws InvalidMasterplanException Falls der Masterplan nicht valide ist.
	 */
	Masterplan validateAndCreate() throws InvalidMasterplanException;
}
