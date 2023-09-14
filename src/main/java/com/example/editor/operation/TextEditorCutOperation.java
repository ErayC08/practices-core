package com.example.editor.operation;

import com.example.editor.Clipboard;
import com.example.editor.TextEditor;

public class TextEditorCutOperation extends TextEditorOperation {
    public TextEditorCutOperation(Clipboard clipboard, String text) {
        super(clipboard, text);
    }

    @Override
    public void execute(TextEditor textEditor) {
        super.clipboard = textEditor.cut();
    }
}
