package com.harsh.consoleeditor.command;

import java.util.ArrayList;
import java.util.List;

public class HistoryNode {

    private Command command;
    private HistoryNode parent;
    private List<HistoryNode> children;

    public HistoryNode(Command command, HistoryNode parent) {
        this.command = command;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Command getCommand() {
        return command;
    }

    public HistoryNode getParent() {
        return parent;
    }

    public List<HistoryNode> getChildren() {
        return children;
    }

    public void addChild(HistoryNode child) {
        children.add(child);
    }
    
}
