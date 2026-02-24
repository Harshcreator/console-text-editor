package com.harsh.consoleeditor.command;

import com.harsh.consoleeditor.cursor.Cursor;
import com.harsh.consoleeditor.document.Document;

public class DeleteCommand implements Command {
    private Document document;
    private Cursor cursor;
    private char deletedChar;
    private int position;

    public DeleteCommand(Document document, Cursor cursor) {
        this.document = document;
        this.cursor = cursor;
        this.position = -1;
    }

    @Override
    public void execute() {
        if (position == -1) {
            position = cursor.getPosition();
        }
        // Get the character that will be deleted (the one before the cursor)
        String text = document.getText();
        deletedChar = text.charAt(position - 1);
        document.moveCursor(position);
        document.delete();
        cursor.setPosition(position - 1);
    }

    @Override
    public void undo() {
        document.moveCursor(position - 1);
        document.insert(deletedChar);
        cursor.setPosition(position);
    }
}
