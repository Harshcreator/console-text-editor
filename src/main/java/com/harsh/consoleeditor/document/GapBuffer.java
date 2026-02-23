package com.harsh.consoleeditor.document;

public class GapBuffer {
    private char[] buffer;
    private int gapStart;
    private int gapEnd;

    public GapBuffer(int capacity) {
        buffer = new char[capacity];
        gapStart = 0;
        gapEnd = capacity;
    }

    //Insert at cursor
    public void insert(char c) {
        if (gapStart == gapEnd) {
            expand();
        }
        buffer[gapStart] = c;
        gapStart++;
    }

    public void delete() {
        if (gapStart == 0) return;
        gapStart--;
    }

    //Move cursor
    public void moveGap(int position) {
        if (position < 0 || position > getLength()) return;

        if (position < gapStart) {
            // Move gap backwards
            while (gapStart > position) {
                gapStart--;
                gapEnd--;
                buffer[gapEnd] = buffer[gapStart];
            }
        } else if (position > gapStart) {
            // Move gap forwards
            while (gapStart < position) {
                buffer[gapStart] = buffer[gapEnd];
                gapStart++;
                gapEnd++;
            }
        }
    }

    private void expand() {
        char[] newBuffer = new char[buffer.length * 2];
        int newGapEnd = newBuffer.length - (buffer.length - gapEnd);
        System.arraycopy(buffer, 0, newBuffer, 0, gapStart);
        System.arraycopy(buffer, gapEnd, newBuffer, newGapEnd, buffer.length - gapEnd);
        buffer = newBuffer;
        gapEnd = newGapEnd;
    }

    public String getText() {
        String left = new String(buffer, 0, gapStart);
        String right = new String(buffer, gapEnd, buffer.length - gapEnd);
        return left + right;
    }

    public int getLength() {
        return buffer.length - (gapEnd - gapStart);
    }

    public int getCursorPosition() {
        return gapStart;
    }
}
