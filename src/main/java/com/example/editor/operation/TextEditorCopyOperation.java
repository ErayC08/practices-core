package com.example.editor.operation;

import com.example.editor.Clipboard;
import com.example.editor.TextEditor;

public class TextEditorCopyOperation extends TextEditorOperation {

    public TextEditorCopyOperation(Clipboard clipboard, String text) {
        super(clipboard, text);
    }

    @Override
    public void execute(TextEditor textEditor) {
        super.clipboard = textEditor.copy();
    }
}
