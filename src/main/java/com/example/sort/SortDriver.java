package com.example.sort;

public class SortDriver {

    public static void main(String[] args) {
        int[] ints = {5, 7, 6, 3, 4, 2};

        BubbleSort bubbleSort = new BubbleSort(ints);

        bubbleSort.apply();

        System.out.println(bubbleSort.getAsString());
    }
}
