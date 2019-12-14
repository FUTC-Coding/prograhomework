package masterplan;

/**
 * Diese Exception wird geworfen, falls der konfigurierte Masterplan ungueltig
 * ist.
 */
public class InvalidMasterplanException extends Exception {
	public InvalidMasterplanException(String message) {
		super(message);
	}
}
