package main;

public class ModifiedTextDocument extends TextDocument{
    TextDocument previousVersion;

    public ModifiedTextDocument(String c, TextDocument previous) {
        super(c);
        previousVersion = previous;
    }

    TextDocument undo() {
        return previousVersion;
    }
}
