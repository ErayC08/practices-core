package com.example.table;

public class ColorTable {
    private final Color[][] colors;

    public ColorTable(int rows, int columns) {
        this.colors = new Color[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //This is used to prevent null-case.
                this.colors[i][j] = Color.NONE;
            }
        }
    }

    public Color getColor(int rowNum, int colNum) {
        try {
            return this.colors[rowNum - 1][colNum - 1];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return null;
        }
    }

    public void setColor(int rowNum, int colNum, Color color) {
        if (color == null || !color.isPresent()) {
            throw new InvalidColorException();
        }
        try {
            this.colors[rowNum - 1][colNum - 1] = color;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new InvalidRowOrColumnNumberException();
        }
    }

    public boolean identicalColorsExistHorizontally(int rowNum, int colNum, int expectedIdenticalColorsCount) {
        Color color = getColor(rowNum, colNum);
        if (color == null || !color.isPresent()) {
            return false;
        }

        int identicalColorsCountEastSide = 1;
        int identicalColorsCountWestSide = 1;
        for (int i = 0; i < expectedIdenticalColorsCount; i++) {
            if (color == getColor(rowNum, colNum + i + 1)) {
                identicalColorsCountEastSide++;
            }
            if (color == getColor(rowNum, colNum - i - 1)) {
                identicalColorsCountWestSide++;
            }
        }
        return identicalColorsCountEastSide == expectedIdenticalColorsCount || identicalColorsCountWestSide == expectedIdenticalColorsCount;
    }

    public boolean identicalColorsExistVertically(int rowNum, int colNum, int expectedIdenticalColorsCount) {
        Color color = getColor(rowNum, colNum);
        if (color == null || !color.isPresent()) {
            return false;
        }

        int identicalColorsCountSouthSide = 1;
        int identicalColorsCountNorthSide = 1;
        for (int i = 0; i < expectedIdenticalColorsCount; i++) {
            if (color == getColor(rowNum + i + 1, colNum)) {
                identicalColorsCountSouthSide++;
            }
            if (color == getColor(rowNum - i - 1, colNum)) {
                identicalColorsCountNorthSide++;
            }
        }
        return identicalColorsCountSouthSide == expectedIdenticalColorsCount || identicalColorsCountNorthSide == expectedIdenticalColorsCount;
    }

    public boolean identicalColorsExistDiagonally(int rowNum, int colNum, int expectedIdenticalColorsCount) {
        Color color = getColor(rowNum, colNum);
        if (color == null || !color.isPresent()) {
            return false;
        }

        int identicalColorsCountNorthWestSide = 1;
        int identicalColorsCountSouthWestSide = 1;
        int identicalColorsCountSouthEastSide = 1;
        int identicalColorsCountNorthEastSide = 1;
        for (int i = 0; i < expectedIdenticalColorsCount; i++) {
            if (color == getColor(rowNum - i - 1, colNum - i - 1)) {
                identicalColorsCountNorthWestSide++;
            }
            if (color == getColor(rowNum - i - 1, colNum + i + 1)) {
                identicalColorsCountSouthWestSide++;
            }
            if (color == getColor(rowNum + i + 1, colNum + i + 1)) {
                identicalColorsCountSouthEastSide++;
            }
            if (color == getColor(rowNum + i + 1, colNum - i - 1)) {
                identicalColorsCountNorthEastSide++;
            }
        }
        return identicalColorsCountNorthWestSide == expectedIdenticalColorsCount || identicalColorsCountSouthWestSide == expectedIdenticalColorsCount || identicalColorsCountSouthEastSide == expectedIdenticalColorsCount || identicalColorsCountNorthEastSide == expectedIdenticalColorsCount;
    }

    protected int getRows() {
        return colors.length;
    }

    protected int getColumns() {
        return colors[0].length;
    }
}
