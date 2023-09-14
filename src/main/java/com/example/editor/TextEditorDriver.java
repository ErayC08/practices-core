package com.example.editor;

import com.example.editor.operation.TextEditorCopyOperation;
import com.example.editor.operation.TextEditorWriteOperation;

public class TextEditorDriver {

    public static void main(String[] args) {
        Clipboard clipboard = new Clipboard(null);

        TextEditorWriteOperation writeOperation = new TextEditorWriteOperation(clipboard, "ABC");
        TextEditor textEditor = new TextEditor();

        writeOperation.execute(textEditor);

        System.out.println(textEditor.getText());

        TextEditorCopyOperation copyOperation = new TextEditorCopyOperation(clipboard, "AB");

        copyOperation.execute(textEditor);

        System.out.println(clipboard.getText());
    }
}
