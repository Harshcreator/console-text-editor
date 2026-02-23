package com.harsh.consoleeditor.document;

public class Document {
    private GapBuffer gapBuffer;

    public Document() {
        gapBuffer = new GapBuffer(20);
    }

    public void insert(char c) {
        gapBuffer.insert(c);
    }

    public void delete() {
        gapBuffer.delete();
    }

    public void moveCursor(int position) {
        gapBuffer.moveGap(position);
    }

    public String getText() {
        return gapBuffer.getText();
    }

    public int getCursorPosition() {
        return gapBuffer.getCursorPosition();
    }

    public int length() {
        return gapBuffer.getLength();
    }
}
