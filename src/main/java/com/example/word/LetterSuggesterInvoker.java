package com.example.word;

public class LetterSuggesterInvoker {
    private LetterSuggester suggester;
    private WordSupplier supplier;
    private GuessingGameMonitor monitor;

    public LetterSuggesterInvoker(LetterSuggester suggester, WordSupplier supplier, GuessingGameMonitor monitor) {
        this.suggester = suggester;
        this.supplier = supplier;
        this.monitor = monitor;
    }

    public void invoke(char c) {
        if (Character.isLetter(c)) {
            char upperCaseLetter = Character.toUpperCase(c);

            if (this.suggester.suggest(upperCaseLetter)) {
                if (this.suggester.isGuessed()) {
                    this.monitor.computeGuessingWord();
                    if (this.supplier.isAvailable()) {
                        this.suggester.setWord(supplyUpperCaseWord());
                    } else {
                        this.monitor.computeCompletingList();
                    }
                }
            } else {
                this.monitor.computeIncorrectSuggestion();
            }
        }
    }

    private String supplyUpperCaseWord() {
        return this.supplier.supply().toUpperCase();
    }
}
