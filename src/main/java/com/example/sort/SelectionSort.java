package com.example.sort;

public class SelectionSort extends Sort {
    public SelectionSort(int[] ints) {
        super(ints);
    }

    @Override
    public void apply() {
        for (int i = 0; i < ints.length; i++) {
            int iMin = i;

            for (int j = i + 1; j < ints.length; j++) {
                if (ints[iMin] > ints[j]) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                swap(iMin, i);
            }
        }
    }
}
