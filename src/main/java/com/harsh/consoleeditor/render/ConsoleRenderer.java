package com.harsh.consoleeditor.render;

import com.harsh.consoleeditor.cursor.Cursor;
import com.harsh.consoleeditor.document.Document;

public class ConsoleRenderer {

    public void render(Document document, Cursor cursor) {
        String text = document.getText();
        int cursorPos = cursor.getPosition();

        for (int i  = 0; i <= text.length(); i++) {
            if (i == cursorPos) {
                System.out.print('|');
            }
            if (i < text.length()) {
                System.out.print(text.charAt(i));
            }
        }
        System.out.println();
    }
}
