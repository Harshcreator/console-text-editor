# Console Text Editor (Java)

## Project Goal 

Build a console-based text editor from scratch in Java to understand:

- Efficient text storage (Gap Buffer)
- Cursor behavior (including vertical column memory)
- Undo/Redo using Command Pattern
- Separation of document and rendering layers

---

# Development Phases

---

## Phase 1 — Core Text Storage (Gap Buffer) []

**Goal:** Build the foundation for efficient text editing.

### Tasks:
- Implement `GapBuffer`
  - insert(char)
  - delete()
  - moveGap(int position)
  - expand buffer when full
  - getText()

### Outcome:
- O(1) insert/delete at cursor
- Fully working in-memory text storage
- No UI or cursor logic yet

---

## Phase 2 — Cursor Implementation []

**Goal:** Implement realistic cursor behavior.

### Tasks:
- Create `Cursor` class
- Implement:
  - moveLeft()
  - moveRight()
  - moveUp(Document)
  - moveDown(Document)
- Add column memory logic for vertical movement

### Outcome:
- Cursor behaves like real editors
- Maintains preferred column when moving up/down

---

## Phase 3 — Console Rendering []

**Goal:** Display text and cursor in console.

### Tasks:
- Implement `ConsoleRenderer`
- Print document text
- Visually render cursor (e.g., `|`)
- Clear and redraw console after every action

### Outcome:
- Working interactive console display

---

## Phase 4 — Editor Input Loop []

**Goal:** Connect everything together.

### Tasks:
- Implement main editor loop
- Read user input
- Map input to:
  - Insert
  - Delete
  - Cursor movement
- Re-render after every action

### Outcome:
- Basic working text editor (no undo yet)

---

## Phase 5 — Undo / Redo (Command Pattern) []

**Goal:** Add efficient undo/redo functionality.

### Tasks:
- Create `Command` interface
- Implement:
  - InsertCommand
  - DeleteCommand
- Implement `CommandManager`
  - undoStack
  - redoStack

### Outcome:
- Efficient undo/redo
- No full document snapshots

---

## Phase 6 — Word Wrapping (Visual Layer) []

**Goal:** Add wrapping without modifying document.

### Tasks:
- Implement `WordWrapper`
- Wrap text during rendering only
- Keep document data unchanged

### Outcome:
- Clean separation between memory and display
- Proper architectural layering

---

# Final Result

At completion, the editor will support:

- Insert / Delete
- Cursor movement (← → ↑ ↓)
- Column memory behavior
- Undo / Redo
- Word wrapping
- Clean modular architecture

---

# Future Enhancements (Optional)

- Save/Load from file
- Text selection
- Search/Replace
- Replace GapBuffer with Rope or Piece Table
- Syntax highlighting