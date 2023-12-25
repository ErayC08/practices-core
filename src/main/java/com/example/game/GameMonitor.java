package com.example.game;

import lombok.Getter;

@Getter
public class GameMonitor {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public void updateByStatus(GameStatus status) {
        if (status == GameStatus.WIN) {
            wins++;
        } else if (status == GameStatus.LOSE) {
            losses++;
        } else if (status == GameStatus.DRAW) {
            draws++;
        }
    }
}
