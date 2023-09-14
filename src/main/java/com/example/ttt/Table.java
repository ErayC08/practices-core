package com.example.ttt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Table {
    private List<Cell> cells;

    public Table() {
        cells = produceCells();
    }

    private List<Cell> produceCells() {
        cells = new ArrayList<>(10);

        for (int i = 1; i < 10; i++) {
            cells.add(i, new Cell(i));
        }
        return cells;
    }

    public Cell getCell(int number) {
        return cells.get(number);
    }

    public Cell getCellNullable(int number) {
        if (1 <= number && number < 10) {
            return cells.get(number);
        }
        return null;
    }

    public Optional<Cell> getCellOptional(int number) {
        if (1 <= number && number < 10) {
            return Optional.of(cells.get(number));
        }
        return Optional.empty();
    }

    // A cell can only be marked when it's not marked yet.
    public boolean markCell(int number, Mark mark) {
        Cell cell = getCell(number);

        if (cell.isMarked()) {
            return false;
        }
        cell.setMark(mark);
        return true;
    }

    public boolean horizontallyMatches(int number) {
        Cell markedCell = getCell(number);

        int matchingCountRightSide = 0;
        int matchingCountLeftSide = 0;

        for (int i = 1; i < 3; i++) {
            Cell nextRightCell = getCellNullable(number + i);

            if (nextRightCell != null && nextRightCell.getMark() == markedCell.getMark()) {
                matchingCountRightSide++;
            }
            Cell nextLeftCell = getCellNullable(number - i);

            if (nextLeftCell != null && nextLeftCell.getMark() == markedCell.getMark()) {
                matchingCountLeftSide++;
            }
        }
        return matchingCountRightSide == 2 || matchingCountLeftSide == 2;
    }

    public boolean verticallyMatches(int number) {
        Cell markedCell = getCell(number);

        int matchingCountUpperSide = 0;
        int matchingCountLowerSide = 0;

        for (int i = 1; i < 3; i++) {
            Cell nextUpperCell = getCellNullable(number - i * 3);

            if (nextUpperCell != null && nextUpperCell.getMark() == markedCell.getMark()) {
                matchingCountUpperSide++;
            }
            Cell nextLowerCell = getCellNullable(number + i * 3);

            if (nextLowerCell != null && nextLowerCell.getMark() == markedCell.getMark()) {
                matchingCountLowerSide++;
            }
        }
        return matchingCountUpperSide == 2 || matchingCountLowerSide == 2;
    }

    public boolean diagonallyMatches(int number) {
        Cell markedCell = getCell(number);

        int matchingCountRightLowerSide = 0;
        int matchingCountLeftLowerSide = 0;
        int matchingCountLeftUpperSide = 0;
        int matchingCountRightUpperSide = 0;

        for (int i = 1; i < 3; i++) {
            Cell nextRightLowerCell = getCellNullable(number + i * 4);

            if (nextRightLowerCell != null && nextRightLowerCell.getMark() == markedCell.getMark()) {
                matchingCountRightLowerSide++;
            }
            Cell nextLeftLowerCell = getCellNullable(number + i * 2);

            if (nextLeftLowerCell != null && nextLeftLowerCell.getMark() == markedCell.getMark()) {
                matchingCountLeftLowerSide++;
            }
            Cell nextLeftUpperCell = getCellNullable(number - i * 4);

            if (nextLeftUpperCell != null && nextLeftUpperCell.getMark() == markedCell.getMark()) {
                matchingCountLeftUpperSide++;
            }
            Cell nextRightUpperCell = getCellNullable(number - i * 2);

            if (nextRightUpperCell != null && nextRightUpperCell.getMark() == markedCell.getMark()) {
                matchingCountRightUpperSide++;
            }
        }
        return matchingCountRightLowerSide == 2 || matchingCountLeftLowerSide == 2 || matchingCountLeftUpperSide == 2 || matchingCountRightUpperSide == 2;
    }
}
