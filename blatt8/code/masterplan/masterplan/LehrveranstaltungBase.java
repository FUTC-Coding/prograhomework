package masterplan;

abstract class LehrveranstaltungBase implements Lehrveranstaltung {
    private int creditPoints;
    private String description;

    public LehrveranstaltungBase(int creditPoints, String title, String type) {
        this.creditPoints = creditPoints;
        this.description = title + " (" + type + ")";
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public String getDescription() {
        return description;
    }
}
