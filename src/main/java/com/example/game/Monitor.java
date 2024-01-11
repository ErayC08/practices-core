package com.example.game;

public class Monitor {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getDraws() {
        return this.draws;
    }

    public void updateByStatus(Status status) {
        if (status == Status.WIN) {
            wins++;
        } else if (status == Status.LOSE) {
            losses++;
        } else if (status == Status.DRAW) {
            draws++;
        }
    }
}
