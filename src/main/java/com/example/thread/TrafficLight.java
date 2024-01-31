package com.example.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TrafficLight implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(TrafficLight.class);
    private final Thread thread = new Thread(this);
    private boolean isRunning;
    private State state;

    public TrafficLight(State initialState) {
        state = initialState;
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                TimeUnit.SECONDS.sleep(state.getDuration());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            state = state.getNextState();
            logger.info("The state of traffic light is changed: " + state.name());
        }
    }

    public State getState() {
        return state;
    }

    public void start() {
        if (!thread.isAlive()) {
            if (!isRunning) {
                isRunning = true;
            }
            thread.start();
        }
    }

    public void stop() {
        isRunning = false;
    }

    public enum State {
        RED {
            @Override
            public State getNextState() {
                return GREEN;
            }

            @Override
            public int getDuration() {
                return 15;
            }
        }, YELLOW {
            @Override
            public State getNextState() {
                return RED;
            }

            @Override
            public int getDuration() {
                return 3;
            }
        }, GREEN {
            @Override
            public State getNextState() {
                return YELLOW;
            }

            @Override
            public int getDuration() {
                return 45;
            }
        };

        public abstract State getNextState();

        public abstract int getDuration();
    }
}
