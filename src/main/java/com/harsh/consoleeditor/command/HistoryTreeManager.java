package com.harsh.consoleeditor.command;

public class HistoryTreeManager {

    private HistoryNode root;
    private HistoryNode current;

    public HistoryTreeManager() {
        root = new HistoryNode(null, null); // initial empty state
        current = root;
    }

    public void executeCommand(Command command) {
        command.execute();
        HistoryNode newNode = new HistoryNode(command, current);
        current.addChild(newNode);
        current = newNode;
    }

    public void undo() {
        if (current.getParent() == null) {
            return;
        }
        current.getCommand().undo();
        current = current.getParent();
    }

    public void redo(int branchIndex) {
        if (current.getChildren().isEmpty()) {
            return;
        }
        if (branchIndex < 0 || branchIndex >= current.getChildren().size()) {
            return;
        }
        HistoryNode nextNode = current.getChildren().get(branchIndex);
        nextNode.getCommand().execute();
        current = nextNode;
    }

    public int getBranchCount() {
        return current.getChildren().size();
    }
}
