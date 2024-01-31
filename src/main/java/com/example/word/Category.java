package com.example.word;

public enum Category {
    ANIMALS, COUNTRIES;

    public String getFilePath() {
        return "src/main/resources/word/" + this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public static Category findByName(String name) {
        for (Category next : Category.values()) {
            if (next.name().equalsIgnoreCase(name)) {
                return next;
            }
        }
        return null;
    }
}
