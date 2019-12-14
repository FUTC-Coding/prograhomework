package masterplan;

class LehrveranstaltungMitBereichszuordnung extends LehrveranstaltungBase {
    private Bereich bereich;
    public LehrveranstaltungMitBereichszuordnung(int creditPoints, String title, String type, Bereich bereich){
        super(creditPoints, title, type + " im Bereich " + bereich.getDescription());
        this.bereich = bereich;
    }

    public Bereich getBereich() {
        return bereich;
    }
}
