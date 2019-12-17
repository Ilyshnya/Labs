package com.company.Patterns.FactoryMethodStrategy;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;
import com.company.Patterns.SortStrategy.Strategyimpl.BubbleSortStrategy;

/**
 *  Создает стратегию
 *  пузырьковой сортировки.
 * @param <T> тип который
 *           реализует Comparable
 */
public final class BubbleSortCreator<T extends Comparable> extends Creator<T> {
    @Override
    public ISortStrategy createSortStrategy() {
        return new BubbleSortStrategy<MyList<T>, T>();
    }
}
