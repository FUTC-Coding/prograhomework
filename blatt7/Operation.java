package main;

public class Operation {
    TextDocument apply(TextDocument current) {
        return current.noop();
    }

    String getDescription() {
        return "does not modify the document";
    }
}
