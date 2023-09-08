package com.example.sort;

public class InsertionSort extends Sort {
    public InsertionSort(int[] ints) {
        super(ints);
    }

    @Override
    public void apply() {
        for (int i = 1; i < ints.length; i++) {
            int j = i;

            while (j > 0 && ints[j - 1] > ints[j]) {
                swap(j - 1, j);
                j--;
            }
        }
    }
}
