package launcher;

import masterplan.Bereich;
import masterplan.InvalidMasterplanException;
import masterplan.Lehrveranstaltung;
import masterplan.Masterplan;

public class Launcher {
	public static void main(String[] args) {
		try {
			printMasterplan(createMasterplan());
		} catch (InvalidMasterplanException e) {
			System.out.println("Der Masterplan ist nicht valide:");
			System.out.println(e.getMessage());
		}
	}

	private static Masterplan createMasterplan()
			throws InvalidMasterplanException {
		// @formatter:off
		return Masterplan.newBuilder()
				.beginSemester()
					.wahlpflichtvorlesung(6, "Funktionale Programmierung",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Compilerbau",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Statische Programmanalyse",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Infinite Computations and Games",
							Bereich.THEORETISCHE_INFORMATIK)
					.anwendungsfach(6, "Investition und Finanzierung (BWL)")
				.endSemester()
				.beginSemester()
					.seminar("Secure Crypto Protocol System",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Software-Projektmanagement",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "IT-Sicherheit",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.wahlpflichtvorlesung(6, "Objektorientierte Softwarekonstruktion",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.anwendungsfach(6, "Methoden und Anwendungen der Optimierung (BWL)")
				.endSemester()
				.beginSemester()
					.praktikum("Secure Crypto Protocol System")
					.wahlpflichtvorlesung(6, "Machine Learning",
							Bereich.ANGEWANDTE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Communication Systems Engineering",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "Introduction to Data Science",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.anwendungsfach(6, "Advanced Operations Research (BWL)")
				.endSemester()
				.beginSemester()
					.schwerpunktkolloquium("Programmverifikation")
					.masterarbeit("Modular Heap Shape Analysis for Java Programs")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	private static void printMasterplan(Masterplan masterplan) {
		for (int semesterId = 0; semesterId < masterplan
				.getNumberOfSemesters(); semesterId++) {
			System.out.println("Semester " + (semesterId + 1));
			for (int lehrId = 0; lehrId < masterplan
					.getNumberOfLehrveranstaltungen(semesterId); lehrId++) {
				Lehrveranstaltung lehrveranstaltung = masterplan
						.getLehrveranstaltung(semesterId, lehrId);
				System.out.println(lehrveranstaltung.getCreditPoints() + " CP "
						+ lehrveranstaltung.getDescription());
			}
			System.out.println();
		}
	}
}
