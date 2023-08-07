package com.example.fi;

import java.util.ArrayList;
import java.util.List;

public class CustomIntegerArrayList {
    private final List<Integer> integerList = new ArrayList<>();

    public Integer get(int index) {
        return integerList.get(index);
    }

    public boolean add(int element) {
        return integerList.add(element);
    }

    public Integer remove(int index) {
        return integerList.remove(index);
    }

    //Applies the consumer on each element
    public void forEach(CustomConsumer<Integer> integerConsumer) {
        for (Integer integer : integerList) {
            integerConsumer.consume(integer);
        }
    }

    //Removes the elements that doesn't fulfill the condition
    public void filter(CustomPredicate<Integer> integerPredicate) {
        for (int i = 0; i < integerList.size(); i++) {
            if (!integerPredicate.test(integerList.get(i))) {
                integerList.remove(i);
            }
        }
    }
}
