package com.example.game.hangman;

public class NameWrapper {
    private final String name;
    private final String category;

    public NameWrapper(String s) {
        String[] split = s.split(", ");

        this.name = split[0];
        this.category = split[1];
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
