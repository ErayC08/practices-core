package com.example.move;

public enum Move {
    ROCK {
        @Override
        public Outcome compareAndGetUnlessDraw(Move counterMove) {
            if (counterMove == SCISSORS) {
                return Outcome.WIN;
            }
            return Outcome.LOSS;
        }
    }, PAPER {
        @Override
        public Outcome compareAndGetUnlessDraw(Move counterMove) {
            if (counterMove == ROCK) {
                return Outcome.WIN;
            }
            return Outcome.LOSS;
        }
    }, SCISSORS {
        @Override
        public Outcome compareAndGetUnlessDraw(Move counterMove) {
            if (counterMove == PAPER) {
                return Outcome.WIN;
            }
            return Outcome.LOSS;
        }
    };

    protected abstract Outcome compareAndGetUnlessDraw(Move counterMove);

    public Outcome compareAndGet(Move counterMove) {
        if (counterMove == null) {
            throw new IllegalArgumentException("The counter move is missing.");
        }
        if (counterMove == this) {
            return Outcome.DRAW;
        }
        return compareAndGetUnlessDraw(counterMove);
    }

    public enum Outcome {
        WIN, LOSS, DRAW
    }
}
