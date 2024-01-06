package com.example.game;

public enum Move {
    ROCK {
        @Override
        public Status getStatus(Move otherMove) {
            if (otherMove == this) {
                return Status.DRAW;
            }
            if (otherMove == SCISSORS) {
                return Status.WIN;
            }
            return Status.LOSE;
        }
    }, PAPER {
        @Override
        public Status getStatus(Move otherMove) {
            if (otherMove == this) {
                return Status.DRAW;
            }
            if (otherMove == ROCK) {
                return Status.WIN;
            }
            return Status.LOSE;
        }
    }, SCISSORS {
        @Override
        public Status getStatus(Move otherMove) {
            if (otherMove == this) {
                return Status.DRAW;
            }
            if (otherMove == PAPER) {
                return Status.WIN;
            }
            return Status.LOSE;
        }
    };

    public abstract Status getStatus(Move otherMove);

    public Move findByName(String name) {
        for (Move move : Move.values()) {
            if (move.name().equalsIgnoreCase(name)) {
                return move;
            }
        }
        return null;
    }

    public Move findByOrdinal(int ordinal) {
        for (Move move : Move.values()) {
            if (move.ordinal() == ordinal) {
                return move;
            }
        }
        return null;
    }
}
