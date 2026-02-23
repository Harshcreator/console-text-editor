package com.harsh.consoleeditor.editor;

import java.util.Scanner;

import com.harsh.consoleeditor.cursor.Cursor;
import com.harsh.consoleeditor.document.Document;
import com.harsh.consoleeditor.render.ConsoleRenderer;

public class Editor {
    public static void main(String[] args) {
        System.out.println("The editor is running...");
        Document document = new Document();
        Cursor cursor = new Cursor();
        ConsoleRenderer renderer = new ConsoleRenderer();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            renderer.render(document, cursor);
            System.out.println("\nType a character (q to quit, < for left, > for right, - for delete): ");
            String input = scanner.nextLine();

            if (input.equals("q")) break;

            if (input.equals("<")) {
                cursor.moveLeft();
            }
            
            else if (input.equals(">")) {
                cursor.moveRight(document);
            }

            else if (input.equals("-")) {
                document.moveCursor(cursor.getPosition());
                document.delete();
                cursor.moveLeft();
            }

            else if (!input.isEmpty()) {
                document.moveCursor(cursor.getPosition());
                document.insert(input.charAt(0));
                cursor.moveRight(document);
            }
        }
    }
}
