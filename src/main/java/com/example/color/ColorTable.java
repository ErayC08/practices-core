package com.example.color;

public class ColorTable {
    private final Color[][] colors;

    public ColorTable(int rows, int columns) {
        colors = new Color[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //The purpose of this is to prevent null-case.
                colors[i][j] = Color.NONE;
            }
        }
    }

    public Color getColor(int rowIndex, int columnIndex) {
        try {
            return colors[rowIndex][columnIndex];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return null;
        }
    }

    public void setColor(int rowIndex, int columnIndex, Color color) {
        if (color == null || color.isNone()) {
            throw new IllegalArgumentException("The color is missing, or neither red nor yellow.");
        }
        colors[rowIndex][columnIndex] = color;
    }

    public boolean hasAdjacencyAt(int rowIndex, int columnIndex, int expectedAdjacencyCount) {
        return hasHorizontalAdjacencyAt(rowIndex, columnIndex, expectedAdjacencyCount) || hasVerticalAdjacencyAt(rowIndex, columnIndex, expectedAdjacencyCount) || hasDiagonalAdjacencyAt(rowIndex, columnIndex, expectedAdjacencyCount);
    }

    public boolean hasHorizontalAdjacencyAt(int rowIndex, int columnIndex, int expectedAdjacencyCount) {
        Color middle = getColor(rowIndex, columnIndex);

        if (middle == null || middle.isNone()) {
            return false;
        }
        int adjacencyCountEastSide = 1;
        int adjacencyCountWestSide = 1;

        for (int i = 1; i <= expectedAdjacencyCount; i++) {
            Color eastern = getColor(rowIndex, columnIndex + i);
            Color western = getColor(rowIndex, columnIndex - i);

            if (eastern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountEastSide) {
                    return true;
                }
            }
            if (western == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountWestSide) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasVerticalAdjacencyAt(int rowIndex, int columnIndex, int expectedAdjacencyCount) {
        Color middle = getColor(rowIndex, columnIndex);

        if (middle == null || middle.isNone()) {
            return false;
        }
        int adjacencyCountSouthSide = 1;
        int adjacencyCountNorthSide = 1;

        for (int i = 1; i <= expectedAdjacencyCount; i++) {
            Color southern = getColor(rowIndex + i, columnIndex);
            Color northern = getColor(rowIndex - i, columnIndex);

            if (southern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountSouthSide) {
                    return true;
                }
            }
            if (northern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountNorthSide) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasDiagonalAdjacencyAt(int rowIndex, int columnIndex, int expectedAdjacencyCount) {
        Color middle = getColor(rowIndex, columnIndex);

        if (middle == null || middle.isNone()) {
            return false;
        }
        int adjacencyCountNorthEastSide = 1;
        int adjacencyCountSouthEastSide = 1;
        int adjacencyCountSouthWestSide = 1;
        int adjacencyCountNorthWestSide = 1;

        for (int i = 1; i <= expectedAdjacencyCount; i++) {
            Color northEastern = getColor(rowIndex - i, columnIndex + i);
            Color southEastern = getColor(rowIndex + i, columnIndex + i);
            Color southWestern = getColor(rowIndex + i, columnIndex - i);
            Color northWestern = getColor(rowIndex - i, columnIndex - i);

            if (northEastern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountNorthEastSide) {
                    return true;
                }
            }
            if (southEastern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountSouthEastSide) {
                    return true;
                }
            }
            if (southWestern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountSouthWestSide) {
                    return true;
                }
            }
            if (northWestern == middle) {
                if (expectedAdjacencyCount == ++adjacencyCountNorthWestSide) {
                    return true;
                }
            }
        }
        return false;
    }
}
