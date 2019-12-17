package com.company.Patterns.SortStrategy.Strategyimpl;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.Patterns.FactoryMethodStrategy.QuickSortCreator;
import com.company.Patterns.SortStrategy.ContextStrategy;
import com.company.Person.AbstractPerson;
import com.company.Person.PersonComparator.PersonNameComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class QuickSortStrategyTest {

    @Test
    void sort() throws Exception {
        List<Integer> actual=new ArrayList<>();
        AbstractPerson.setComparator(new PersonNameComparator<>());
        ContextStrategy<Integer> context = new ContextStrategy<Integer>(new QuickSortCreator());
        MyArrayList<Integer> expected = new MyArrayList<>();
        for (int i = 6; i >0; i--) {
            actual.add(i);
            expected.add(i);
        }

       // ISortStrategy<MyList<Integer>,Integer> sort;
      // sort = new QuickSortStrategy<>();
        //sort.sort(expected);
        context.doStrategy(expected);
        var test = new ArrayList<Integer>();
        for (int i = 0; i < expected.getSize(); i++) {
            test.add(expected.get(i));
        }
        actual.sort(Integer::compareTo);
        Assertions.assertEquals(test, actual);
    }
}