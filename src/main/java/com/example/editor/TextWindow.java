package com.example.editor;

public class TextWindow {
    private StringBuilder currentText = new StringBuilder();

    public void appendText(String text) {
        currentText.append(text);
    }

    public TextWindowState save() {
        return new TextWindowState(currentText.toString());
    }

    public void undo(TextWindowState state) {
        currentText = new StringBuilder(state.getText());
    }
}
