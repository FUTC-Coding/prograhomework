package masterplan.test;

import org.junit.Assert;
import org.junit.Test;

import masterplan.Bereich;
import masterplan.InvalidMasterplanException;
import masterplan.Masterplan;

public class MasterplanTest {
	@Test
	public void testValid() throws InvalidMasterplanException {
		// @formatter:off
		Masterplan masterplan = Masterplan.newBuilder()
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

		Assert.assertEquals(4, masterplan.getNumberOfSemesters());

		Assert.assertEquals(5, masterplan.getNumberOfLehrveranstaltungen(0));
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(0, 0).getCreditPoints());
		Assert.assertEquals(
				"Funktionale Programmierung (Wahlpflichtvorlesung im Bereich Theoretische Informatik)",
				masterplan.getLehrveranstaltung(0, 0).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(0, 1).getCreditPoints());
		Assert.assertEquals(
				"Compilerbau (Wahlpflichtvorlesung im Bereich Theoretische Informatik)",
				masterplan.getLehrveranstaltung(0, 1).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(0, 2).getCreditPoints());
		Assert.assertEquals(
				"Statische Programmanalyse (Wahlpflichtvorlesung im Bereich Theoretische Informatik)",
				masterplan.getLehrveranstaltung(0, 2).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(0, 3).getCreditPoints());
		Assert.assertEquals(
				"Infinite Computations and Games (Wahlpflichtvorlesung im Bereich Theoretische Informatik)",
				masterplan.getLehrveranstaltung(0, 3).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(0, 4).getCreditPoints());
		Assert.assertEquals(
				"Investition und Finanzierung (BWL) (Anwendungsfach)",
				masterplan.getLehrveranstaltung(0, 4).getDescription());

		Assert.assertEquals(5, masterplan.getNumberOfLehrveranstaltungen(1));
		Assert.assertEquals(4,
				masterplan.getLehrveranstaltung(1, 0).getCreditPoints());
		Assert.assertEquals(
				"Secure Crypto Protocol System (Seminar im Bereich Theoretische Informatik)",
				masterplan.getLehrveranstaltung(1, 0).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(1, 1).getCreditPoints());
		Assert.assertEquals(
				"Software-Projektmanagement (Wahlpflichtvorlesung im Bereich Software und Kommunikation)",
				masterplan.getLehrveranstaltung(1, 1).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(1, 2).getCreditPoints());
		Assert.assertEquals(
				"IT-Sicherheit (Wahlpflichtvorlesung im Bereich Daten- und Informationsmanagement)",
				masterplan.getLehrveranstaltung(1, 2).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(1, 3).getCreditPoints());
		Assert.assertEquals(
				"Objektorientierte Softwarekonstruktion (Wahlpflichtvorlesung im Bereich Software und Kommunikation)",
				masterplan.getLehrveranstaltung(1, 3).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(1, 4).getCreditPoints());
		Assert.assertEquals(
				"Methoden und Anwendungen der Optimierung (BWL) (Anwendungsfach)",
				masterplan.getLehrveranstaltung(1, 4).getDescription());

		Assert.assertEquals(5, masterplan.getNumberOfLehrveranstaltungen(2));
		Assert.assertEquals(7,
				masterplan.getLehrveranstaltung(2, 0).getCreditPoints());
		Assert.assertEquals("Secure Crypto Protocol System (Praktikum)",
				masterplan.getLehrveranstaltung(2, 0).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(2, 1).getCreditPoints());
		Assert.assertEquals(
				"Machine Learning (Wahlpflichtvorlesung im Bereich Angewandte Informatik)",
				masterplan.getLehrveranstaltung(2, 1).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(2, 2).getCreditPoints());
		Assert.assertEquals(
				"Communication Systems Engineering (Wahlpflichtvorlesung im Bereich Software und Kommunikation)",
				masterplan.getLehrveranstaltung(2, 2).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(2, 3).getCreditPoints());
		Assert.assertEquals(
				"Introduction to Data Science (Wahlpflichtvorlesung im Bereich Daten- und Informationsmanagement)",
				masterplan.getLehrveranstaltung(2, 3).getDescription());
		Assert.assertEquals(6,
				masterplan.getLehrveranstaltung(2, 4).getCreditPoints());
		Assert.assertEquals(
				"Advanced Operations Research (BWL) (Anwendungsfach)",
				masterplan.getLehrveranstaltung(2, 4).getDescription());

