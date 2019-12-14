package masterplan.impl;

import masterplan.Lehrveranstaltung;
import masterplan.Masterplan;

public class MasterplanImpl implements Masterplan {
    Lehrveranstaltung[][] masterplan;
    public MasterplanImpl(Lehrveranstaltung[][] masterplan) {
        this.masterplan = masterplan;
    }

    @Override
    public int getNumberOfSemesters() {
        return masterplan.length;
    }

    @Override
    public int getNumberOfLehrveranstaltungen(int semester) {
        if (semester > masterplan.length || semester < 0) {
            throw new IllegalArgumentException();
        } else {
            return masterplan[semester].length;
        }
    }

    public Lehrveranstaltung getLehrveranstaltung (int semester, int lehrveranstaltung) {
        if (semester > masterplan.length || semester < 0 || lehrveranstaltung > masterplan[semester].length || lehrveranstaltung < 0) {
            throw new IllegalArgumentException();
        } else {
            return masterplan[semester][lehrveranstaltung];
        }
    }
}
