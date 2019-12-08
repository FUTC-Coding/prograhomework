package main;

public class RemoveTextSectionOperation extends Operation{
    int begin;
    int end;

    public RemoveTextSectionOperation(int beginIndex, int endIndex) {
        begin = beginIndex;
        end = endIndex;
    }

    TextDocument apply(TextDocument current) {
        return current.removeTextSection(begin, end);
    }

    String getDescription() {
        return "removes text from " + begin + " to " + end;
    }
}
