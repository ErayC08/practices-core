package com.example.sort;

public abstract class Sort {
    protected int[] ints;

    public Sort(int[] ints) {
        this.ints = ints;
    }

    public abstract void apply();

    public String getAsString() {
        return getAsString(", ");
    }

    public String getAsString(String separator) {
        StringBuilder builder = new StringBuilder().append(ints[0]);

        for (int i = 1; i < ints.length; i++) {
            builder.append(separator).append(ints[i]);
        }
        return builder.toString();
    }

    public boolean isSorted() {
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] < ints[i - 1]) {
                return false;
            }
        }
        return true;
    }

    protected void swap(int index1, int index2) {
        int c = ints[index1];

        ints[index1] = ints[index2];
        ints[index2] = c;
    }
}
