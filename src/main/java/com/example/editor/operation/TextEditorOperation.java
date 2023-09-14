package com.example.editor.operation;

import com.example.editor.Clipboard;
import com.example.editor.TextEditor;

public abstract class TextEditorOperation {
    protected Clipboard clipboard;
    protected String text;

    public TextEditorOperation(Clipboard clipboard, String text) {
        this.clipboard = clipboard;
        this.text = text;
    }

    public abstract void execute(TextEditor textEditor);
}
