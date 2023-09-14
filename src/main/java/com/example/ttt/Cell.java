package com.example.ttt;

public class Cell {
    private final int number;
    private Mark mark;

    public Cell(int number) {
        this.number = number;
        this.mark = Mark.NONE;
    }

    public int getNumber() {
        return number;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public boolean isMarked() {
        return mark == Mark.X || mark == Mark.O;
    }
}
