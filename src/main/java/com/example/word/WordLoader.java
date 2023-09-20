package com.example.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class WordLoader {

    public List<String> load(WordCategory wordCategory) {
        if (wordCategory == WordCategory.ANIMALS) {
            return loadAnimalWords();
        }
        return null;
    }

    private List<String> loadAnimalWords() {
        Path path = Paths.get("src/main/resources/word/AnimalList");

        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while opening the file");
        }
    }
}
