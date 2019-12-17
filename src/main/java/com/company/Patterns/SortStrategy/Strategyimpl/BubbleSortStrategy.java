package com.company.Patterns.SortStrategy.Strategyimpl;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;



/**
 * Предоставляет алгоритм
 * сортировки пузырьком.
 *
 * @param <T> Коллекция реализующая
 *            интерфейс MyList
 *            с объектами реализующими
 *            интерфейс Comparable.
 * @param <S> объекты коллекции
 *           должны реализовывать
 *           Comparable для сравнения.
 */
public final class BubbleSortStrategy<T extends MyList<S>, S extends Comparable>
        implements ISortStrategy<T, S> {


    @Override
    public void sort(final T myList) throws Exception {
        for (int i = 1; i < myList.getSize(); i++) {
            for (int j = myList.getSize() - 1; j >= i; j--) {
                if (myList.get(j).compareTo(myList.get(j - 1)) < 0) {
                    var temp = myList.get(j);
                    myList.set(j, myList.get(j - 1));
                    myList.set(j - 1, temp);
                }
            }
        }
    }
}
