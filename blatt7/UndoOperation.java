package main;

public class UndoOperation extends Operation {
    TextDocument apply(TextDocument current) {
        return current.undo();
    }

    String getDescription() {
        return "undoes the last operation";
    }
}
