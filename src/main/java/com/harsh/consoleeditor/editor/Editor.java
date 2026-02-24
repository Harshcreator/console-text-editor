package com.harsh.consoleeditor.editor;

import java.util.Scanner;

import com.harsh.consoleeditor.command.Command;
import com.harsh.consoleeditor.command.DeleteCommand;
import com.harsh.consoleeditor.command.HistoryTreeManager;
import com.harsh.consoleeditor.command.InsertCommand;
import com.harsh.consoleeditor.cursor.Cursor;
import com.harsh.consoleeditor.document.Document;
import com.harsh.consoleeditor.render.ConsoleRenderer;

public class Editor {
    public static void main(String[] args) {
        System.out.println("The editor is running...");
        Document document = new Document();
        Cursor cursor = new Cursor();
        ConsoleRenderer renderer = new ConsoleRenderer();
        HistoryTreeManager history = new HistoryTreeManager();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            renderer.render(document, cursor);
            System.out.println("\nType a character (q to quit, < for left, > for right, - for delete): ");
            String input = scanner.nextLine();

            if (input.equals("q")) break;

            else if (input.equals("<")) {
                cursor.moveLeft();
            }

            else if (input.equals(">")) {
                cursor.moveRight(document);
            }

            else if (input.equals("u")) {
                history.undo();
            }

            else if (input.equals("r")) {
                if (history.getBranchCount() > 0) {
                    history.redo(0);
                }
            }

            else if (input.equals("-")) {
                if (cursor.getPosition() > 0) {
                    Command cmd = new DeleteCommand(document, cursor);
                    history.executeCommand(cmd);
                }
            }

            else if (!input.isEmpty()) {
                Command cmd = new InsertCommand(document, cursor, input.charAt(0));
                history.executeCommand(cmd);
            }
        }
    }
}
