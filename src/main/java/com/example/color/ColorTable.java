package com.example.color;

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

    public Color getColor(int rowIndex, int columnIndex) {
        try {
            return this.colors[rowIndex][columnIndex];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return null;
        }
    }

    public void setColor(int rowIndex, int columnIndex, Color color) {
        if (color == null || color.isNone()) {
            throw new InvalidColorException();
        }
        this.colors[rowIndex][columnIndex] = color;
    }

    public boolean matchesAt(int rowIndex, int columnIndex, int expectedMatchingCount) {
        return horizontallyMatchesAt(rowIndex, columnIndex, expectedMatchingCount) || verticallyMatchesAt(rowIndex, columnIndex, expectedMatchingCount) || diagonallyMatchesAt(rowIndex, columnIndex, expectedMatchingCount);
    }

    public boolean horizontallyMatchesAt(int rowIndex, int columnIndex, int expectedMatchingCount) {
        Color middle = getColor(rowIndex, columnIndex);

        if (middle == null || middle.isNone()) {
            return false;
        }
        int matchingCountEastSide = 1;
        int matchingCountWestSide = 1;

        for (int i = 1; i <= expectedMatchingCount; i++) {
            Color eastern = getColor(rowIndex, columnIndex + i);
            Color western = getColor(rowIndex, columnIndex - i);

            if (eastern == middle) {
                if (expectedMatchingCount == ++matchingCountEastSide) {
                    return true;
                }
            }
            if (western == middle) {
                if (expectedMatchingCount == ++matchingCountWestSide) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticallyMatchesAt(int rowIndex, int columnIndex, int expectedMatchingCount) {
        Color middle = getColor(rowIndex, columnIndex);

        if (middle == null || middle.isNone()) {
            return false;
        }
        int matchingCountSouthSide = 1;
        int matchingCountNorthSide = 1;

        for (int i = 1; i <= expectedMatchingCount; i++) {
            Color southern = getColor(rowIndex + i, columnIndex);
            Color northern = getColor(rowIndex - i, columnIndex);

            if (southern == middle) {
                if (expectedMatchingCount == ++matchingCountSouthSide) {
                    return true;
                }
            }
            if (northern == middle) {
                if (expectedMatchingCount == ++matchingCountNorthSide) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagonallyMatchesAt(int rowIndex, int columnIndex, int expectedMatchingCount) {
        Color middle = getColor(rowIndex, columnIndex);

        if (middle == null || middle.isNone()) {
            return false;
        }
        int matchingCountNorthEastSide = 1;
        int matchingCountSouthEastSide = 1;
        int matchingCountSouthWestSide = 1;
        int matchingCountNorthWestSide = 1;

        for (int i = 1; i <= expectedMatchingCount; i++) {
            Color northEastern = getColor(rowIndex - i, columnIndex + i);
            Color southEastern = getColor(rowIndex + i, columnIndex + i);
            Color southWestern = getColor(rowIndex + i, columnIndex - i);
            Color northWestern = getColor(rowIndex - i, columnIndex - i);

            if (northEastern == middle) {
                if (expectedMatchingCount == ++matchingCountNorthEastSide) {
                    return true;
                }
            }
            if (southEastern == middle) {
                if (expectedMatchingCount == ++matchingCountSouthEastSide) {
                    return true;
                }
            }
            if (southWestern == middle) {
                if (expectedMatchingCount == ++matchingCountSouthWestSide) {
                    return true;
                }
            }
            if (northWestern == middle) {
                if (expectedMatchingCount == ++matchingCountNorthWestSide) {
                    return true;
                }
            }
        }
        return false;
    }

    protected int getRows() {
        return colors.length;
    }

    protected int getColumns() {
        return colors[0].length;
    }
}
