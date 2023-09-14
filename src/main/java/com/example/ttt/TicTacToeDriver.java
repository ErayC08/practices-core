package com.example.ttt;

import com.example.game.GameMonitor;
import com.example.game.GameStatus;

public class TicTacToeDriver {

    private static final char X = 'X';
    private static final char O = 'O';

    public static void main(String[] args) {
        GameMonitor monitor = new GameMonitor();

        while (monitor.getGameStatus() == GameStatus.NONE) {

        }
    }
}
