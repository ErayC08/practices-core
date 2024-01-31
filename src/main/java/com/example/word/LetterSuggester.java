package com.example.word;

public class LetterSuggester {
    private String word;
    private StringBuilder mutableWord;

    public String getWord() {
        return this.word;
    }

    public String getCensoredWord() {
        return this.mutableWord.toString();
    }

    public void setWord(String word) {
        this.word = word;
        this.mutableWord = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                this.mutableWord.setCharAt(i, '*');
            }
        }
    }

    public boolean suggest(char upperCaseLetter) {
        boolean occurs = false;

        for (int i = 0; i < this.word.length(); i++) {
            if (upperCaseLetter == this.word.charAt(i)) {
                this.mutableWord.setCharAt(i, upperCaseLetter);
            }
        }
        return occurs;
    }

    public boolean isGuessed() {
        for (int i = 0; i < this.mutableWord.length(); i++) {
            if (Character.isLetter(this.mutableWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