		Assert.assertEquals(2, masterplan.getNumberOfLehrveranstaltungen(3));
		Assert.assertEquals(3,
				masterplan.getLehrveranstaltung(3, 0).getCreditPoints());
		Assert.assertEquals("Programmverifikation (Schwerpunktkolloquium)",
				masterplan.getLehrveranstaltung(3, 0).getDescription());
		Assert.assertEquals(30,
				masterplan.getLehrveranstaltung(3, 1).getCreditPoints());
		Assert.assertEquals(
				"Modular Heap Shape Analysis for Java Programs (Masterarbeit)",
				masterplan.getLehrveranstaltung(3, 1).getDescription());
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidTooManySemesters()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
				.beginSemester()
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidTooManyLehrveranstaltungen()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
				.beginSemester()
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
					.praktikum("Secure Crypto Protocol System")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidTooFewTheoryCredits()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
				.beginSemester()
					.wahlpflichtvorlesung(6, "Funktionale Programmierung",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.wahlpflichtvorlesung(6, "Compilerbau",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.wahlpflichtvorlesung(6, "Statische Programmanalyse",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.wahlpflichtvorlesung(6, "Infinite Computations and Games",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.anwendungsfach(6, "Investition und Finanzierung (BWL)")
				.endSemester()
				.beginSemester()
					.seminar("Secure Crypto Protocol System",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "Software-Projektmanagement",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "IT-Sicherheit",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "Objektorientierte Softwarekonstruktion",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.anwendungsfach(6, "Methoden und Anwendungen der Optimierung (BWL)")
				.endSemester()
				.beginSemester()
					.praktikum("Secure Crypto Protocol System")
					.wahlpflichtvorlesung(6, "Machine Learning",
							Bereich.ANGEWANDTE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Communication Systems Engineering",
							Bereich.ANGEWANDTE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Introduction to Data Science",
							Bereich.ANGEWANDTE_INFORMATIK)
					.anwendungsfach(6, "Advanced Operations Research (BWL)")
				.endSemester()
				.beginSemester()
					.schwerpunktkolloquium("Programmverifikation")
					.masterarbeit("Modular Heap Shape Analysis for Java Programs")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidTooManyCreditsPerBereich()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
				.beginSemester()
					.wahlpflichtvorlesung(6, "Funktionale Programmierung",
							Bereich.DATEN_UND_INFORMATIONSMANAGEMENT)
					.wahlpflichtvorlesung(6, "Compilerbau",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
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
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "IT-Sicherheit",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Objektorientierte Softwarekonstruktion",
							Bereich.THEORETISCHE_INFORMATIK)
					.anwendungsfach(6, "Methoden und Anwendungen der Optimierung (BWL)")
				.endSemester()
				.beginSemester()
					.praktikum("Secure Crypto Protocol System")
					.wahlpflichtvorlesung(6, "Machine Learning",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Communication Systems Engineering",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Introduction to Data Science",
							Bereich.THEORETISCHE_INFORMATIK)
					.anwendungsfach(6, "Advanced Operations Research (BWL)")
				.endSemester()
				.beginSemester()
					.schwerpunktkolloquium("Programmverifikation")
					.masterarbeit("Modular Heap Shape Analysis for Java Programs")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidTooFewBereiche() throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
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
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "IT-Sicherheit",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "Objektorientierte Softwarekonstruktion",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.anwendungsfach(6, "Methoden und Anwendungen der Optimierung (BWL)")
				.endSemester()
				.beginSemester()
					.praktikum("Secure Crypto Protocol System")
					.wahlpflichtvorlesung(6, "Machine Learning",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "Communication Systems Engineering",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.wahlpflichtvorlesung(6, "Introduction to Data Science",
							Bereich.SOFTWARE_UND_KOMMUNIKATION)
					.anwendungsfach(6, "Advanced Operations Research (BWL)")
				.endSemester()
				.beginSemester()
					.schwerpunktkolloquium("Programmverifikation")
					.masterarbeit("Modular Heap Shape Analysis for Java Programs")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidNotExactly18CreditsAnwendungsfach()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
				.beginSemester()
					.wahlpflichtvorlesung(6, "Funktionale Programmierung",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Compilerbau",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Statische Programmanalyse",
							Bereich.THEORETISCHE_INFORMATIK)
					.wahlpflichtvorlesung(6, "Infinite Computations and Games",
							Bereich.THEORETISCHE_INFORMATIK)
					.anwendungsfach(5, "Investition und Finanzierung (BWL)")
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

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidNotExactlyOneSeminar()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
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

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidNotExactlyOnePraktikum()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
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

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidNotExactlyOneSchwerpunktkolloquium()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
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
					.schwerpunktkolloquium("Programmverifikation")
					.masterarbeit("Modular Heap Shape Analysis for Java Programs")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidNotExactlyOneMasterarbeit()
			throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
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
					.masterarbeit("Modular Heap Shape Analysis for Java Programs")
				.endSemester()
			.validateAndCreate();
		// @formatter:on
	}

	@Test(expected = InvalidMasterplanException.class)
	public void testInvalidTooFewCredits() throws InvalidMasterplanException {
		// @formatter:off
		Masterplan.newBuilder()
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
}
