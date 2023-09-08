package com.example.window;

public class TextWindowState {
    private String text;

    public TextWindowState(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }
}
