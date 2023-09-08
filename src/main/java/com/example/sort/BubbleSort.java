package com.example.sort;

public class BubbleSort extends Sort {
    public BubbleSort(int[] ints) {
        super(ints);
    }

    @Override
    public void apply() {
        int length = ints.length;

        while (length > 1) {
            for (int i = 1; i < length; i++) {
                if (ints[i - 1] > ints[i]) {
                    swap(i - 1, i);
                }
            }
            length--;
        }
    }
}
