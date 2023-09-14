package com.example.editor.operation;

import com.example.editor.Clipboard;
import com.example.editor.TextEditor;

public class TextEditorWriteOperation extends TextEditorOperation {

    public TextEditorWriteOperation(Clipboard clipboard, String text) {
        super(clipboard, text);
    }

    @Override
    public void execute(TextEditor textEditor) {
        textEditor.write(super.text);
    }
}
