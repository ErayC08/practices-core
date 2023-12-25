package com.example.game;

public enum GameMove {
    ROCK {
        @Override
        public GameStatus getGameStatus(GameMove counterGameMove) {
            if (counterGameMove == this) {
                return GameStatus.DRAW;
            }
            if (counterGameMove == SCISSORS) {
                return GameStatus.WIN;
            }
            return GameStatus.LOSE;
        }
    }, PAPER {
        @Override
        public GameStatus getGameStatus(GameMove counterGameMove) {
            if (counterGameMove == this) {
                return GameStatus.DRAW;
            }
            if (counterGameMove == ROCK) {
                return GameStatus.WIN;
            }
            return GameStatus.LOSE;
        }
    }, SCISSORS {
        @Override
        public GameStatus getGameStatus(GameMove counterGameMove) {
            if (counterGameMove == this) {
                return GameStatus.DRAW;
            }
            if (counterGameMove == PAPER) {
                return GameStatus.WIN;
            }
            return GameStatus.LOSE;
        }
    };

    public abstract GameStatus getGameStatus(GameMove counterGameMove);

    public GameMove findByName(String name) {
        for (GameMove move : GameMove.values()) {
            if (move.name().equalsIgnoreCase(name)) {
                return move;
            }
        }
        return null;
    }

    public GameMove findByOrdinal(int ordinal) {
        for (GameMove move : GameMove.values()) {
            if (move.ordinal() == ordinal) {
                return move;
            }
        }
        return null;
    }
}
