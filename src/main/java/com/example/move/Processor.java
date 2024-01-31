package com.example.move;

import java.util.Random;
import java.util.Scanner;

public class Processor {
    private final Scanner scanner;
    private final Random random;

    public Processor(Scanner scanner) {
        if (scanner == null) {
            throw new NullPointerException("The scanner is missing.");
        }
        this.scanner = scanner;
        this.random = new Random();
    }

    public Processor() {
        this(new Scanner(System.in));
    }

    public void process() {
        System.out.println("The Rock-Paper-Scissors game has been started. Choose your move by typing its name: ");
        int wins = 0;
        int losses = 0;
        int draws = 0;

        Move next = getItem(scanner.next().toUpperCase());

        while (next != null) {
            Move randomMove = getRandomItem();
            Move.Outcome outcome = next.compareAndGet(randomMove);

            if (outcome == Move.Outcome.WIN) {
                wins++;
            } else if (outcome == Move.Outcome.LOSS) {
                losses++;
            } else {
                draws++;
            }
            System.out.printf("The opponent plays %s.%n", randomMove.name().toLowerCase());
            next = getItem(scanner.next().toUpperCase());
        }
        System.out.printf("Game over. Wins: %d, Losses: %d, Draws: %d%n", wins, losses, draws);
    }

    private Move getRandomItem() {
        //The number 3 is the total number of items.
        return getItem(random.nextInt(0, 3));
    }

    private Move getItem(String capitalizedName) {
        for (Move next : Move.values()) {
            if (next.name().equals(capitalizedName)) {
                return next;
            }
        }
        return null;
    }

    private Move getItem(int ordinal) {
        for (Move next : Move.values()) {
            if (next.ordinal() == ordinal) {
                return next;
            }
        }
        return null;
    }
}
