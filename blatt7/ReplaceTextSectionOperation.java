package main;

public class ReplaceTextSectionOperation extends Operation {
    int begin;
    int end;
    String replace;

    public ReplaceTextSectionOperation(int beginIndex, int endIndex, String replacement) {
        begin = beginIndex;
        end = endIndex;
        replace = replacement;
    }

    TextDocument apply(TextDocument current) {
        return current.replaceTextSection(begin, end, replace);
    }

    String getDescription() {
        return "replaces text from " + begin + " to " + end + " with " + replace;
    }
}
