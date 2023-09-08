package com.example.window;

public class TextWindow {
    private StringBuilder currentText = new StringBuilder();

    public void write(String text) {
        currentText.append(text);
    }

    public TextWindowState save() {
        return new TextWindowState(currentText.toString());
    }

    public void undo(TextWindowState state) {
        currentText = new StringBuilder(state.getText());
    }
}
