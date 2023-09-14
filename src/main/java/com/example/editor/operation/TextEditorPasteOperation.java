package com.example.editor.operation;

import com.example.editor.Clipboard;
import com.example.editor.TextEditor;

public class TextEditorPasteOperation extends TextEditorOperation {
    public TextEditorPasteOperation(Clipboard clipboard, String text) {
        super(clipboard, text);
    }

    @Override
    public void execute(TextEditor textEditor) {
        textEditor.paste(super.clipboard);
    }
}
