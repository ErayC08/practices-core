package com.example.editor;

public class TextEditor {

    //Some operations are cut, copy, and paste.

    private final StringBuilder text;

    public TextEditor() {
        this.text = new StringBuilder();
    }

    //If you cut a text, that text is copied to the clipboard, and the text field becomes empty.
    public Clipboard cut() {
        Clipboard clipboard = new Clipboard(text.toString());

        text.delete(0, text.length());

        return clipboard;
    }

    public Clipboard copy() {
        return new Clipboard(this.text.toString());
    }

    public void paste(Clipboard clipboard) {
        this.text.delete(0, this.text.length()).append(clipboard.getText());
    }

    public void write(String text) {
        this.text.append(text);
    }

    public String getText() {
        return text.toString();
    }
}
