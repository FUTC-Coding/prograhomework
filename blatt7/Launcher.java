package main;

public class Launcher {
    public static void main(String[] args){
        Operation[] o = {
                new AddTextAtOperation(0, "Hello Aachen!"),
                new ReplaceTextSectionOperation(6,12,"World"),
                new UndoOperation(),
                new ReplaceTextSectionOperation(0,5,"Goodbye"),
                new RemoveTextSectionOperation(14,15)};

        TextDocument t = new TextDocument("");
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i].getDescription());
            t = o[i].apply(t);
            System.out.println(t.getContent());
        }
    }
}
