package com.example.game;

public class Monitor {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public int wins() {
        return this.wins;
    }

    public int losses() {
        return this.losses;
    }

    public int draws() {
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
