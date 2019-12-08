package main;

public class TextDocument {
    String content;

    public TextDocument(String c) {
        content = c;
    }

    public String getContent() {
        return content;
    }

    TextDocument undo() {
        return this;
    }

    TextDocument noop() {
        return new ModifiedTextDocument(content, this);
    }

    TextDocument replaceTextSection(int beginIndex, int endIndex, String replacement) {
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > content.length()) {
            endIndex = content.length();
        }
        String firstHalf = content.substring(0,beginIndex);
        String secondHalf = content.substring(endIndex);
        return new ModifiedTextDocument(firstHalf + replacement + secondHalf, this);
    }

    TextDocument addTextAt(int position, String addition) {
        //handling for out of bounds position
        if (position > content.length()) {
            return new ModifiedTextDocument(content + addition, this);
        } else if (position < 0) {
            return new ModifiedTextDocument(addition + content, this);
        }

        String firstHalf = content.substring(0,position);
        String secondHalf = content.substring(position);
        return new ModifiedTextDocument(firstHalf + addition + secondHalf, this);
    }

    TextDocument removeTextSection(int beginIndex, int endIndex) {
        if (beginIndex <= 0) {
            beginIndex = 0;
        }
        if (endIndex > content.length()) {
            endIndex = content.length();
        }
        String output = content.substring(0,beginIndex) + content.substring(endIndex);
        return new ModifiedTextDocument(output, this);
    }
}
