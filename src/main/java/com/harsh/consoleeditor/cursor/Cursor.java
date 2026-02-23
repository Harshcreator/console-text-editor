package com.harsh.consoleeditor.cursor;

import com.harsh.consoleeditor.document.Document;

public class Cursor {
    private int position;
    private int preferredColumn;

    public Cursor() {
        position = 0;
        preferredColumn = 0;
    }
    
    public void moveLeft() {
        if (position > 0) {
            position--;
        }
    }

    public void moveRight(Document document) {
        if (position < document.length()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

}
