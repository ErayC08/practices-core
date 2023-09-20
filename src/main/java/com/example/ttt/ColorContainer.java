package com.example.ttt;

import java.util.function.Consumer;

public class ColorContainer {

    private Color[][] colors;
    private int filledSlotCount = 0;

    private Color[][] produceColors() {
        colors = new Color[4][4];

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                colors[i][j] = Color.NONE;
            }
        }
        return colors;
    }

    public ColorContainer() {
        colors = produceColors();
    }

    public boolean isFull() {
        return filledSlotCount == 9;
    }

    public boolean containsHorizontalMatch(int j) {
        return isSlotFilled(1, j) && colors[1][j] == colors[2][j] && colors[2][j] == colors[3][j];
    }

    public boolean containsVerticalMatch(int i) {
        return isSlotFilled(i, 1) && colors[i][1] == colors[i][2] && colors[i][2] == colors[i][3];
    }

    public boolean containsDiagonalMatch(int i, int j) {
        if (i == j) {
            return isSlotFilled(1, 1) && colors[1][1] == colors[2][2] && colors[2][2] == colors[3][3];
        }
        if ((i == 1 && j == 3) || (j == 1 && i == 3)) {
            return isSlotFilled(1, 3) && colors[1][3] == colors[2][2] && colors[2][2] == colors[3][1];
        }
        return false;
    }

    public boolean containsMatch(int i, int j) {
        return containsHorizontalMatch(j) || containsVerticalMatch(i) || containsDiagonalMatch(i, j);
    }

    public boolean isSlotFilled(int i, int j) {
        return colors[i][j] == Color.RED || colors[i][j] == Color.YELLOW;
    }

    public boolean fillSlotIfEmpty(int i, int j, Color color) {
        if (isSlotFilled(i, j)) {
            return false;
        }
        colors[i][j] = color;
        filledSlotCount++;
        return true;
    }

    public void fillSlot(int i, int j, Color color) {
        filledSlotCount++;
        colors[i][j] = color;
    }

    //Has no usages, but can be used when practicing with functional interfaces.
    public void computeIfSlotEmpty(int i, int j, Consumer<Color> colorConsumer) {
        if (!isSlotFilled(i, j)) {
            colorConsumer.accept(colors[i][j]);
        }
    }
}
