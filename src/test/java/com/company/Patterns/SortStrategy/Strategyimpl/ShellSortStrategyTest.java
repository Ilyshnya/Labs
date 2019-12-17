package com.company.Patterns.SortStrategy.Strategyimpl;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShellSortStrategyTest {

    @Test
    void sort() throws Exception {
        List<Integer> actual = new ArrayList<>();
        MyList<Integer> expected = new MyArrayList<>();
        for (int i = 6; i > 0; i--) {
            actual.add(i);
            expected.add(i);
        }

        ISortStrategy<MyList<Integer>, Integer> sort;
        sort = new ShellSortStrategy<>();
        sort.sort(expected);
        var test = new ArrayList<Integer>();
        for (int i = 0; i < expected.getSize(); i++) {
            test.add(expected.get(i));
        }
        actual.sort(Integer::compareTo);
        Assertions.assertEquals(test,actual);
    }
}