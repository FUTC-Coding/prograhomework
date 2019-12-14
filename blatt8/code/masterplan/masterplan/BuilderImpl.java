package masterplan;

import masterplan.impl.MasterplanImpl;

class BuilderImpl implements MasterplanBuilder, SemesterBuilder {
    private Lehrveranstaltung[][] semesters = new Lehrveranstaltung[10][10];
    private int currentSemester = 0;
    private int currentLehrveranstaltung = 0;

    @Override
    public SemesterBuilder beginSemester() throws InvalidMasterplanException {
        if (currentSemester > 9 || currentSemester < 0) {
            throw new InvalidMasterplanException("current Semester is not in the defined range of max 10 semesters");
        } else {
            return this;
        }
    }

    @Override
    public MasterplanBuilder endSemester() throws InvalidMasterplanException {
        currentSemester++;
        currentLehrveranstaltung = 0;
        return this;
    }

    @Override
    public SemesterBuilder anwendungsfach(int creditPoints, String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung < 9) {
            semesters[currentSemester][currentLehrveranstaltung] = new Anwendungsfach(creditPoints,title);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw new InvalidMasterplanException("already registered the maximum 10 subjects");
        }
    }

    @Override
    public SemesterBuilder masterarbeit(String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung < 9) {
            semesters[currentSemester][currentLehrveranstaltung] = new Masterarbeit(title);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw new InvalidMasterplanException("already registered the maximum 10 subjects");
        }
    }

    @Override
    public SemesterBuilder praktikum(String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung < 9) {
            semesters[currentSemester][currentLehrveranstaltung] = new Praktikum(title);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw new InvalidMasterplanException("already registered the maximum 10 subjects");
        }
    }

    @Override
    public SemesterBuilder schwerpunktkolloquium(String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung < 9) {
            semesters[currentSemester][currentLehrveranstaltung] = new Schwerpunktkolloquium(title);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw new InvalidMasterplanException("already registered the maximum 10 subjects");
        }
    }

    @Override
    public SemesterBuilder seminar(String title, Bereich bereich) throws InvalidMasterplanException {
        if (currentLehrveranstaltung < 9) {
            semesters[currentSemester][currentLehrveranstaltung] = new Seminar(title, bereich);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw new InvalidMasterplanException("already registered the maximum 10 subjects");
        }
    }

    @Override
    public SemesterBuilder wahlpflichtvorlesung(int creditPoints, String title, Bereich bereich) throws InvalidMasterplanException {
        if (currentLehrveranstaltung < 9) {
            semesters[currentSemester][currentLehrveranstaltung] = new Wahlpfilchtvorlesung(creditPoints,title,bereich);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw new InvalidMasterplanException("already registered the maximum 10 subjects");
        }
    }

    @Override
    public Masterplan validateAndCreate() throws InvalidMasterplanException {
        //validate Masterplan
        int creditsTheo = 0;
        int creditsSoft = 0;
        int creditsDaten = 0;
        int creditsAngew = 0;
        int creditsAnwendungsfach = 0;
        boolean seminarBelegt = false;
        boolean praktikumBelegt = false;
        boolean kolloquiumBelegt = false;
        boolean masterarbeitBelegt = false;
        int totalCredits = 0;
        int i = 0;
        while (semesters[i][0] != null) {
            int j = 0;
            while (semesters[i][j] != null) {
                totalCredits += ((LehrveranstaltungBase)semesters[i][j]).getCreditPoints();
                if (semesters[i][j] instanceof Seminar){
                    if (!seminarBelegt) {
                        seminarBelegt = true;
                        Bereich bereich = ((Seminar)semesters[i][j]).getBereich();
                        switch (bereich) {
                            case THEORETISCHE_INFORMATIK:
                                creditsTheo += semesters[i][j].getCreditPoints();
                                break;
                            case SOFTWARE_UND_KOMMUNIKATION:
                                creditsSoft += semesters[i][j].getCreditPoints();
                                break;
                            case DATEN_UND_INFORMATIONSMANAGEMENT:
                                creditsDaten += semesters[i][j].getCreditPoints();
                                break;
                            case ANGEWANDTE_INFORMATIK:
                                creditsAngew += semesters[i][j].getCreditPoints();
                                break;
                        }
                    } else {
                        throw new InvalidMasterplanException("mehr als ein Seminar belegt");
                    }
                } else if (semesters[i][j] instanceof Praktikum) {
                    if (!praktikumBelegt) {
                        praktikumBelegt = true;
                    } else {
                        throw new InvalidMasterplanException("mehr als ein Praktikum belegt");
                    }
                } else if (semesters[i][j] instanceof Schwerpunktkolloquium) {
                    if (!kolloquiumBelegt) {
                        kolloquiumBelegt = true;
                    } else {
                        throw new InvalidMasterplanException("mehr als ein Schwerpunktkolloquium belegt");
                    }
                } else if (semesters[i][j] instanceof Masterarbeit) {
                    if (!masterarbeitBelegt) {
                        masterarbeitBelegt = true;
                    } else {
                        throw new InvalidMasterplanException("mehr als eine Masterarbeit belegt");
                    }
                } else if (semesters[i][j] instanceof Wahlpfilchtvorlesung) {
                    Bereich bereich = ((Wahlpfilchtvorlesung)semesters[i][j]).getBereich();
                    switch (bereich) {
                        case THEORETISCHE_INFORMATIK:
                            creditsTheo += semesters[i][j].getCreditPoints();
                            break;
                        case SOFTWARE_UND_KOMMUNIKATION:
                            creditsSoft += semesters[i][j].getCreditPoints();
                            break;
                        case DATEN_UND_INFORMATIONSMANAGEMENT:
                            creditsDaten += semesters[i][j].getCreditPoints();
                            break;
                        case ANGEWANDTE_INFORMATIK:
                            creditsAngew += semesters[i][j].getCreditPoints();
                            break;
                    }
                } else if (semesters[i][j] instanceof Anwendungsfach) {
                    creditsAnwendungsfach += semesters[i][j].getCreditPoints();
                }
                j++;
            }
            i++;
        }

        if (creditsTheo < 12) throw new InvalidMasterplanException("nicht mindestens 12 credit points aus dem Bereich Theoretische Informatik belegt");
        if (creditsAngew > 35 || creditsDaten > 35 || creditsSoft > 35 || creditsTheo > 35) throw new InvalidMasterplanException("in einem Bereich zu viele credit points belegt");
        int anzahlBereicheBelegt = 0;
        if (creditsTheo != 0) anzahlBereicheBelegt++;
        if (creditsSoft != 0) anzahlBereicheBelegt++;
        if (creditsDaten != 0) anzahlBereicheBelegt++;
        if (creditsAngew != 0) anzahlBereicheBelegt++;
        if (anzahlBereicheBelegt < 3) throw new InvalidMasterplanException("es wurden nicht drei verschiedene Bereiche belegt");
        if (creditsAnwendungsfach != 18) throw new InvalidMasterplanException("Für das Anwendungsfach wurden nicht genau 18 credit points belegt");
        if (totalCredits < 120) throw new InvalidMasterplanException("nicht 120 credit points insgesamt");

        //count not-null entries of semesters
        int semesterCount = 0;
        while(semesters[semesterCount][0] != null) {
            semesterCount++;
        }

        Lehrveranstaltung[][] l = new Lehrveranstaltung[semesterCount][];
        for (int x = 0; x < semesterCount; x++) {
            //count veranstaltungen for the x. semester
            int verCount = 0;
            while (semesters[x][verCount] != null) {
                verCount++;
            }
            Lehrveranstaltung[] lv = new Lehrveranstaltung[verCount];
            //fill 1-dimensional array with all events from the semester
            for (int j = 0; j < verCount; j++) {
                lv[j] = semesters[x][j];
            }
            //add the 1-dimensional array as the x-semesters plan
            l[x] = lv;
        }
        //create masterplan
        Masterplan masterplan = new MasterplanImpl(l);
        return masterplan;
    }
}
