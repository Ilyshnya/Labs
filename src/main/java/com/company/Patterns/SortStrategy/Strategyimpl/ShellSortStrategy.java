package com.company.Patterns.SortStrategy.Strategyimpl;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;

/**
 * Предоставляет алгоритм
 * сортировки Шелла.
 *
 * @param <T> Коллекция реализующая
 *            интерфейс MyList с объектами
 *            реализующими интерфейс Comparable.
 * @param <S> объекты коллекции
 *            должны реализовывать
 *            Comparable для сравнения.
 */
public final class ShellSortStrategy<T extends MyList<S>, S extends Comparable>
        implements ISortStrategy<T, S> {

    @Override
    public void sort(final T myList) throws Exception {
        int step = myList.getSize() / 2;
        while (step > 0) {
            int i, j;
            for (i = step; i < myList.getSize(); i++) {
                var value = myList.get(i);
                for (j = i - step;
                     j >= 0 && (myList.get(j).compareTo(value) > 0);
                     j -= step) {
                    myList.set(j + step, myList.get(j));
                }
                myList.set(j + step, value);
            }
            step /= 2;
        }

    }
}
