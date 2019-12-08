package main;

public class AddTextAtOperation extends Operation{
    int pos;
    String add;

    public AddTextAtOperation(int position, String addition) {
        pos = position;
        add = addition;
    }

    TextDocument apply(TextDocument current) {
        return current.addTextAt(pos, add);
    }

    String getDescription() {
        return "adds " + add + " at " + pos;
    }
}
