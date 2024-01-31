package com.example.word;

public class GuessingGameMonitor {
    private final int maximumLifePoints;
    private int lifePoints;
    private int score;
    private Outcome outcome;

    public GuessingGameMonitor(int maximumLifePoints) {
        this.maximumLifePoints = maximumLifePoints;
        this.lifePoints = maximumLifePoints;
        this.score = 0;
        this.outcome = Outcome.NONE;
    }

    public void computeCompletingList() {
        this.outcome = Outcome.WIN;
    }

    public void computeGuessingWord() {
        this.score += (this.lifePoints * 10);
        this.lifePoints = this.maximumLifePoints;
    }

    public void computeIncorrectSuggestion() {
        if (--this.lifePoints == 0) {
            this.outcome = Outcome.LOSS;
        }
    }

    public enum Outcome {
        WIN, LOSS, NONE
    }
}
