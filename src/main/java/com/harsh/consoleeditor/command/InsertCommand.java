package com.harsh.consoleeditor.command;

import com.harsh.consoleeditor.cursor.Cursor;
import com.harsh.consoleeditor.document.Document;

public class InsertCommand implements Command {
        private Document document;
        private Cursor cursor;
        private char character;
        private int position;
        
        public InsertCommand(Document document, Cursor cursor, char character) {
            this.document = document;
            this.cursor = cursor;
            this.character = character;
        }

        @Override
        public void execute() {
            position = cursor.getPosition();
            document.moveCursor(position);
            document.insert(character);
            cursor.setPosition(position + 1);;
        }

        @Override
        public void undo() {
            document.moveCursor(position + 1);
            document.delete();
            cursor.setPosition(position);
        }
}        
