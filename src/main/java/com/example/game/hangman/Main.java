package com.example.game.hangman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String FILE_PATH = "src/main/resources/hangman/names.txt";
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static int remainingLives = 6;
    private static int score = 0;

    public static void main(String[] args) {
        String category = "ANIMALS";
        List<NameWrapper> nameWrappers;
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            nameWrappers = lines.map(NameWrapper::new).filter(nameWrapper -> nameWrapper.getCategory().equals(category)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (!nameWrappers.isEmpty()) {
            String name = nameWrappers.remove(random.nextInt(0, nameWrappers.size())).getName();
            StringBuilder censoredName = new StringBuilder("*".repeat(name.length()));
            log.info("Word: {}, Waiting for the user's response...", censoredName);

            while (charsAnyMatchesWithAsterisk(censoredName.toString())) {
                char c = scanner.nextLine().charAt(0);

                while (!Character.isLetter(c)) {
                    c = scanner.nextLine().charAt(0);
                }
                c = String.valueOf(c).toUpperCase().charAt(0);
                boolean isFound = false;
                for (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) == c) {
                        censoredName.setCharAt(i, c);
                        isFound = true;
                    }
                }
                if (!isFound) {
                    if (--remainingLives == 0) {
                        log.info("Game over. The word was {}. Total Score: {}", name, score);
                        break;
                    } else {
                        log.info("The letter is not found. Word: {}, Remaining lives: {}", censoredName, remainingLives);
                    }
                }
            }
            if (remainingLives == 0) {
                break;
            }
            log.info("Word is found: {}. Next turn...", censoredName);
            score += (remainingLives * 10);
            remainingLives = 6;
        }
        if (nameWrappers.isEmpty()) {
            log.info("All the words are found! Total score: {}", score);
        }
    }

    private static boolean charsAnyMatchesWithAsterisk(String s) {
        return s.chars().anyMatch(value -> value == '*');
    }
}
