package com.example.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordSupplier {
    private final Random random = new Random();
    private final List<String> words;

    public WordSupplier(Category initialCategory) throws IOException {
        this.words = Files.readAllLines(getPath(initialCategory));
    }

    public String supply() {
        return this.words.remove(getRandomIndex());
    }

    public boolean isAvailable() {
        return !this.words.isEmpty();
    }

    private Path getPath(Category category) {
        return Path.of(category.getFilePath());
    }

    private int getRandomIndex() {
        return this.random.nextInt(0, this.words.size());
    }
}
