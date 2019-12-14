package masterplan;

public class Wahlpfilchtvorlesung extends LehrveranstaltungMitBereichszuordnung {
    Wahlpfilchtvorlesung(int creditPoints, String title, Bereich bereich) {
        super(creditPoints, title, "Wahlpflichtvorlesung", bereich);
    }
}
