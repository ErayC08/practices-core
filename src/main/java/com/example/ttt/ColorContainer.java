package com.example.ttt;

public class ColorContainer {

    private Color[][] colors;

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

    public boolean horizontallyMatches(int j) {
        return isColor(1, j) && colors[1][j] == colors[2][j] && colors[2][j] == colors[3][j];
    }

    public boolean verticallyMatches(int i) {
        return isColor(i, 1) && colors[i][1] == colors[i][2] && colors[i][2] == colors[i][3];
    }

    public boolean diagonallyMatches(int i, int j) {
        if (i == j) {
            return isColor(1, 1) && colors[1][1] == colors[2][2] && colors[2][2] == colors[3][3];
        }
        if ((i == 1 && j == 3) || (j == 1 && i == 3)) {
            return isColor(1, 3) && colors[1][3] == colors[2][2] && colors[2][2] == colors[3][1];
        }
        return false;
    }

    private boolean isColor(int i, int j) {
        return colors[i][j] == Color.RED || colors[i][j] == Color.YELLOW;
    }
}
